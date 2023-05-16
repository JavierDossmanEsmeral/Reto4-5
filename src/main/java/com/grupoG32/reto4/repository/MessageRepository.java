package com.grupoG32.reto4.repository;

import com.grupoG32.reto4.model.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageModel,Integer> {

}
