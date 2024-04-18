package services;

import requests.LaborRequest;
import requests.RawMaterialRequest;

public interface IRequestCostService {

    public double calculateDirectCost(LaborRequest laborRequest);
    public double calculateDirectCost(RawMaterialRequest rawMaterialRequest);
    public double estimateAssociatedCost(double cost);

}
