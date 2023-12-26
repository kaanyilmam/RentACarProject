package com.bilgeadam.rentacar.repository;

import com.bilgeadam.rentacar.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent,Integer> {
    @Query("SELECT r FROM Rent r WHERE r.startDate >= :startDate AND r.endDate <= :endDate")
    List<Rent> getRentalsWithinDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT r FROM Rent r WHERE YEAR(r.startDate) = :year AND MONTH(r.startDate) = :month")
    List<Rent> getRentalsByYearAndMonth(@Param("year") int year, @Param("month") int month);


    @Query("SELECT c.rents FROM Car c WHERE c.id = :carId")
    List<Rent> findAllRentsByCarId(@Param("carId") Integer carId);

    @Query("SELECT r FROM Car c JOIN c.rents r WHERE c.id = :carId AND r.startDate >= :startDate AND r.endDate <= :endDate")
    List<Rent> findRentsByCarAndDateRange(@Param("carId") Integer carId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT COUNT(r) FROM Rent r WHERE YEAR(r.startDate) = :year AND MONTH(r.startDate) = :month")
    Long countRentalsByYearAndMonth(@Param("year") int year, @Param("month") int month);

    @Query("SELECT SUM(DATEDIFF(r.endDate, r.startDate)) FROM Rent r WHERE YEAR(r.startDate) = :year AND MONTH(r.startDate) = :month")
    Integer totalRentalDurationByYearAndMonth(@Param("year") int year, @Param("month") int month);
}
