package com.refactor.code.smells.duplicate.error;

import com.refactor.code.smells.duplicate.model.ErrorType;
import com.refactor.code.smells.duplicate.service.MessageService;

import java.util.Locale;

public class InvalidProductPriceErrorMessage implements ErrorMessage {
    private final MessageService messageService;

    public InvalidProductPriceErrorMessage(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public String getMessage() {
        return messageService.getMessage(ErrorType.INVALID_PRICE.name(), new Locale("ar"));
    }

}
