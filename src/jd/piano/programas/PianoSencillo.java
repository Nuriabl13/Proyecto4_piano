package jd.piano.programas;

import jd.piano.teclas.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PianoSencillo extends Piano {
    private Map<Integer, Tecla> teclas;
    public PianoSencillo(int teclaIncial, int teclaFinal){
        this.teclas = new HashMap<>();
        for (int i = teclaIncial ; i<teclaFinal;i++){
            Tecla t = TeclaFactory.crearTecla(i);
            this.teclas.put(t.getNumeroNota(),t);
        }
    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        return null;
    }

    @Override
    public void setPosicion(int x, int y) {
        int x1 = x;
        int y1 = y;
        for (int i = super.getTeclaInicial();i<super.getTeclaFinal();i++){
            Tecla tecla = this.teclas.get(i);
            if (tecla instanceof TeclaBlanca blanca){
                tecla.setPosicion(x1,y1);
                x1+=tecla.getAnchura();
            }else {
                tecla.setPosicion(x1- TeclaNegra.ANCHURA/2, y1);
            }
        }
    }

    @Override
    public void setGraphics(Graphics g) {
        for (int i = super.getTeclaInicial();i<super.getTeclaFinal();i++){
            this.teclas.get(i).setGraphics(g);
        }
    }

    @Override
    public void dibujar() {
        for (int i = super.getTeclaInicial();i<super.getTeclaFinal();i++){
            this.teclas.get(i).dibujar();
        }
    }

    @Override
    public int getAnchura() {
        int anchura = 0;
        for (int i = super.getTeclaInicial();i<super.getTeclaFinal();i++){
            Tecla tecla = this.teclas.get(i);
            if (tecla instanceof TeclaBlanca blanca){
                anchura+=tecla.getAnchura();
            }
        }
        return anchura;
    }

    @Override
    public int getAltura() {
        int altura = 0;
        for (int i = super.getTeclaInicial();i<super.getTeclaFinal();i++){
            Tecla tecla = this.teclas.get(i);
            if (tecla instanceof TeclaBlanca blanca){
                altura=tecla.getAltura();
            }
        }
        return altura;
    }
}
