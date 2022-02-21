package com.paycore.creditsystem.service.iml;

import com.paycore.creditsystem.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    @Override
    public void sendMessage(String phone,String message) {
        System.out.println(phone + " numaralı telefona "+message+" mesajı gönderildi.");
    }

}
