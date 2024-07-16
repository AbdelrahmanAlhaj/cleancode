package com.refactor.code.smells.duplicate.service;

import com.refactor.code.smells.duplicate.model.Message;
import com.refactor.code.smells.duplicate.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public String getMessage(String key, Locale locale) {
        Optional<Message> message = messageRepository.findById(key);
        if (message.isEmpty()) {
            return "Message not found";
        }
        if (locale.getLanguage().equals(new Locale("en").getLanguage())) {
            return message.get().getMessageEn();
        } else {
            return message.get().getMessageAr();
        }
    }
}
