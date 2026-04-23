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
        this.graphics = null;
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
        if(this.posicion ==null || this.graphics==null){
            throw new IllegalArgumentException("hay que llamar a setPosición y setGraphics antes de llamar al método dibujar");
        }
        this.graphics.setColor(this.getColor());
        this.graphics.fillPolygon(this.getVerticesX(),this.getVerticesY(),this.nota);
        this.graphics.setColor(Color.BLACK);
        this.graphics.drawPolygon(this.getVerticesX(),this.getVerticesY(),this.nota);

    }
    @Override
    public abstract int getAnchura();
    @Override
    public abstract int getAltura();

}
