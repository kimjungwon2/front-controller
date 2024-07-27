package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.example.mvc.controller.HomeController;
import org.example.mvc.controller.RequestMethod;
import org.example.mvc.controller.UserListController;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping {

    private Map<HandlerKey, Controller> mappings = new HashMap<>();

    void init(){
        mappings.put(new HandlerKey(RequestMethod.GET, "/"), new HomeController());
        mappings.put(new HandlerKey(RequestMethod.GET, "/users"), new HomeController());
    }

    public Controller findHandler(String urlPath){
        return mappings.get(urlPath);
    }
}
