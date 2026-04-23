package jd.piano.teclas;

import java.awt.*;

public class TeclaBlanca1 extends TeclaBlanca{

    TeclaBlanca1(int n){
        super(n);
    }

    @Override
    protected int[] getVerticesX() {
        int N = TeclaNegra.ANCHURA;
        int B = TeclaBlanca.ANCHURA;
        int[] x = new int[]{
                super.posicion.x,
                (super.posicion.x+B)-(N/2),
                super.posicion.x+B,
        };
        return x;
    }

    @Override
    protected int[] getVerticesY() {
        int[] y = new int[]{
                super.posicion.y,
                super.posicion.y + TeclaNegra.ALTURA,
                super.posicion.y + TeclaBlanca.ALTURA,
        };
        return y;
    }

    @Override
    public Color getColorNoPulsado() {
        return Color.white;
    }

    @Override
    public int getAnchura() {
        return TeclaBlanca.ANCHURA;
    }

    @Override
    public int getAltura() {
        return TeclaBlanca.ALTURA;
    }
}
