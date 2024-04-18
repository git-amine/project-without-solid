package project;

import requests.LaborRequest;
import requests.RawMaterialRequest;

import java.util.List;

public class Project {

    private String code;
    private String description;

    List<LaborRequest> laborRequestList;
    List<RawMaterialRequest> rawMaterialRequestList;


    public Project(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LaborRequest> getLaborRequestList() {
        return laborRequestList;
    }

    public void setLaborRequestList(List<LaborRequest> laborRequestList) {
        this.laborRequestList = laborRequestList;
    }

    public List<RawMaterialRequest> getRawMaterialRequestList() {
        return rawMaterialRequestList;
    }

    public void setRawMaterialRequestList(List<RawMaterialRequest> rawMaterialRequestList) {
        this.rawMaterialRequestList = rawMaterialRequestList;
    }

    public double calculateProjectCost(){

        double cost=0;

        for(LaborRequest req:laborRequestList){

            cost+=req.calculateRequestCost();
        }

        for(RawMaterialRequest req:rawMaterialRequestList){

            cost+=req.calculateRequestCost();
        }

        return cost;

    }

}
