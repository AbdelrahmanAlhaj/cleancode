package com.refactor.code.smells.duplicate.error;

import com.refactor.code.smells.duplicate.model.ErrorType;
import com.refactor.code.smells.duplicate.model.Message;
import com.refactor.code.smells.duplicate.repository.MessageRepository;

public class DuplicateProductErrorMessage implements ErrorMessage {
    private MessageRepository messageRepository;

    @Override
    public String getMessage() {
        return messageRepository.findById(ErrorType.DUPLICATE_PRODUCT.name()).orElse(new Message()).getMessageAr();
//        return "Product with the same name already exists";
    }

}
