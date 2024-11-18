package EasyWaySolution.database_service.FeignService;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mail-Service" , url = "http://localhost:8082")
public interface MailServiceFeignClint {

    @GetMapping("/sendMail")
     String sendMail(@RequestParam String to, @RequestParam String subject, @RequestParam String text);

    @GetMapping("/send-reset-PasswordMail")
    public String newPasswordMail(@RequestParam String to, @RequestParam String subject, @RequestParam String text , @RequestParam String name);

}
