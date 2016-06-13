package org.dreamcatcher.service.impl;

import org.dreamcatcher.dao.CarDao;
import org.dreamcatcher.dao.ClientDao;
import org.dreamcatcher.dao.RentalDao;
import org.dreamcatcher.dto.RentalList;
import org.dreamcatcher.entity.Rental;
import org.dreamcatcher.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


/**
 * Created by drimcatcher on 09.06.2016.
 */
@Service
public class RentalServiceImpl implements RentalService {
    @Autowired
    RentalDao rentalDao;
    @Autowired
    CarDao carDao;
    @Autowired
    ClientDao clientDao;

    public List<RentalList> getAllRentals() {
        return rentalDao.findAllRental();
    }

    public boolean setNewRental(String client, String car, String startDate, String stopDate) {
        if(!client.isEmpty() && !car.isEmpty() && !startDate.isEmpty() && !stopDate.isEmpty() ) {
            Integer clientParse = null, carParse = null;
            Calendar startDateParse = Calendar.getInstance();
            Calendar stopDateParse = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            try {
                clientParse = Integer.parseInt(client);
                carParse = Integer.parseInt(car);
                startDateParse.setTime(sdf.parse(startDate));
                stopDateParse.setTime(sdf.parse(stopDate));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            carDao.updateNewRentInCar(carParse, true);
            rentalDao.saveAndFlush(new Rental(startDateParse, stopDateParse, true, carDao.findOne(carParse), clientDao.findOne(clientParse)));
            return true;
        }
        else {
            return false;
        }
    }

    public void rentalClose(String rClose) {
        Integer rCloseParse = Integer.parseInt(rClose);
        if (rentalDao.findRentalStatus(rCloseParse)) {
            carDao.updateNewRentInCar(rentalDao.findCarId(rCloseParse), false);
            rentalDao.setRentalStatus(rCloseParse, false);
        }
    }

    public void rentalDelete(String rDelete) {
        Integer rDeleteParse = Integer.parseInt(rDelete);
        carDao.updateNewRentInCar(rentalDao.findCarId(rDeleteParse), false);
        rentalDao.delete(rDeleteParse);
    }
}
