package com.bilgeadam.rentacar.entities;

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
@Table(name = "brand",schema = "rent")
public class Brand {
    @Id
    @GeneratedValue(generator = "brand_id_genarator")
    @SequenceGenerator(name = "brand_id_generator",sequenceName = "car_id_seq")
    private  Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "logo")
    private byte[] logo;

    @OneToMany(mappedBy = "brand" , fetch = FetchType.LAZY)
    @JsonManagedReference
    private List <Model> models;


}