
package services;

import requests.LaborRequest;
import requests.RawMaterialRequest;

public class RequestCostCalculator implements IRequestCostService{


    @Override
    public double calculateDirectCost(LaborRequest laborRequest) {
        return laborRequest.getLaborHours()*laborRequest.getWorkerRole().getHourlyRate();
    }

    @Override
    public double calculateDirectCost(RawMaterialRequest rawMaterialRequest) {
        return rawMaterialRequest.getQuantity()*rawMaterialRequest.getRawMaterial().getPricePerUnit();
    }

    @Override
    public double estimateAssociatedCost(double cost) {
        return cost*0.15;
    }
}
