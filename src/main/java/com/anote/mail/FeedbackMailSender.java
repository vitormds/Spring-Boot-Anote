package com.anote.mail;

import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMailSender implements FeedbackSender {
    private JavaMailSenderImpl mailSender;

    public FeedbackMailSender(Environment environment){
        mailSender = new JavaMailSenderImpl();

        mailSender.setHost(environment.getProperty("spring.mail.host"));
        mailSender.setPort(Integer.parseInt(environment.getProperty("spring.mail.port")));
        mailSender.setUsername(environment.getProperty("spring.mail.username"));
        mailSender.setPassword(environment.getProperty("spring.mail.password"));
    }

    @Override
    public void sendFeedback(String name, String email, String feedback){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Novo comentário de" + name);
        message.setText(feedback);
        message.setFrom("dev_vitorsouza@hotmail.com");
        

        this.mailSender.send(message);
    }
}
