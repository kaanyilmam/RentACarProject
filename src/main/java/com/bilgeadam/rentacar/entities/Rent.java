package com.bilgeadam.rentacar.entities;

import com.bilgeadam.rentacar.enums.FuelTank;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name ="rent", schema = "rent")
public class Rent {
        @Id
        @GeneratedValue(generator = "rent_id_generator")
        @SequenceGenerator(name = "rent_id_generator", sequenceName = "rent_id_seq", allocationSize = 1)
        private Integer id;

        @Column(name = "price", scale = 10, precision = 2)
        private BigDecimal price;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Column(name = "start_date")
        private Date startDate;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Column(name = "end_date")
        private Date endDate;

        @Column(name = "kilometers")
        private Integer kilometers;

        @Column(name = "fuel_tank")
        @Enumerated(EnumType.STRING)
        private FuelTank fuelTank;

        @ManyToMany( fetch = FetchType.EAGER)
        @JoinTable(name = "car_rent",
                joinColumns = @JoinColumn(name = "rent_id"),
                inverseJoinColumns = @JoinColumn(name = "car_id"))
        private List<Car> cars;
    }
