package com.refactor.code.smells.duplicate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message", schema = "PUBLIC")
public class Message {
    @Id
    private String code;
    private String messageAr;
    private String messageEn;

    public String getCode() {
        return code;
    }

    public Message setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessageAr() {
        return messageAr;
    }

    public Message setMessageAr(String messageAr) {
        this.messageAr = messageAr;
        return this;
    }

    public String getMessageEn() {
        return messageEn;
    }

    public Message setMessageEn(String messageEn) {
        this.messageEn = messageEn;
        return this;
    }
}
