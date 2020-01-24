public class ParcelType{
    private String type;
    private int typeInt;
    private double largest;
    private double weightLimit;

    public ParcelType(ParcelDimensions pd, double weight){
        double largest = pd.getLargestDimension();
        if(weight>10){
            type = "Heavy";
            typeInt = 4;
            
            weightLimit = 50;
        }
        else if(largest < 10){
            type = "Small";
            typeInt = 0;
            
            weightLimit = 1;
        }
        else if(largest < 50){
            type = "Medium";
            typeInt = 1;
            
            weightLimit = 3;
        }
        else if(largest < 100){
            type = "Large";
            typeInt = 2;
            
            weightLimit = 6;
        }
        else{
            type = "XL";
            typeInt = 3;
            
            weightLimit = 10;
        }
    }
    
    public int getTypeInt(){
        return typeInt;
    }
    
    public double getWeightLimit(){
        return weightLimit;
    }
    
    public double getLargestDimension(){
        return largest;
    }
}