
package Transport;
import Autotransport.Autotransport;

public class Truck extends Autotransport {
    public double Capacity;
    public Truck(int power, String mark, double capacity) {
        super(power, mark);
        this.Capacity = capacity;
    }
    
    @Override
    public double weighttopower()
    {
        return getPower()/(Capacity/1000);
    }
    
    @Override  
    public String info() {
        String data = String.format("Грузовик: " + getMark() + ". \nМощность двигателя: " + getPower() + " лс. \nГрузоподъемность: " + Capacity + " кг. \nУдельная мощность: %.2f " + " лс/т.", weighttopower());
        return data;
    }
}
