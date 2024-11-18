package EasyWaySolution.database_service.Dto;

import lombok.Data;

@Data
public class SchoolDto {
    private String email;
    private String password;
    private String schoolName;
    private AddressDTO addressDTO;
    private PermissionDto permissions;
}
