package lk.ijse.easy.embeded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Name {
    private String firstName;
    private String lastName;
}
