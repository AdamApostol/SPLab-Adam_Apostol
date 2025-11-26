package com.example.library.pattern.chain;

import com.example.library.pattern.chain.BookRequestHandler;
import java.util.Map;

public class AuthorizationHandler extends BookRequestHandler {

    @Override
    public Object handle(Map<String, Object> request) {
        String operation = (String) request.get("operation");
        System.out.println("AuthorizationHandler: Checking authorization for " + operation);

        boolean authorized = true;

        if (!authorized) {
            System.out.println("AuthorizationHandler: Authorization failed");
            return null;
        }

        System.out.println("AuthorizationHandler: Authorization granted");
        return passToNext(request);
    }
}
