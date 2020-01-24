public class Parcel{
    private double parcelCost;
    private ParcelDimensions dimensions;
    private ParcelType type;
    private boolean speedy;
    private double speedyCost;
    private double totalCost;
    private double overweightCost;
    private double weight;
    
    public Parcel(double height, double width, double length, double kg){
        dimensions = new ParcelDimensions(height, width, length);
        weight = kg;
        type = new ParcelType(dimensions, weight);
    }
    
    public void setRate(ParcelType pt){
        switch(pt.getTypeInt()){
            case 0:
                parcelCost = 3;
                break;
            case 1:
                parcelCost = 8;
                break;
            case 2:
                parcelCost = 15;
                break;
            case 3:
                parcelCost = 25;
                break;
            case 4:
                parcelCost = 50;
                break;
        }
        overweightCost = getOverweightRate(type);
        totalCost = parcelCost + overweightCost;
    }
    public double getRate(){
        return totalCost;
    }
    
    public double getOverweightRate(ParcelType pt){
        double weightLimit = pt.getWeightLimit();
        double overweight = weight - weightLimit;
        if(pt.getTypeInt() == 4){
             overweightCost = (overweight > 0) ? overweight : 0;
        }
       else{
            overweightCost = (overweight > 0) ? overweight*2 : 0;
       }
        return overweightCost;
    }
    
    public ParcelType getParcelType(){
        return type;
    }
}


