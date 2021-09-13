package com.manning.junitbook.ch03.webapp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/9/9 10:43 下午
 */
public class DefaultController implements Controller {
    private final Map<String, RequestHandler> requestHandlers = new HashMap<>();

    protected RequestHandler getHandler(Request request) {
        if (!this.requestHandlers.containsKey(request.getName())) {
            String message = "Cannot find handler for request name [" + request.getName() + "]";
            throw new RuntimeException(message);
        }
        return this.requestHandlers.get(request.getName());
    }

    public Response processRequest(Request request) {
        Response response;
        try {
            response = getHandler(request).process(request);
        } catch (Exception exception) {
            response = new ErrorResponse(request, exception);
        }
        return response;
    }

    public void addHandler(Request request, RequestHandler requestHandler) {
        if (this.requestHandlers.containsKey(request.getName())) {
            throw new RuntimeException("A request handler has already been registered for request name [" + request.getName() + "]");
        } else {
            this.requestHandlers.put(request.getName(), requestHandler);
        }
    }
}
