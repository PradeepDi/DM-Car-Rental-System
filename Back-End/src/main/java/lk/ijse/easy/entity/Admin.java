package lk.ijse.easy.entity;

import lk.ijse.easy.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin {
    @Id
    private String admin_Id;

    @Embedded
    private Name name;
    private String contact_No;
    private String address;
    private String email;
    private String nic;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
