import java.util.Arrays;
public class Order{
    
    public Parcel[] Parcels;
    public boolean speedy;
    public double speedyCost;
    public double orderTotal;
    
    public Order(Parcel[] p){
        Parcels = p;
        speedy = false;
        orderTotal = 0;
        for (int i = 0; i < Parcels.length; i++) {
            Parcels[i].setRate(Parcels[i].getParcelType());
            orderTotal += Parcels[i].getRate();
        }
    }
    public Order(Parcel[] p, boolean s){
        Parcels = p;
        speedy = s;
        orderTotal = 0;
        for (int i = 0; i < Parcels.length; i++) {
            Parcels[i].setRate(Parcels[i].getParcelType());
            orderTotal += Parcels[i].getRate();
        }
        if(speedy){
            speedyCost = orderTotal;
            orderTotal = orderTotal*2;
        }
    }
    
    public void printOrder(){
        for (int i = 0; i < Parcels.length; i++) {
            System.out.println("Parcel " + (i+1) + " Cost: " + Parcels[i].getRate());
        }
        if(speedy){
            System.out.println("Speedy Cost: "+ speedyCost);
        }
        System.out.println("Order Total: " + orderTotal);
    }
    
    /*
    
    public void calculateDiscount(Parcel[] p){
        Parcel temp;
        for(int i=0; i<p.length; i++){
            for(int j=i+1; j<p.length; j++){
                if(p[i].compareTo(p[j]) == 1){
                    temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }
    }
    
    */
    
    
}