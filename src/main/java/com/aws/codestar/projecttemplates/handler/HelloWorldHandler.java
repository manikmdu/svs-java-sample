package com.aws.codestar.projecttemplates.handler;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.aws.codestar.projecttemplates.GatewayResponse;

/**
 * Handler for requests to Lambda function.
 */
public class HelloWorldHandler implements RequestHandler<AwsProxyRequest, Object> {

    public Object handleRequest(final AwsProxyRequest input, final Context context) {
    	
    	Map<String, String> pathParams = input.getPathParameters();
    	
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String message= "Hello World!";
        if (null != pathParams && null != pathParams.get("name")) {
        	message = "Hello "+ pathParams.get("name");
        }
        return new GatewayResponse(new JSONObject().put("Output", message).toString(), headers, 200);
    }
}
