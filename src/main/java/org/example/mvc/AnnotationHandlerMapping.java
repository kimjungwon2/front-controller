package org.example.mvc;


import org.example.mvc.annotation.RequestMapping;
import org.example.mvc.controller.Controller;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationHandlerMapping implements HandlerMapping{

    private final Object[] basePackage;
    private Map<HandlerKey, AnnotationHandler> handlers = new HashMap<>();

    public AnnotationHandlerMapping(Object... basePackage){
        this.basePackage = basePackage;
    }

    public void initialize(){
        Reflections reflections = new Reflections(basePackage);

        //HomeController
        Set<Class<?>> clazzWithControllerAnnotation = reflections.getTypesAnnotatedWith((Class<? extends Annotation>) Controller.class);

        clazzWithControllerAnnotation.forEach(clazz->
                Arrays.stream(clazz.getDeclaredMethods()).forEach(declaredMethod ->{
                    RequestMapping requestMapping = declaredMethod.getDeclaredAnnotations(RequestMapping.class);

                    Arrays.stream(getRequestMethods(requestMapping))
                            .forEach(requestMethod -> handlers.put(
                                    new HandlerKey(requestMapping.value(), requestMethod),new AnnotationHandler()
                            ));
                })
        );
    }

    private int[] getRequestMethods(RequestMapping requestMapping) {
        return requestMapping.method();
    }

    @Override
    public Object findHandler(HandlerKey handlerKey) {
        return handlers.get(handlerKey);
    }
}
