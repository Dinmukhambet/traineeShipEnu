package devyellow.controller;

import devyellow.email.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


@Controller
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping("/email")
    public String openEmail(Mail mail){
        return "email";
    }

    @RequestMapping(value = "/sendemail",method = RequestMethod.POST)
    public String sendEmail(final Mail mail){
        mailSender.send(new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
                messageHelper.setTo(mail.getEmailTo());
                messageHelper.setSubject(mail.getSubject());
                messageHelper.setText(mail.getMessage());

                final String attachName =mail.getAttachFile().getOriginalFilename();
                if (!attachName.equals("")){
                    messageHelper.addAttachment(attachName, new InputStreamSource() {
                        @Override
                        public InputStream getInputStream() throws IOException {
                            return mail.getAttachFile().getInputStream();
                        }
                    });
                }
            }
        });
        return "redirect:/";
    }
}
