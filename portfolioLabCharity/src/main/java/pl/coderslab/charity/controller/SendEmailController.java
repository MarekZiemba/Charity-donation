package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.charity.service.SendEmailService;

@RestController
@RequestMapping("/mail")
@AllArgsConstructor
public class SendEmailController {

    private SendEmailService sendEmailService;

    @PostMapping("/send")
    public String sendMail(@RequestParam(value = "file", required = false) MultipartFile[] file, String to, String[] cc, String subject, String body) {
        return sendEmailService.sendMail(file, to, cc, subject, body);
    }

}

