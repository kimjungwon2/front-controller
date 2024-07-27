package org.example.mvc;

import org.example.mvc.controller.RequestMethod;

public class HandlerKey {

    private final RequestMethod requestMethod;
    private final String urlPath;

    public HandlerKey(RequestMethod requestMethod, String urlPath){
        this.requestMethod = requestMethod;
        this.urlPath = urlPath;
    }
}
