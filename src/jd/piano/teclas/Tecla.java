package jd.piano.teclas;

import java.awt.*;

public abstract class Tecla implements Pulsable{
    protected Point posicion;
    private int nota;
    private boolean pulsada;
    private Color colorPulsada;
    private Graphics graphics;
    Tecla(int n){
        this.nota=n;
        this.posicion= null;
        this.colorPulsada=null;
    }
    public int getNumeroNota(){
        return this.nota;
    }
    protected abstract int[] getVerticesX();
    protected abstract int[] getVerticesY();

    @Override
    public void pulsar(){
        this.pulsada= true;
    }
    @Override
    public void soltar(){
        this.pulsada=false;
    }
    @Override
    public boolean estarPulsado(){
        return this.pulsada;
    }
    @Override
    public void setColorPulsado(Color c){
        this.colorPulsada = c;
    }
    @Override
    public Color getColorPulsado(){
        return this.colorPulsada;
    }
    @Override
    public abstract Color getColorNoPulsado();
    @Override
    public void setPosicion(int x, int y){
        this.posicion = new Point(x,y);
    }
    @Override
    public void setGraphics(Graphics g){
        this.graphics=g;
    }
    @Override
    public void dibujar(){

    }
    @Override
    public abstract int getAnchura();
    @Override
    public abstract int getAltura();

}
