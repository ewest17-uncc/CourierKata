public class Parcel{
    private double parcelCost;
    private ParcelDimensions dimensions;
    private ParcelType type;
    private boolean speedy;
    private double speedyCost;
    private double totalCost;
    
    public Parcel(double height, double width, double length, boolean s){
        dimensions = new ParcelDimensions(height, width, length);
        type = new ParcelType(dimensions);
        speedy = s;
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
        if(speedy){
            speedyCost = parcelCost;
        }
        else{
            speedyCost = 0;
        }
        totalCost = parcelCost + speedyCost;
    }
    public double getRate(){
        return totalCost;
    }
}



