package EasyWaySolution.database_service.ServiceImpl;

import EasyWaySolution.database_service.Dto.AttendancePermissions;
import EasyWaySolution.database_service.Dto.PermissionDto;
import EasyWaySolution.database_service.Dto.SchoolDto;
import EasyWaySolution.database_service.Dto.StudentPermissions;
import EasyWaySolution.database_service.Entity.Users;
import EasyWaySolution.database_service.FeignService.MailServiceFeignClint;
import EasyWaySolution.database_service.Repository.UsersRepo;
import EasyWaySolution.database_service.Service.UserService;
import EasyWaySolution.database_service.Util.Helper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    Gson gson;
    @Autowired
    MailServiceFeignClint mailServiceFeignClint;

    private BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder(11);

    private static final String PREFIX = "SCH"; // Prefix for school ID
    private static final int NUMBER_LENGTH = 5; // Number of digits for the random number


    @Override
    public Users findByMail(String email) {
        return usersRepo.findByEmail(email);
    }

    @Override
    public String createSchool(SchoolDto schoolDto) {

        if(!Helper.isValidEmail(schoolDto.getEmail())){
            return "Invalid Email !";
        }
        Users user = new Users();
        Users school = usersRepo.findByEmail(schoolDto.getEmail());
        if(school!=null)return "School already exits";

        user.setEmail(schoolDto.getEmail());
        user.setPassword(encoder.encode(schoolDto.getPassword()));
        user.setSchool(true);
        user.setSchoolID(generateSchoolId());
        user.setSchoolName(schoolDto.getSchoolName());
        String permissionsJson = gson.toJson(schoolDto.getPermissions());
        user.setPermission(permissionsJson);
        user.setAddress(gson.toJson(schoolDto.getAddressDTO()));
        Users users = usersRepo.save(user);
        mailServiceFeignClint.newPasswordMail(users.getEmail(), "Password" ,schoolDto.getPassword(),"");
        return "Username , password  and other details are sent on mail";
    }


    public static String generateSchoolId() {

        // Generate a random 5-digit number
        int randomNumber = new Random().nextInt((int) Math.pow(10, NUMBER_LENGTH));

        // Format the random number with leading zeros to ensure it's always 5 digits
        String formattedNumber = String.format("%05d", randomNumber);

        // Combine prefix and formatted number
        return PREFIX + formattedNumber;
    }

}
