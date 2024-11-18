package EasyWaySolution.database_service.Dto;

import lombok.Data;

@Data
public class ReportPermissions {
    private boolean viewReports;
    private boolean generateReports;
    private boolean exportReports;

    ReportPermissions(){
        this.viewReports = false;
        this.generateReports = false;
        this.exportReports = false;
    }
}
