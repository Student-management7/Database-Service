package EasyWaySolution.database_service.Service;

import EasyWaySolution.database_service.Dto.SchoolDto;
import EasyWaySolution.database_service.Entity.Users;

public interface UserService {

    Users findByMail(String email);

    String createSchool(SchoolDto schoolDto);
}
