public class ParcelDimensions{
    private double height;
    private double width;
    private double length;
    
    public ParcelDimensions(double h, double w, double l){
        height = h;
        width = w;
        length = l;
    }
    
    public double getLargestDimension(){
        if( height >= width && height >= length){
            return height;
        }
        else if( width >= height && width >= length){
            return width;
        }
        else{
            return length;
        }
    }
}