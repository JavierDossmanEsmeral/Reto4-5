package com.grupoG32.reto4.dbo;

import com.grupoG32.reto4.model.MessageModel;
import com.grupoG32.reto4.model.ReservationModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDbo {
    private int idClient;
    private String name;
    private String email;
    private String password;
    private Byte age;
    private List<MessageModel> messages;

    private List<ReservationModel> reservations;
}

