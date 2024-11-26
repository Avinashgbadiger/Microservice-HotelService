package com.hotel.service.controller;

import com.hotel.service.model.Hotel;
import com.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

   @Autowired
   private HotelService hotelService;

    @PostMapping("/save-hotel")
    public ResponseEntity<?> savingHotel(@RequestBody Hotel hotel) {
        Hotel hotel1 = this.hotelService.creatingHotel(hotel);
        return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
    }

    @GetMapping("/all-hotel")
    public ResponseEntity<?> getAllHotel() {
        List<Hotel> allHotel = this.hotelService.getAllHotel();
        return new ResponseEntity<>(allHotel, HttpStatus.FOUND);

    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<?> getHotelById(@PathVariable String hotelId) {
        Hotel byId = this.hotelService.getById(hotelId);
        return new ResponseEntity<>(byId, HttpStatus.FOUND);
    }
}
