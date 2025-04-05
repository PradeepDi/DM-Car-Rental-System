package lk.ijse.easy.entity;

import lk.ijse.easy.embeded.Image;
import lk.ijse.easy.embeded.Rate;
import lk.ijse.easy.enums.Availability;
import lk.ijse.easy.enums.CarType;
import lk.ijse.easy.enums.FuelType;
import lk.ijse.easy.enums.TransmissionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    @Id
    private String car_Id;
    private String car_name;
    private String car_brand;

    @Enumerated(EnumType.STRING)
    private CarType type;

    @Embedded
    private Image image;
    private int number_Of_Passengers;

    @Enumerated(EnumType.STRING)
    private TransmissionType transmission_Type;

    @Enumerated(EnumType.STRING)
    private FuelType fuel_Type;

    @Embedded
    private Rate rent_Duration_Price;
    private String price_Extra_KM;
    private String registration_Number;
    private double free_Mileage;
    private String color;

    @Enumerated(EnumType.STRING)
    private Availability car_Availability;
}
