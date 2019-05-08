package com.example.resumegeneratorbackend.testSendGrid;

import com.sendgrid.SendGrid;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SendGridTest {
    private final String SENDGRID_API_KEY = "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";

    public Map<String,String> buildDefaultHeaders() {
        SendGrid sg = new SendGrid(SENDGRID_API_KEY);
        Map<String,String> requestHeaders = new HashMap<String, String>();
        requestHeaders.put("Authorization", "Bearer " + SENDGRID_API_KEY);
        String USER_AGENT = "sendgrid/" + sg.getLibraryVersion() + ";java";
        requestHeaders.put("User-agent", USER_AGENT);
        requestHeaders.put("Accept", "application/json");
        return requestHeaders;
    }

    @Test
    public void testVersion() {
        SendGrid sg = new SendGrid(SENDGRID_API_KEY);
        sg.setVersion("v4");
        Assert.assertEquals(sg.getVersion(), "v4");
    }

    @Test
    public void testLibraryVersion() {
        SendGrid sg = new SendGrid(SENDGRID_API_KEY);
        Assert.assertEquals(sg.getLibraryVersion(), "3.0.0");
    }


    @Test
    public void testInitialization() {
        SendGrid sg = new SendGrid(SENDGRID_API_KEY);
        Assert.assertEquals(sg.getHost(), "api.sendgrid.com");
        Assert.assertEquals(sg.getVersion(), "v3");
        Map<String,String> requestHeaders = buildDefaultHeaders();
        Assert.assertEquals(sg.getRequestHeaders(), requestHeaders);
    }
}
