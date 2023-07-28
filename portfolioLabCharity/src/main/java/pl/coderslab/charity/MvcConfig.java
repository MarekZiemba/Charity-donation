package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("${spring.mail.host}")
    private String fromHost;

    @Value("${spring.mail.port}")
    private int fromPort;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${spring.mail.password}")
    private String withPassword;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/form").setViewName("form");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/validate").setViewName("validate");
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(fromHost);
        mailSender.setPort(fromPort);
        mailSender.setUsername(fromEmail);
        mailSender.setPassword(withPassword);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

}
