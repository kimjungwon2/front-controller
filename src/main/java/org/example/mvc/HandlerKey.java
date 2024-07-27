package org.example.mvc;

import org.example.mvc.controller.RequestMethod;

import java.util.Objects;

public class HandlerKey {

    private final RequestMethod requestMethod;
    private final String urlPath;

    public HandlerKey(RequestMethod requestMethod, String urlPath){
        this.requestMethod = requestMethod;
        this.urlPath = urlPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HandlerKey that)) return false;

        if (requestMethod != that.requestMethod) return false;
        return Objects.equals(urlPath, that.urlPath);
    }

    @Override
    public int hashCode() {
        int result = requestMethod != null ? requestMethod.hashCode() : 0;
        result = 31 * result + (urlPath != null ? urlPath.hashCode() : 0);
        return result;
    }
}
