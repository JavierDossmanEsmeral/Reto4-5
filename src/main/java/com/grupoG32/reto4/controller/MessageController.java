package com.grupoG32.reto4.controller;

import com.grupoG32.reto4.dbo.GamaDbo;
import com.grupoG32.reto4.dbo.MessageDbo;
import com.grupoG32.reto4.model.ClientModel;
import com.grupoG32.reto4.model.GamaModel;
import com.grupoG32.reto4.model.MessageModel;
import com.grupoG32.reto4.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(value = "*")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("/all")
    public List<MessageModel> obtener(){
        return messageService.obtener();
    }

    @GetMapping("/{id}")
    Optional<MessageModel> obtenerPorId(@PathVariable int id){
        return messageService.obtenerPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody MessageModel message){
        messageService.crear(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        messageService.eliminar(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody MessageDbo messageInput){
        messageService.actualizar(messageInput);
    }
}
