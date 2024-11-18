package EasyWaySolution.database_service.Dto;

import lombok.Data;

@Data
public class AddressDTO {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
