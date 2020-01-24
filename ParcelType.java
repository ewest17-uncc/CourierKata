public class ParcelType{
    private String type;
    private int typeInt;
    private double largest;

    public ParcelType(ParcelDimensions pd){
        double largest = pd.getLargestDimension();
        if(largest < 10){
            type = "Small";
            typeInt = 0;
        }
        else if(largest < 50){
            type = "Medium";
            typeInt = 1;
        }
        else if(largest < 100){
            type = "Large";
            typeInt = 2;
        }
        else{
            type = "XL";
            typeInt = 3;
        }
    }
    
    public int getTypeInt(){
        return typeInt;
    }
    public double getLargestDimension(){
        return largest;
    }
}