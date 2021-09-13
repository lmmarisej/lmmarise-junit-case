package com.manning.junitbook.ch03.webapp;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/9/9 10:46 下午
 */
public class TestDefaultController {
    private DefaultController controller;
    private Request request;
    private RequestHandler handler;

    @Before
    public void initialize() throws Exception {
        controller = new DefaultController();
        request = new SampleRequest();
        handler = new SampleHandler();

        controller.addHandler(request, handler);
    }

    @Test
    public void testAddHandler() {
        RequestHandler handler2 = controller.getHandler(request);
        assertSame("Controller.getHandler must return the samplehandler", handler2, handler);
    }

    @Test
    public void testProcessRequest() {
        Response response = controller.processRequest(request);
        assertNotNull("Must not return a null response", response);
        assertEquals("", new SampleResponse(), response);
    }

    @Test
    public void testProcessRequestAnswersErrorResponse() {
        SampleRequest request = new SampleRequest("testError");
        SampleExceptionHandler handler = new SampleExceptionHandler();
        controller.addHandler(request, handler);
        Response response = controller.processRequest(request);

        assertNotNull("Must not return a null response", response);
        assertEquals(ErrorResponse.class, response.getClass());
    }

    @Test(expected = RuntimeException.class)
    public void testGetHandlerNotDefined() {
        SampleRequest request = new SampleRequest("testNotDefined");

        // the following line is supposed to throw a RuntimeException
        controller.getHandler(request);
    }

    @Test(expected = RuntimeException.class)
    public void testAddRequestDuplicateName() {
        SampleRequest request = new SampleRequest();
        SampleHandler handler = new SampleHandler();

        // the following line is supposed to throw a RuntimeException
        controller.addHandler(request, handler);
    }

    @Test(timeout = 360)
    @Ignore(value = "Skip for now")
    public void testProcessMultipleRequestsTimeout() {
        Request request;
        Response response = new SampleResponse();
        RequestHandler handler = new SampleHandler();
        for (int i = 0; i < 99999; i++) {
            request = new SampleRequest(String.valueOf(i));
            controller.addHandler(request, handler);
            response = controller.processRequest(request);
            assertNotNull(response);
            assertNotSame(ErrorResponse.class, response.getClass());
        }
    }

}
