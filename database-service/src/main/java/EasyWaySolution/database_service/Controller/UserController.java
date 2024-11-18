package EasyWaySolution.database_service.Controller;

import EasyWaySolution.database_service.Dto.UserDto;
import EasyWaySolution.database_service.Entity.Users;
import EasyWaySolution.database_service.Repository.UsersRepo;
import EasyWaySolution.database_service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UsersRepo usersRepo;

    @GetMapping("/getByEmail")
    public Users findByMail(@RequestParam String email){
        return userService.findByMail(email);
    }

    @PostMapping("/save")
    public Users saveUser(@RequestBody  UserDto userDto){
        Users users = new Users();
        users.setEmail(userDto.getEmail());
        users.setPassword(userDto.getPassword());
        return usersRepo.save(users);
    }
    @PostMapping("/update")
    public Users updateUser(@RequestBody UserDto userDto){
        Users users = usersRepo.findByEmail(userDto.getEmail());
        users.setPassword(userDto.getPassword());
        return usersRepo.save(users);
    }
    @GetMapping("/getByEmailSchoolID")
    public Users getByEmialOrSchoolID(@RequestParam String  email , @RequestParam String schoolCode){
       return usersRepo.findByEmailOrSchoolID(email ,schoolCode);
    }
    @PostMapping("/save/subUser")
    public Users saveSubUser(@RequestBody Users users){
       return  usersRepo.save(users);
    }

}
