package com.grupoG32.reto4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "Gama")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gama")
    private Integer idGama;
    @Column(length = 45)
    private String name;
    @Column(length = 250)
    private String description;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "gama")
    private List<CarModel> cars;

}
