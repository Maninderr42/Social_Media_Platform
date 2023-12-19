package com.example.Social_Media_Platform.Service;


import com.example.Social_Media_Platform.Enum.CheckStatus;
import com.example.Social_Media_Platform.Exception.NotFoundException;
import com.example.Social_Media_Platform.Exception.UserDisableException;
import com.example.Social_Media_Platform.Models.Analytic;
import com.example.Social_Media_Platform.Models.Messager;
import com.example.Social_Media_Platform.Models.User;
import com.example.Social_Media_Platform.RequestDTO.AddMessagerRequest;
import com.example.Social_Media_Platform.Respository.AnalyticRespository;
import com.example.Social_Media_Platform.Respository.MessagerRespository;
import com.example.Social_Media_Platform.Respository.UserRespository;
import com.example.Social_Media_Platform.Transformers.MessagerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MessagerService {

    @Autowired
    private MessagerRespository messagerRespository;

    @Autowired
    private AnalyticRespository analyticRespository;
    @Autowired
    private UserRespository userRespository;


    public String addmessage(AddMessagerRequest addMessagerRequest) throws Exception{

        // change input data to Entity Data
        Messager messager= MessagerTransformer.convertDataToModelMessageData(addMessagerRequest);

        // find reciver user in the database
        Optional<User> optionalMessager=userRespository.findUserByUsername(messager.getReciverUserName());

        // find sender user in the database
        Optional<User> optional=userRespository.findUserByUsername(messager.getSendUserName());

        // if reciver not found in the database return Exception message
        if(!optionalMessager.isPresent()){
            throw new NotFoundException("User not found Exception please Enter correct user");
        }

        messager.setDate(new Date());

        User recvier=optionalMessager.get();

        User send=optional.get();

        // if sender or reciver id disable by admin its means you can't send message to anyone
        if(recvier.getStatus()== CheckStatus.DISABLE || send.getStatus()==CheckStatus.DISABLE){
            throw new UserDisableException("user disable by admin Please contact admin team........");
        }

        recvier.getMessages().add(messager);

        send.getMessages().add(messager);

        Analytic analytic=new Analytic();

        // Save user action to the Database
        analytic.setAction("Sending one by one message");
        analytic.setAnalyicId(send.getUserId());
        analytic.setUser(send);

        // save all the data in diffent-diffent tables
        analyticRespository.save(analytic);

        messagerRespository.save(messager);

        userRespository.save(recvier);

        userRespository.save(send);


        return "Message Send to SuccessFully.......";
    }

    public Messager getMessageDetail(Integer messageId) throws Exception {

        Optional<Messager> messagerOptional=messagerRespository.findById(messageId);

        if(messagerOptional.isEmpty()){
             throw new RuntimeException ("message not found");
        }

        Messager messager=messagerOptional.get();
        Analytic analytic=new Analytic();
        analytic.setUser(messager.getUser());
        analytic.setAction("getMessageDetail");
        analytic.setAnalyicId(messageId);

        analyticRespository.save(analytic);


        return messager;
    }
    }



