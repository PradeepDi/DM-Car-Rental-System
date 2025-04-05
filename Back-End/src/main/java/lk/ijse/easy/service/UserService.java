package lk.ijse.easy.service;

import lk.ijse.easy.dto.UserDTO;

import java.util.ArrayList;

public interface UserService {
    ArrayList<UserDTO> getAllRegUsers();
    UserDTO getRegUsers(String username,String password);
}
