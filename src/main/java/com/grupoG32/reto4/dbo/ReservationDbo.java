package com.grupoG32.reto4.dbo;

import com.grupoG32.reto4.model.CarModel;
import com.grupoG32.reto4.model.ClientModel;
import com.grupoG32.reto4.model.ScoreModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDbo {
    private int idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status;
    private ScoreModel score;
    private CarModel car;
    private ClientModel client;
}
