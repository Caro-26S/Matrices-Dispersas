package matricesdispersas;

public class Nodo {

    //Atributos
    private int Dato, F, C;
    private Nodo Liga, LF, LC;

    public Nodo(int Dato, int F, int C) {
        this.Dato = Dato;
        this.F = F;
        this.C = C;
        Liga = null;
        LF = this;
        LC = this;
    }

    public Nodo() {
        Dato = 0;
        F = 0;
        C = 0;
        Liga = null;
        LF = this;
        LC = this;
    }

    public int getDato() {
        return Dato;
    }

    public void setDato(int Dato) {
        this.Dato = Dato;
    }

    public int getC() {
        return C;
    }

    public void setC(int C) {
        this.C = C;
    }

    public int getF() {
        return F;
    }

    public void setF(int F) {
        this.F = F;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo Liga) {
        this.Liga = Liga;
    }

    public Nodo getLF() {
        return LF;
    }

    public void setLF(Nodo LF) {
        this.LF = LF;
    }

    public Nodo getLC() {
        return LC;
    }

    public void setLC(Nodo LC) {
        this.LC = LC;
    }

}
