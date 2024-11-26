package com.hotel.service.services;

import com.hotel.service.model.Hotel;

import java.util.List;

public interface HotelService {


    Hotel creatingHotel(Hotel hotel);

    Hotel getById(String hotelId);

    List<Hotel> getAllHotel();

    Hotel updateHotelById(String hotelId, Hotel hotel);

    void deleteHotelById(String hotelId);

}
