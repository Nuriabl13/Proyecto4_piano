package jd.piano.teclas;

import java.awt.*;

public interface Pulsable{
    public void pulsar();
    public void soltar();
    public boolean estarPulsado();
    public void setColorPulsado(Color c);
    public Color getColorPulsado();
    public Color getColorNoPulsado();
    public default Color getColor(){
        return null;
    }
}
