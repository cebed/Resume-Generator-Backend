package com.example.resumegeneratorbackend.service;


import com.example.resumegeneratorbackend.model.EmailData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Content;
import com.sendgrid.Method;
import com.sendgrid.Personalization;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
public class SendGridServiceImplementation extends Personalization implements SendGridService {

    final private String sendGridApi = "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";


    @JsonProperty(value = "dynamic_template_data")
    private Map<String, Object> dynamicTemplateData;

    @JsonProperty("dynamic_template_data")
    public Map<String, Object> getDynamicTemplateData() {
        if (dynamicTemplateData == null) {
            return Collections.<String, Object>emptyMap();
        }
        return dynamicTemplateData;
    }

    public void addDynamicTemplateData(String key, Object value) {
        if (dynamicTemplateData == null) {
            dynamicTemplateData = new HashMap<String, Object>();
            dynamicTemplateData.put(key, value);
        } else {
            dynamicTemplateData.put(key, value);
        }
    }

    private Mail PersonalizeEmail(EmailData emailData) {

        Mail mail = new Mail();
        SendGridServiceImplementation personalization = new SendGridServiceImplementation();


        /* From information setting */
        Email fromEmail = new Email();
        fromEmail.setName(emailData.getFromName());
        fromEmail.setEmail(emailData.getFromEmail());

        mail.setFrom(fromEmail);
        mail.setSubject(emailData.getEmailSubject());

        /*
         * Personalization setting, we only add recipient info for this particular
         * example
         */

        Email to = new Email();
        to.setName(emailData.getToName());
        to.setEmail(emailData.getToEmail());
        personalization.addTo(to);

        personalization.addHeader("X-Test", "test");
        personalization.addHeader("X-Mock", "true");

        mail.setSubject("hrj");


        /* Substitution value settings */
        //personalization.addSubstitution("%name%", emailData.getToName());
        //personalization.addSubstitution("%from%", emailData.getFromName());

        //mail.addPersonalization(personalization);

        /* Set template id */
        mail.setTemplateId("d-436c164f220543de8f570203c5333ba1");

        /* Reply to setting */
        Email replyTo = new Email();
        replyTo.setName(emailData.getFromName());
        replyTo.setEmail(emailData.getFromEmail());
        mail.setReplyTo(replyTo);

        /* Adding Content of the email */
        Content content = new Content();

        /* Adding email message/body */
        content.setType("text/plain");

        content.setValue("HEJ");
        mail.addContent(content);

        return mail;
    }

    @Override
    public String sendMail(EmailData emailData) {

        SendGridServiceImplementation personalization = new SendGridServiceImplementation();
        //1. Need to create an instance of SendGrid.
        SendGrid sg = new SendGrid(sendGridApi);

        Email from = new Email();
        //finns i konstruktor
        from.setName(emailData.getFromName());
        //finns i konstruktor
        from.setEmail(emailData.getFromEmail());

        String subject = "Forgot password?";

        Email to = new Email();
        to.setName(emailData.getToName());
        to.setEmail(emailData.getToEmail());
        personalization.addTo(to);

        Content content = new Content("text/html", "I'm replacing the <strong>body tag</strong>" + "HELLO WORLD");
        Mail mail = new Mail(from, subject, to, content);

        Email replyTo = new Email();
        replyTo.setName(emailData.getFromName());
        replyTo.setEmail(emailData.getFromEmail());
        mail.setReplyTo(replyTo);

        //personalization.addDynamicTemplateData("-username-", "some blog user");
        //mail.personalization.get(0).addSubstitution("-username-", "Some blog user");
        //mail.addPersonalization(personalization);

        mail.setTemplateId("d-70d215b15d50430283cfa5750aec4012");


        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            //Set endpoint = "mail/send" to send email.
            // This endpoint allows us to delivery email over SendGrid’s v3 Web API.
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            return "Failed to send mail! " + ex.getMessage();
        }
        return "Email is sent Successfully!!";
    }


}
