package jd.piano.teclas;

public class TeclaBlanca3 extends TeclaBlanca{

    TeclaBlanca3(int n){
        super(n);
    }

    @Override
    protected int[] getVerticesX() {
        int N = TeclaNegra.ANCHURA;
        int B = TeclaBlanca.ANCHURA;
        int[] x = new int[]{
                super.posicion.x,
                (super.posicion.x+B)-(N/2),
                super.posicion.x+B
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
}
