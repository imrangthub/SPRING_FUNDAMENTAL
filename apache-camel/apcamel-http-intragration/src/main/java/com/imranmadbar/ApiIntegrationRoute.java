package com.imranmadbar;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ApiIntegrationRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Exception Handling and Retry Policy
        onException(Exception.class)
            .handled(true)
            .log("Error occurred during API call!")
            .setBody(constant("Error in integration"));

        // Define the route for integration
        from("direct:startIntegration")
            // First API Call to get customer information
            .to("http://external-api1.com/customer?bridgeEndpoint=true")
            .log("Customer Info: ${body}")
            .setHeader("customerData", simple("${body}"))

            // Second API Call to get subscription information
            .to("http://external-api2.com/subscription?bridgeEndpoint=true")
            .log("Subscription Info: ${body}")

            // Combine results from both APIs
            .process(exchange -> {
                String customerData = exchange.getIn().getHeader("customerData", String.class);
                String subscriptionData = exchange.getIn().getBody(String.class);

                // Combine responses
                String combinedResponse = "Customer: " + customerData + ", Subscription: " + subscriptionData;
                exchange.getIn().setBody(combinedResponse);
            })
            .log("Combined Response: ${body}");
    }
}
