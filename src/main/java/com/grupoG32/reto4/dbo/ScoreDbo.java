package com.grupoG32.reto4.dbo;

import com.grupoG32.reto4.model.ReservationModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDbo {
    private int idScore;
    private Integer stars;
}
