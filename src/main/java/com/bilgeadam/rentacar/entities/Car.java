package com.bilgeadam.rentacar.entities;

import com.bilgeadam.rentacar.enums.CarBodyType;
import com.bilgeadam.rentacar.enums.Color;
import com.bilgeadam.rentacar.enums.FuelType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "car", schema = "rent")
public class Car {


    @Id
    @GeneratedValue(generator = "car_id_genarator")
    @SequenceGenerator(name = "car_id_generator",sequenceName = "car_id_seq")
    private  Integer id;

    @ManyToOne
    @JoinColumn(name = "model_id",referencedColumnName = "id")
    @JsonBackReference
    private Model model;

    @Column(name = "year")
    private  Integer year;
    @Enumerated(EnumType.STRING)

    private CarBodyType bodyType;
    @Column(name = "fuel_type")
    @Enumerated(EnumType.STRING)

    private FuelType fuelType;
    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private Color color;


   @ManyToMany(fetch = FetchType.LAZY)
    private List<Rent> rents;


}