package net.crunchdroid.batch;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class SmsCtrl {

    private final Service service;

    private SmsSender smsSender;

    @PostMapping("/api/v1/sms")
    public String sendSms(SmsRequest smsRequest) {
        System.out.println(smsRequest.getPhoneNumber());
        System.out.println(smsRequest.getMessage());


        service.sendSms(smsRequest);
        return "pageSms";
    }

}
