package lk.ijse.easy.entity;

import lk.ijse.easy.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    private String user_Id;

    @Enumerated(EnumType.STRING)
    private RoleType role_Type;
    private String user_Name;
    private String password;

    public User(RoleType role_Type, String user_Name, String password) {
        this.role_Type = role_Type;
        this.user_Name = user_Name;
        this.password = password;
    }
}
