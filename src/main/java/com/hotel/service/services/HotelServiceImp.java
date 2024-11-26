package com.hotel.service.services;

import com.hotel.service.exception.ResourceNotFoundException;
import com.hotel.service.model.Hotel;
import com.hotel.service.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImp implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel creatingHotel(Hotel hotel) {

        String string = UUID.randomUUID().toString();
        hotel.setId(string);
        return this.hotelRepository.save(hotel);
    }

    @Override
    public Hotel getById(String hotelId) {
        Hotel hotel = this.hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with Id : " + hotelId + " Not found on the Server"));
        return hotel;
    }

    @Override
    public List<Hotel> getAllHotel() {
        return this.hotelRepository.findAll();
    }

    @Override
    public Hotel updateHotelById(String hotelId, Hotel hotel) {
        return null;
    }

    @Override
    public void deleteHotelById(String hotelId) {

    }
}
