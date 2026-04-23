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
        int[] x = new int[];
        return x;

    }

    @Override
    protected int[] getVerticesY() {
        return new int[0];
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
