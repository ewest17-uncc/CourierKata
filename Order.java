public class Order{
    
    public Parcel[] Parcels;
    public boolean speedy;
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
            orderTotal = orderTotal*2;
        }
    }
}