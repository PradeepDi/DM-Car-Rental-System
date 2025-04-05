package lk.ijse.easy.service;

import lk.ijse.easy.dto.AdminDTO;

import java.util.ArrayList;


public interface AdminService {
    void saveAdmin(AdminDTO adminDTO);
    void deleteAdmin(String id);
    void updateAdmin(AdminDTO adminDTO);
    ArrayList<AdminDTO> getAdmin();
}
