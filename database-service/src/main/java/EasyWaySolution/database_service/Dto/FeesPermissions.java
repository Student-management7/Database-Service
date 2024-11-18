package EasyWaySolution.database_service.Dto;

import lombok.Data;

@Data
public class FeesPermissions {
    private boolean viewFees;
    private boolean collectFees;

    FeesPermissions(){
        this.viewFees = false;
        this.collectFees = false;
    }
}
