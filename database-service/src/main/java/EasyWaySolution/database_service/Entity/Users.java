package EasyWaySolution.database_service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Users extends BaseEntity {

    @Column(unique = true)
    private String email;
    private String password;
    private String address;
    private boolean isSchool;
    private String schoolID;
    private String schoolName;
    @Lob
    @Column(columnDefinition = "text")
    private String permission;
    @OneToOne
    private FacultyInfo facultyInfo;

}
