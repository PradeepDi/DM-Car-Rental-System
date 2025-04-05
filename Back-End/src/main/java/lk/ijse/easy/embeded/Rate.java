package lk.ijse.easy.embeded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rate {
    private double daily_Rate;
    private double monthly_Rate;
}
