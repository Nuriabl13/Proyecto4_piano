package jd.piano.teclas;

public class TeclaFactory{
    private TeclaFactory(){

    }
    public static Tecla crearTecla(int nota){
        int not = nota%12;
        Tecla tecla = null;
        switch (not){
            case 1,3,6,8,10:
                tecla = new TeclaNegra();
                break;
            case 0,5:
                tecla = new TeclaBlanca1();
        }
    }
}
