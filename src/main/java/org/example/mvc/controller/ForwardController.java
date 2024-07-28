package org.example.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller{

    private final String fowardUriPath;

    public ForwardController(String fowardUriPath) {
        this.fowardUriPath = fowardUriPath;
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }
}
