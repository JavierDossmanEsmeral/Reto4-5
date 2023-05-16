package com.grupoG32.reto4.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message")
    private Integer idMessage;
    @Column(name = "message_text",length = 250)
    private String messageText;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_car", nullable = true)
    @JsonIgnoreProperties({"messages","reservations"})
    private CarModel car;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_client", nullable = true)
    @JsonIgnoreProperties({"messages","reservations"})
    private ClientModel client;
}
