package jd.piano.teclas;

import java.awt.*;

public class TeclaNegra extends Tecla {
    public static final int ANCHURA = 15;
    public static final int ALTURA = 50;

    TeclaNegra(int n){
        super(n);
    }

    @Override
    protected int[] getVerticesX() {
        int[] x = new int[]{
                super.posicion.x,
                super.posicion.x,
                super.posicion.x+this.getAnchura(),
                super.posicion.x+this.getAnchura()
        };
        return x;

    }

    @Override
    protected int[] getVerticesY() {
        int[] y = new int[]{
                super.posicion.y,
                super.posicion.y+this.getAltura(),
                super.posicion.y+this.getAltura(),
                super.posicion.x
        };
        return y;
    }

    @Override
    public Color getColorNoPulsado() {
        return Color.black;
    }

    @Override
    public int getAnchura() {
        return this.ANCHURA;
    }

    @Override
    public int getAltura() {
        return this.ALTURA;
    }

}
