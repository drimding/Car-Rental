package org.dreamcatcher.controller;


import org.dreamcatcher.dto.RentalList;
import org.dreamcatcher.service.CarsService;
import org.dreamcatcher.service.ClientService;
import org.dreamcatcher.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by drimcatcher on 07.06.2016.
 */
@Controller
public class Controllers {
    @Autowired
    ClientService clientService;
    @Autowired
    CarsService carsService;
    @Autowired
    RentalService rentalService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home (Model model){
        List<RentalList> mm = rentalService.getAllRentals();
       // System.out.println(mm.get(0));
       model.addAttribute("rentalList", rentalService.getAllRentals());

        return "home";
    }

    @RequestMapping(value = "/create-page", method = RequestMethod.GET)
    public String createPage (Model model){
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("cars", carsService.getAllCars());
        return "create";
    }

    @RequestMapping(value = "/create-rental", method = RequestMethod.POST)
    public String createRental (@RequestParam(value = "client", defaultValue = "") String client, @RequestParam(value = "car", defaultValue = "") String car,
                                @RequestParam(value = "startDate", defaultValue = "") String startDate, @RequestParam(value = "stopDate", defaultValue = "") String stopDate){
        System.out.println(startDate + "  "+ stopDate);
        if(rentalService.setNewRental(client, car, startDate, stopDate)){
            return "redirect:/";
        }
         else
        {
            return "redirect:/create-page";
        }


    }

    @RequestMapping(value = "/create-client", method = RequestMethod.POST)
    public String createClient (@RequestParam(value = "clientName", defaultValue = "") String clientName,
                                @RequestParam(value = "clientAddress", defaultValue = "") String clientAddress){
        clientService.setNewClient(clientName,clientAddress);
    return "redirect:/create-page";
    }

    @RequestMapping(value = "/create-car", method = RequestMethod.POST)
    public String createCar (@RequestParam(value = "carName", defaultValue = "") String carName,
                             @RequestParam(value = "carType", defaultValue = "") String carType,
                             @RequestParam(value = "costDay", defaultValue = "") String costDay){
        carsService.setNewCar(carName, carType);
        return "redirect:/create-page";
    }

    @RequestMapping(value = "/rent-close", method = RequestMethod.POST)
    public String rentalClose (@RequestParam(value = "rClose") String rClose){

        rentalService.rentalClose(rClose);
        return "redirect:/";
    }

    @RequestMapping(value = "/rent-delete", method = RequestMethod.POST)
    public String rentalDelete (@RequestParam(value = "rDelete") String rDelete) {

        rentalService.rentalDelete(rDelete);
        return "redirect:/";

    }

}
