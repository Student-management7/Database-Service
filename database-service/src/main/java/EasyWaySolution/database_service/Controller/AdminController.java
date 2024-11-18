package EasyWaySolution.database_service.Controller;

import EasyWaySolution.database_service.Dto.SchoolDto;
import EasyWaySolution.database_service.Entity.Users;
import EasyWaySolution.database_service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;


    @PostMapping("/create/school")
    public ResponseEntity<Map<String , String>> CreateSchool(@RequestBody SchoolDto schoolDto){

        return ResponseEntity.ok(Map.of("Message",userService.createSchool(schoolDto)));
    }
}
