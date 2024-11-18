package EasyWaySolution.database_service.Repository;

import EasyWaySolution.database_service.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepo extends JpaRepository<Users, UUID> {
    Users findByEmail(String email);
    Users findByEmailOrSchoolID(String email , String schoolID);
}
