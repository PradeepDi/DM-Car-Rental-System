package lk.ijse.easy.dto;

import lk.ijse.easy.entity.RegUser;
import lk.ijse.easy.enums.RentRequestType;
import lk.ijse.easy.enums.DriverRequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentDTO {
    private String rentID;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private LocalDate returnDate;
    private LocalTime returnTime;
    private DriverRequestType driverRequestType;
    private RentRequestType rentType;
    private String location;
    private RegUserDTO regUser;
    private List<RentDetailsDTO> rentDetails;
}
