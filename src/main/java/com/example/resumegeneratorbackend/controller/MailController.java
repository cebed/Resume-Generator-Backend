package com.example.resumegeneratorbackend.controller;

import com.example.resumegeneratorbackend.model.ChangePassword;
import com.example.resumegeneratorbackend.model.Users;
import com.example.resumegeneratorbackend.service.UserService;
import com.example.resumegeneratorbackend.utility.RandomString;
import com.sendgrid.*;
import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
@RestController
@CrossOrigin
@RequestMapping("api/email")
public class MailController {


    @Autowired
    UserService usersService;

    @PostMapping("/pass")
    public String ind(@RequestBody ChangePassword email) throws IOException {
        String generatedValue = RandomString.getAlphaNumericString(10);
        Users users = usersService.findByEmail(email.getToEmail());
        users.setPassword(generatedValue);
        usersService.updateUserInformatio(users, users.getId());
        Email from = new Email();
        from.setEmail("nurhusein11@gmail.com");
        Email to = new Email();
        to.setEmail(email.getToEmail());
        String subject = "Forgot password From Front Edge";
        Content content = new Content("text/plain", "Here is your code to login in Front-Ege IT Resume Page : \n" +generatedValue);
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
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
        return "success to send an email";
    }
}
