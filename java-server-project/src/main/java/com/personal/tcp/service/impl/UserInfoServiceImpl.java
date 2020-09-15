package com.personal.tcp.service.impl;

import com.personal.tcp.entities.message.Message;
import com.personal.tcp.entities.message.type.UserMessage;
import com.personal.tcp.repository.MessageRepository;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.util.HexConverter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UserInfoServiceImpl implements CoreService {

    private final MessageRepository repository;

    public UserInfoServiceImpl() {
        this.repository = new MessageRepository();
    }

    @Override
    public byte[] process(byte[] input) {
        System.out.println("[SERVER] - UserInfo Message");

        UserMessage message = new UserMessage(input);
        repository.saveUserInfoMessage(message.getData());

        return HexConverter.getByteArrayFromString(Message.getAckResponse());
    }

}