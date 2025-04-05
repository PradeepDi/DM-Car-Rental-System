package lk.ijse.easy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Lombok annotation to automatically generate getters, setters, equals, hashCode, and toString methods
@Data
// Lombok annotation to generate a no-args constructor
@NoArgsConstructor
// Lombok annotation to generate a constructor with all arguments
@AllArgsConstructor
// Lombok annotation to generate a toString method
@ToString
public class CustomDTO {

    // Field to hold a string value (e.g., an ID or a label)
    private String value;

    // Field to hold a numerical count (e.g., number of items, users, etc.)
    private int count;

    // Custom constructor to initialize only the 'value' field
    public CustomDTO(String lastIndex) {
        this.value = lastIndex;
    }

    // Custom constructor to initialize only the 'count' field
    public CustomDTO(int count) {
        this.count = count;
    }
}
