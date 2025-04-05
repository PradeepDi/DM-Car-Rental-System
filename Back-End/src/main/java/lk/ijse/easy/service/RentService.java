package lk.ijse.easy.service;

import lk.ijse.easy.dto.CustomDTO;
import lk.ijse.easy.dto.RentDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;


public interface RentService {
    void bookingCars(@RequestBody RentDTO dto);
    void deleteRent(String id);
    String generateRentId();
    CustomDTO getNumberOfBookings();
    CustomDTO getSumOfBookingActive();
    ArrayList<RentDTO> getAllRents();
    void bookingConfirm(String rentID, String driverId);
    void bookingReject(String rentID, String driverId);
}
