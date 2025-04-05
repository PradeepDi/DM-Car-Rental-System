package lk.ijse.easy.controller;

import lk.ijse.easy.service.UserService;
import lk.ijse.easy.util.Current;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController // Marks this class as a REST controller
@CrossOrigin // Enables Cross-Origin Resource Sharing (CORS) for this controller
@RequestMapping("/user") // Base URL mapping for all endpoints in this controller
public class UserController {

    @Autowired
    UserService service; // Injects the UserService for business logic

    // ========== Retrieve All Registered Users ==========
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRegUser() {
        System.out.println(service.getAllRegUsers()); // Debug print of users list (optional for development)
        return new ResponseUtil("OK", "Successfully Loaded..!", service.getAllRegUsers());
    }

    // ========== Authenticate User and Store in Current Context ==========
    // Takes username and password as request parameters
    @GetMapping(params = {"username"})
    public ResponseUtil setUser(String username, String password) {
        Current.currentUser = service.getRegUsers(username, password); // Stores authenticated user in static context
        return new ResponseUtil("OK", "Successfully Loaded..!", "");
    }

    // ========== Get the Currently Authenticated User ==========
    @GetMapping(path = "current")
    public ResponseUtil getCurrentUser() {
        return new ResponseUtil("OK", "Successfully Loaded..!", Current.currentUser);
    }
}
