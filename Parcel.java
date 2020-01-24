public class Parcel{
    private double parcelCost;
    private ParcelDimensions dimensions;
    private ParcelType type;
    private boolean speedy;
    private double speedyCost;
    private double totalCost;
    private double overweightCost;
    private double weight;
    
    public Parcel(double height, double width, double length, boolean s, double kg){
        dimensions = new ParcelDimensions(height, width, length);
        type = new ParcelType(dimensions);
        speedy = s;
        weight = kg;
        setRate(type);
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
        }
        overweightCost = getOverweightRate(type);
        totalCost = parcelCost + overweightCost;
        if(speedy){
            totalCost = totalCost*2;
        }
    }
    public double getRate(){
        return totalCost;
    }
    
    public double getOverweightRate(ParcelType pt){
        double weightLimit = pt.getWeightLimit();
        double overweight = weight - weightLimit;
        overweightCost = (overweight > 0) ? overweight*2 : 0;
        return overweightCost;
    }
}


