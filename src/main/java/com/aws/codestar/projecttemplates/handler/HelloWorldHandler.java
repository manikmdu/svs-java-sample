package com.aws.codestar.projecttemplates.handler;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;


import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.aws.codestar.projecttemplates.GatewayResponse;

/**
 * Handler for requests to Lambda function.
 */
public class HelloWorldHandler implements RequestHandler<APIGatewayProxyRequestEvent, Object> {

    public Object handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
    	
    	Map<String, String> queryParams = input.getQueryStringParameters();
    	
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String message= "Hello World!";
        if (null != queryParams && null != queryParams.get("name")) {
        	message = "Hello "+ queryParams.get("name");
        }
        return new GatewayResponse(new JSONObject().put("Output", message).toString(), headers, 200);
    }
}
