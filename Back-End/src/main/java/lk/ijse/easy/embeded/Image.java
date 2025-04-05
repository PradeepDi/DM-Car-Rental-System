package lk.ijse.easy.embeded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    private String front_View;
    private String back_View;
    private String side_View;
    private String interior;
}
