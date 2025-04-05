package lk.ijse.easy.service;

import lk.ijse.easy.dto.CustomDTO;
import lk.ijse.easy.dto.RegUserDTO;

import java.util.ArrayList;


public interface RegUserService {
    void saveRegUser(RegUserDTO regUserDTO);
    void deleteRegUser(String id);
    void updateRegUser(RegUserDTO regUserDTO);
    ArrayList<RegUserDTO> getAllRegUsers();
    String generateCustomerId();
    CustomDTO getSumOfUsers();
}
