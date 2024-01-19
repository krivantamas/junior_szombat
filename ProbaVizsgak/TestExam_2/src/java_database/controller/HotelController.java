package java_database.controller;

import java_database.repository.RoomRepository;
import java_database.view.Hotel;

public class HotelController {


    public HotelController(){
        RoomRepository roomRepository = new RoomRepository();

        Hotel hotel = new Hotel(roomRepository);
        hotel.setVisible(true);
    }



}
