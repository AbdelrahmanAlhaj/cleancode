package com.refactor.code.smells.duplicate.repository;

import com.refactor.code.smells.duplicate.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, String> {
}
