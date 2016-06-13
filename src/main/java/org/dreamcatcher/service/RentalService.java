package org.dreamcatcher.service;

import org.dreamcatcher.dto.RentalList;

import java.util.List;

/**
 * Created by drimcatcher on 09.06.2016.
 */
public interface RentalService {

    List<RentalList> getAllRentals();

    boolean setNewRental(String client, String car, String startDate, String stopDate);

    void rentalClose(String rClose);

    void rentalDelete(String rDelete);
}
