
package Transport;
import Autotransport.Autotransport;


public class Bus extends Autotransport {
    private int Passengers;
    public int getPass(){ return Passengers; }
    public double Busmass;
    public Bus(int power, String mark, int passengers, double busmass) {
        super(power, mark);
        this.Passengers = passengers;
        this.Busmass = busmass;
    }
    
    @Override
    public double weighttopower()
    {  
        return getPower()/(Busmass/1000);
    }
    @Override
    public String info () {
        String data = String.format("Автобус: " + getMark() + ". \nМощность двигателя: " + getPower() + " лс. \nПассажировместимость: " + Passengers + " чел.\nОбщая масса всех пассажиров: " + Busmass + " кг\nУдельная мощность: %.2f " + " лс/т.", weighttopower());
        return data;
    }
}
