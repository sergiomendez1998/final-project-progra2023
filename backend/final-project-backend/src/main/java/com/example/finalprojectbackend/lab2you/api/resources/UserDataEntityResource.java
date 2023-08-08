package com.example.finalprojectbackend.lab2you.api.resources;
import com.example.finalprojectbackend.lab2you.controllers.UserManagementServiceProcessingController;
import com.example.finalprojectbackend.lab2you.db.model.User;
import com.example.finalprojectbackend.lab2you.controllers.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class UserDataEntityResource {

    private final EmailService emailService;

    @Autowired
    public UserDataEntityResource(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            emailService.sendRegistrationEmail(user);
            return ResponseEntity.ok("Lab2YouConstants.lab2YouSuccessCodes.EMAIL_SENT.getMessage()");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lab2YouConstants.EMAIL_NOT_SENT.getMessage()");
        }
    }

    @GetMapping("/userList")
    public ResponseEntity<List<User>> userList(){
        try {
            //return user list but with no password


            UserManagementServiceProcessingController userManagementServiceProcessingController = new UserManagementServiceProcessingController();
//            userManagementServiceProcessingController.validateForRead();

            List<User> userList =User.users
                            .stream()
                            .map(newUser -> new User(
                                    newUser.getName(),
                                    newUser.getLastName(),
                                    newUser.getEmail()
                                    )
                            ).toList();

            return ResponseEntity.status(HttpStatus.OK).body(userList);

        } catch (Exception e) {
            String errorMessage = "An error occurred while fetching user data.";
            HttpHeaders headers = new HttpHeaders();
            headers.add("X-Error-Message", errorMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .headers(headers)
                    .body(null);
        }

    }

}
