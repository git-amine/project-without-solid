package requests;

import project.Project;
import resources.WorkerRole;
import services.IRequestCostService;
import services.RequestCostCalculator;

public class LaborRequest {

    private String requestCode;
    private String issueDate;
    private double laborHours;
    private WorkerRole workerRole;
    IRequestCostService iRequestCostService;
    Project project;

    public LaborRequest(){

    }

    public LaborRequest(IRequestCostService iRequestCostService){
        this.iRequestCostService=iRequestCostService;

    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public double getLaborHours() {
        return laborHours;
    }

    public void setLaborHours(double laborHours) {
        this.laborHours = laborHours;
    }

    public WorkerRole getWorkerRole() {
        return workerRole;
    }

    public void setWorkerRole(WorkerRole workerRole) {
        this.workerRole = workerRole;
    }

    public double calculateRequestCost(){

        double direct= iRequestCostService.calculateDirectCost(this);
        double associated=iRequestCostService.estimateAssociatedCost(direct);

        return direct+associated;
    }
}
