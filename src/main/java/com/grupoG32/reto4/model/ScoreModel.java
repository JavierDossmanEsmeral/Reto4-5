package com.grupoG32.reto4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Score")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_score")
    private Integer idScore;
    private Integer stars;

}
