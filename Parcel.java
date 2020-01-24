public class Parcel{
    private double parcelCost;
    private ParcelDimensions dimensions;
    private ParcelType type;
    
    public Parcel(double height, double width, double length){
        dimensions = new ParcelDimensions(height, width, length);
        type = new ParcelType(dimensions);
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
    }
    public double getRate(){
        return parcelCost;
    }
}



