package jd.piano.teclas;

import java.awt.*;

public abstract class Tecla implements Pulsable {
    protected Point posicion;
    private int nota;
    private boolean pulsada;
    private Color colorPulsada;
    private Graphics graphics;
    Tecla(int n){
        this.nota=n;
    }
    public int getNumeroNota(){
        return this.nota;
    }
    protected abstract int[] getVerticesX();
    protected abstract int[] getVerticesY();
}
