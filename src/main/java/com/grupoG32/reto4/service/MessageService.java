package com.grupoG32.reto4.service;

import com.grupoG32.reto4.dbo.MessageDbo;
import com.grupoG32.reto4.model.GamaModel;
import com.grupoG32.reto4.model.MessageModel;
import com.grupoG32.reto4.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;
    public List<MessageModel> obtener(){
        return messageRepository.findAll();
    }
    public void crear(MessageModel message){
        messageRepository.save(message);
    }
    public void eliminar(int id){
        messageRepository.deleteById(id);
    }
    public void actualizar(MessageDbo messageInput) {
        Optional<MessageModel> messageDb = messageRepository.findById(messageInput.getIdMessage());
        if(messageDb.isPresent()){
            MessageModel message = messageDb.get();
            if(messageInput.getMessageText() != null){
                message.setMessageText(messageInput.getMessageText());
            }
            if(messageInput.getCar() != null){
                message.setCar(messageInput.getCar());
            }
            if(messageInput.getClient() != null){
                message.setClient(messageInput.getClient());
            }
            messageRepository.save(message);
        }
    }
    public Optional<MessageModel> obtenerPorId(int id) {
        return messageRepository.findById(id);
    }
}
