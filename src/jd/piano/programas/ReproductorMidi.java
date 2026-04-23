package jd.piano.programas;

import jd.piano.teclas.Piano;
import jd.piano.teclas.Tecla;

import javax.sound.midi.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReproductorMidi implements Receiver{

    private static final Color[] COLORES = {
            Color.RED,Color.ORANGE,Color.CYAN,Color.YELLOW,Color.PINK,
            Color.MAGENTA,Color.GREEN,Color.GRAY,Color.LIGHT_GRAY,Color.blue,
            Color.DARK_GRAY,new Color(133,81,23), new Color(179,0,255),
            new Color(0,128,255),new Color(0,255,51),
            new Color(212,180,40)} ;
    private Piano piano;

    public ReproductorMidi() { //No hace nada literalmente
        this.piano = null;
    }

    public void conectar(Piano p){
        this.piano = p; //Conectamos el piano
    }

    public void reproducir(String ruta){
        try {
            Sequencer sistema = MidiSystem.getSequencer();
            Sequence secuencia = MidiSystem.getSequence(new File(ruta));

            sistema.open();  //Abrimos el el Sequencer

            Transmitter transmisor = sistema.getTransmitter();
            Receiver recibidor = transmisor.getReceiver();
            transmisor.setReceiver(recibidor);

            sistema.start(); //Empieza a reproducir la cancion

            Thread.sleep(secuencia.getMicrosecondLength()); //Esperamos el tiempo de la cancion

            transmisor.close(); //Cerramos el transmisor
            sistema.close(); //Cerramos el Sequencer

        }catch (MidiUnavailableException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InvalidMidiDataException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void send(MidiMessage message, long timeStamp) {
        if(message instanceof ShortMessage msgCorto){

            int nCanal = msgCorto.getChannel();
            if(!(nCanal == 9)){ //Si el canal es 9 termina sin hacer nada
                int notaMusical = msgCorto.getData1();
                if(this.piano.getTeclaFinal() <= notaMusical
                        && this.piano.getTeclaInicial() >= notaMusical){
                    Tecla teclaSeleccionada = this.piano.getTecla(nCanal,notaMusical);
                    int nComando = msgCorto.getCommand();

                    if(nComando == ShortMessage.NOTE_ON){ //TECLA PULSADA
                        int volumen = msgCorto.getData2();
                        if(volumen>0){ //si el volumen es positibo
                            teclaSeleccionada.setColorPulsado(ReproductorMidi.COLORES[nCanal]);
                            //Le ponemos el color del número de Canal del que viene el sonido
                            teclaSeleccionada.pulsar();
                        } else {
                            teclaSeleccionada.soltar();
                        }
                        teclaSeleccionada.
                    }
                    if(nComando == ShortMessage.NOTE_OFF){

                    }

                } //No hay una tecla para esa nota Musical
            }

        } //Termina sin hacer nada, ya que no es "ShortMessage"
    }

    @Override
    public void close() {

    }
}
