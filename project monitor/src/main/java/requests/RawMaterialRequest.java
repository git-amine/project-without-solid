package requests;

import project.Project;
import resources.RawMaterial;
import services.IRequestCostService;
import services.RequestCostCalculator;

import java.util.Date;

public class RawMaterialRequest {

    private String requestCode;
    private String issueDate;
    private double quantity;
    private RawMaterial rawMaterial;
    IRequestCostService iRequestCostService;
    Project project;

    public RawMaterialRequest(){}

    public RawMaterialRequest(IRequestCostService iRequestCostService){

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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public RawMaterial getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(RawMaterial rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    public double calculateRequestCost(){

        double direct= iRequestCostService.calculateDirectCost(this);
        double associated=iRequestCostService.estimateAssociatedCost(direct);

        return direct+associated;
    }
}
