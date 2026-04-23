package jd.piano.programas;

import bpc.daw.consola.*;
import jd.piano.teclas.Piano;

import java.awt.*;
import java.io.File;

public class Programa {
    public static void main(String[] args) {
        Consola consola = new Consola();
        CapaFondo fondo = consola.getCapaFondo();
        Teclado teclado = consola.getTeclado();
        CapaTexto texto = consola.getCapaTexto();
        FondoColorSolido fondoColor = new FondoColorSolido(new Color(0,0,70));
        Graphics graphics = consola.getCapaCanvas().getGraphics();
        fondo.setFondo(fondoColor);
        texto.println("Dime la ruta del archivo: ");
        String ruta = teclado.leerCadenaCaracteres();
        File file = new File(ruta);
        if (!file.exists()) {
            texto.println("No se ha encontrado la ruta del archivo");
        }

        texto.println("""
                Elige el piano que quieres:
                1) Piano Sencillo
                2) Multi Piano
                """);
        int num = teclado.leerNumeroEntero();

        if (num == 1){
            Piano piano = new PianoSencillo(24,108);
            piano.setPosicion(10,10);
            piano.setGraphics(graphics);
            piano.dibujar();
            ReproductorMidi reproductor = new ReproductorMidi();
            reproductor.conectar(piano);
            reproductor.reproducir(ruta);
        }


    }
}
