
package Autotransport;

import Interface.Calculations;

public abstract class Autotransport implements Calculations {
    private int Power;
    public int getPower(){ return Power; }
    private String Mark;
    public String getMark(){ return Mark; }
    
    public Autotransport (int power, String mark) 
    {
        this.Power = power;
        this.Mark = mark;
    }
    
    public abstract String info();
}
