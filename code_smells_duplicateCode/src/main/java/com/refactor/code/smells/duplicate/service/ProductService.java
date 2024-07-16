package com.refactor.code.smells.duplicate.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.refactor.code.smells.duplicate.error.DuplicateProductErrorMessage;
import com.refactor.code.smells.duplicate.error.InvalidProductPriceErrorMessage;
import com.refactor.code.smells.duplicate.exception.ApplicationException;
import com.refactor.code.smells.duplicate.exception.DuplicateProductException;
import com.refactor.code.smells.duplicate.exception.InvalidProductPriceException;
import com.refactor.code.smells.duplicate.model.ErrorType;
import com.refactor.code.smells.duplicate.model.Product;

import java.util.Locale;

@Service
public class ProductService {

    private final MessageService messageService;

    public ProductService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void createProduct(Product product) throws ApplicationException {
        ErrorType errorType = ErrorType.INVALID_PRICE;
        String message;
        if (ErrorType.INVALID_PRICE.equals(errorType)) {
            message = new InvalidProductPriceErrorMessage(messageService).getMessage();
//            message = messageService.getMessage(ErrorType.INVALID_PRICE.name(), new Locale("ar"));
            throw new InvalidProductPriceException(message, HttpStatus.BAD_REQUEST.value(), errorType);
        } else {
            message = new DuplicateProductErrorMessage().getMessage();
            throw new DuplicateProductException(message, HttpStatus.BAD_REQUEST.value(), ErrorType.DUPLICATE_PRODUCT);
        }
    }

}
