package com.example.resumegeneratorbackend.controller;
import com.example.resumegeneratorbackend.model.EmailData;
import com.example.resumegeneratorbackend.model.Emailh;
import com.example.resumegeneratorbackend.model.Users;
import com.example.resumegeneratorbackend.repository.UsersRepository;
import com.example.resumegeneratorbackend.service.SendGridService;
import com.example.resumegeneratorbackend.service.UserService;
import com.sendgrid.*;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * Simple Controller class to handle HTTP request.
 *
 * @author Daniel Cebe
 *
 */

@RestController
public class MailController {


    @Autowired
    SendGridService sendGridService;

    @Autowired
    UserService usersService;


    @RequestMapping(value = "/email/", method = RequestMethod.POST)
    public String index(@RequestBody EmailData emailData) {
        String response = sendGridService.sendMail(emailData);
        return response;
    }
    @RequestMapping(value = "/emai/", method = RequestMethod.POST)
    public String ind (Emailh email) throws IOException{
        System.out.println("##############################" + email.getFromEmail());

        Email from = new Email();
        from.setEmail("Daniel_97_c@hotmail.com");

        Email to = new Email();
       to.setEmail("nurhusein11@gmail.com");
        String subject = "Forgot password";
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);



        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }


        return "hej";
    }






}
