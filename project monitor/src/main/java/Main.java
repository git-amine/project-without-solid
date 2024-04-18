import project.Project;
import requests.LaborRequest;
import requests.RawMaterialRequest;
import resources.RawMaterial;
import resources.WorkerRole;
import services.IRequestCostService;
import services.RequestCostCalculator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){


        // Create Project
        Project project=new Project();

        // Create Resources

        RawMaterial steel= new RawMaterial();
        RawMaterial concrete= new RawMaterial();

        steel.setPricePerUnit(50);
        concrete.setPricePerUnit(20);

        WorkerRole contruction=new WorkerRole();

        contruction.setHourlyRate(10);

        RequestCostCalculator requestCostCalculator= new RequestCostCalculator();

        // Create Requests and Inject the cost calculator dependency
        RawMaterialRequest steelRequest= new RawMaterialRequest(requestCostCalculator);
        steelRequest.setRawMaterial(steel);
        steelRequest.setProject(project);
        steelRequest.setQuantity(100);

        RawMaterialRequest concreteRequest=new RawMaterialRequest(requestCostCalculator);
        concreteRequest.setRawMaterial(concrete);
        concreteRequest.setProject(project);
        concreteRequest.setQuantity(50);

        LaborRequest constructionWorkerRequest= new LaborRequest(requestCostCalculator);
        constructionWorkerRequest.setWorkerRole(contruction);
        constructionWorkerRequest.setProject(project);
        constructionWorkerRequest.setLaborHours(200);

        List<LaborRequest> laborRequestList= new ArrayList<>();
        List<RawMaterialRequest> rawMaterialRequestList=new ArrayList<>();



        project.setLaborRequestList(laborRequestList);
        project.setRawMaterialRequestList(rawMaterialRequestList);

        // Add requests to the project
        project.getLaborRequestList().add(constructionWorkerRequest);
        project.getRawMaterialRequestList().add(steelRequest);
        project.getRawMaterialRequestList().add(concreteRequest);

        // Calculate project cost
        System.out.println("Current Project cost : \n");
        System.out.println(project.calculateProjectCost());


    }

}
