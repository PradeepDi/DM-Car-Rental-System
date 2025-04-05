package lk.ijse.easy.controller;

import lk.ijse.easy.dto.RegUserDTO;
import lk.ijse.easy.dto.UserDTO;
import lk.ijse.easy.embeded.Name;
import lk.ijse.easy.service.RegUserService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static lk.ijse.easy.enums.RoleType.REGISTERED_USER;

@RestController // Marks this class as a REST controller
@CrossOrigin // Allows cross-origin requests (CORS)
@RequestMapping("/customer") // Base path for all endpoints in this controller
public class RegUserController {

    @Autowired
    private RegUserService service; // Injects the RegUserService

    // ========== Register a New User ==========
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveRegUser(@ModelAttribute RegUserDTO regUserDTO, @ModelAttribute UserDTO userDTO, @ModelAttribute Name name) {
        regUserDTO.setUser(userDTO); // Set embedded User data
        regUserDTO.setName(name);    // Set embedded Name data
        service.saveRegUser(regUserDTO); // Save user using the service
        return new ResponseUtil("OK", "Successfully Registered..!", null);
    }

    // ========== Get All Registered Users ==========
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRegUser() {
        return new ResponseUtil("OK", "Successfully Loaded..!", service.getAllRegUsers());
    }

    // ========== Delete a Registered User by ID ==========
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(params = {"user_Id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteRegUser(@RequestParam(name = "user_Id") String id) {
        service.deleteRegUser(id);
        return new ResponseUtil("OK", "Successfully Deleted..! : " + id, null);
    }

    // ========== Update an Existing Registered User ==========
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(path = "/update")
    public ResponseUtil updateRegUser(@ModelAttribute RegUserDTO regUserDTO, @ModelAttribute UserDTO userDTO, @ModelAttribute Name name) {
        regUserDTO.setUser(userDTO);
        regUserDTO.setName(name);
        regUserDTO.getUser().setRole_Type(REGISTERED_USER); // Ensure role type is REGISTERED_USER
        service.updateRegUser(regUserDTO);
        return new ResponseUtil("OK", "Successfully Updated..! : " + regUserDTO.getUser_Id(), null);
    }

    // ========== Generate a New Customer ID ==========
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/generateCustomerId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateCustomerId() {
        return new ResponseUtil("OK", "Successfully Generated ID..!", service.generateCustomerId());
    }

    // ========== Get Total Number of Registered Users ==========
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/numberOfUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getSumOfUsers() {
        return new ResponseUtil("OK", "Successfully Loaded Count..!", service.getSumOfUsers());
    }
}
