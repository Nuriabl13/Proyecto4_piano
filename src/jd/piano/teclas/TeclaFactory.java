package jd.piano.teclas;

public class TeclaFactory{
    private TeclaFactory(){}
    public static Tecla crearTecla(int nota){
        int not = nota%12;
        Tecla tecla = null;
        switch (not) {
            case 1, 3, 6, 8, 10:
                tecla = new TeclaNegra(nota);
                break;
            case 0, 5:
                tecla = new TeclaBlanca1(nota);
                break;
            case 2, 7, 9:
                tecla = new TeclaBlanca2(nota);
                break;
            case 4, 11:
                tecla = new TeclaBlanca3(nota);
                break;
        }
        return tecla;
    }
}
