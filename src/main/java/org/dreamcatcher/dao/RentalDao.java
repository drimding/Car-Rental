package org.dreamcatcher.dao;

import org.dreamcatcher.entity.Rental;
import org.dreamcatcher.dto.RentalList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created by drimcatcher on 07.06.2016.
 */
public interface RentalDao extends JpaRepository<Rental, Integer> {
    @Query("SELECT new org.dreamcatcher.dto.RentalList(r.id, r.rentDate, r.returnDate, r.rentalClose, c.name, cl.name, c.type) " +
            "FROM Rental r JOIN r.car c JOIN r.client cl ORDER BY r.rentalClose DESC")
    List<RentalList> findAllRental();

    @Query("SELECT r.car.id FROM Rental r where r.id=?1")
    Integer findCarId(Integer rentID);

    @Transactional
    @Modifying
    @Query("UPDATE Rental r SET r.rentalClose=?2 WHERE r.id=?1")
    void setRentalStatus(Integer id, boolean status);

    @Query("SELECT r.rentalClose FROM Rental r WHERE r.id = ?1")
    boolean findRentalStatus(Integer id);
}
