package com.example.Social_Media_Platform.Transformers;

import com.example.Social_Media_Platform.Models.Messager;
import com.example.Social_Media_Platform.RequestDTO.AddMessagerRequest;

public class MessagerTransformer {

    public static Messager convertDataToModelMessageData(AddMessagerRequest addMessagerRequest){

        Messager messager= Messager.builder()
                .messagerId(addMessagerRequest.getMessagerId())
                .sendUserName(addMessagerRequest.getSendUserName())
                .reciverUserName(addMessagerRequest.getReciverUserName())
                .text(addMessagerRequest.getText())
                .build();

        return messager;


    }
}
