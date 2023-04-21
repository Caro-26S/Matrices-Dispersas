package matricesdispersas;

import javax.swing.JOptionPane;

public class Forma2 {

    public Nodo Punta;

    public Forma2() {
        Punta = null;
    }

    public void Crear(int Mat[][]) {
        Paso1(Mat);
        Paso2();

    }

    private void Paso1(int Mat[][]) {
        Nodo X = new Nodo(0, Mat.length, Mat[0].length), Y;
        Punta = X;
        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[0].length; j++) {
                if (Mat[i][j] != 0) {
                    Y = new Nodo(Mat[i][j], i, j);
                    InsertarFinal2(Y);
                }
            }
        }
    }

    private void Paso2() {
        int C = 0;
        Nodo P = Punta, A = P;

        while (C < Punta.getC()) {
            P = P.getLF();
            while (P != Punta) {
                if (C == P.getC()) {
                    A.setLC(P);
                    A = P;
                }
                P = P.getLF();
            }
            C++;
        }
        A.setLC(Punta);
    }

    public void MostrarF2() {
        Nodo k = Punta.getLF();
        System.out.print("|  " + Punta.getF() + " | " + Punta.getC() + "  |" + "\n" + "|" + "Registros" + "|--->");
        while (k != Punta) {
            System.out.print("| " + k.getF() + " | " + k.getC() + " |" + "| " + k.getDato() + " |--->");
            k = k.getLF();
        }
    }

    public void MostrarC2() {
        Nodo k = Punta.getLC();
        System.out.print("\n" + "|  " + Punta.getF() + " | " + Punta.getC() + "  |" + "\n" + "|" + "Registros" + "|--->");
        while (k != Punta) {
            System.out.print("| " + k.getF() + " | " + k.getC() + " |" + "| " + k.getDato() + " |--->");
            k = k.getLC();
        }
        System.out.println("\n");
    }

    private void InsertarFinal2(Nodo X) {
        Nodo k = Punta.getLF();
        boolean suma = false;
        while (k != Punta) {
            if (k.getF() == X.getF() && k.getC() == X.getC()) {
                k.setDato(X.getDato() + k.getDato());
                suma = true;
            }
            k = k.getLF();
        }
        if (!suma) {
            k = Punta;
            while (k.getLF() != Punta) {
                k = k.getLF();
            }
            k.setLF(X);
            X.setLF(Punta);
        } else {
            EliminarNum2(0);
        }

    }

    public void Insertar2(int F, int C, int D) {
        Nodo P = Punta.getLF(), A = Punta;
        boolean Suma = false;

        while (P != Punta) {
            if (P.getC() == C && P.getF() == F) {
                P.setDato(P.getDato() + D);
                Suma = true;
            }
            P = P.getLF();
        }

        if (Suma == true) {
            P = Punta.getLF();
            while (P != Punta) {
                if (P.getDato() == 0) {
                    A.setLF(P.getLF());
                    P.setLF(null);
                    P.setLC(null);
                    P = Punta;
                } else {
                    A = P;
                    P = P.getLF();
                }
            }
            Paso2();
        }

        if (Suma == false) {
            Nodo X = new Nodo(D, F, C);
            A = Punta;
            P = Punta.getLF();
            while (P != Punta && D != 0) {
                if (P.getF() == F && P.getC() > C && D != 0) {
                    A.setLF(X);
                    X.setLF(P);
                    D = 0;
                } else {
                    if (P.getF() == F && P.getC() < C && D != 0) {
                        X.setLF(P.getLF());
                        P.setLF(X);
                        D = 0;
                    }
                }
                A = P;
                P = P.getLF();
            }
            Paso2();
        }
    }

    public void EliminarPos2(int F, int C) {
        Nodo P = Punta.getLF(), A = Punta;

        while (P != Punta) {
            if (P.getC() == C && P.getF() == F) {
                A.setLF(P.getLF());
                P.setLF(null);
                P.setLC(null);
                P = Punta;
            }
            A = P;
            P = P.getLF();
        }
        Paso2();
    }

    public void EliminarNum2(int D) {
        Nodo P = Punta.getLF(), A = Punta;

        while (P != Punta) {
            if (P.getDato() == D) {
                A.setLF(P.getLF());
                P.setLF(null);
                P.setLC(null);
                P = Punta;
            }
            A = P;
            P = P.getLF();
        }
        Paso2();
    }

    public void SumarF2() {
        Nodo P;
        int F = 0, Suma;

        while (F < Punta.getF()) {
            P = Punta.getLF();
            Suma = 0;
            while (P != Punta) {
                if (F == P.getF()) {
                    Suma += P.getDato();
                }
                P = P.getLF();
            }
            System.out.println("La suma de la fila " + F + 1 + " es " + Suma);
            F++;
        }
        System.out.print("\n");
    }

    public void SumarC2() {
        Nodo P;
        int C = 0, Suma;

        while (C < Punta.getC()) {
            P = Punta.getLC();
            Suma = 0;
            while (P != Punta) {
                if (C == P.getC()) {
                    Suma += P.getDato();
                }
                P = P.getLC();
            }
            System.out.println("La suma de la columna " + C + " es " + Suma);
            C++;
        }
        System.out.print("\n");
    }

    public void Sumar2(Forma2 A) {
        if (Punta.getF() == A.Punta.getF() && Punta.getC() == A.Punta.getC()) {
            Forma2 res = new Forma2();
            Nodo X = new Nodo(0, A.Punta.getF(), Punta.getC()), Y, p, q;
            res.Punta = X;
            p = Punta.getLF();
            q = A.Punta.getLF();
            while (p != Punta || q != A.Punta) {
                if (p != Punta && q != A.Punta) {
                    if (p.getF() == q.getF() && p.getC() == q.getC()) {
                        Y = new Nodo((p.getDato() + q.getDato()), p.getF(), q.getC());
                        res.InsertarFinal2(Y);
                        p = p.getLF();
                        q = q.getLF();
                    } else {
                        if (p.getF() == q.getF() && p.getC() < q.getC()) {
                            Y = new Nodo((p.getDato()), p.getF(), p.getC());
                            res.InsertarFinal2(Y);
                            p = p.getLF();
                        } else {
                            if (p.getF() == q.getF() && p.getC() > q.getC()) {
                                Y = new Nodo((q.getDato()), q.getF(), q.getC());
                                res.InsertarFinal2(Y);
                                q = q.getLF();
                            }
                        }
                    }
                } else {
                    if (p != Punta && q == A.Punta) {
                        Y = new Nodo(p.getDato(), p.getF(), p.getC());
                        res.InsertarFinal2(Y);
                        p = p.getLF();
                    } else {
                        if (p == Punta && q != A.Punta) {
                            Y = new Nodo(q.getDato(), q.getF(), q.getC());
                            res.InsertarFinal2(Y);
                            q = q.getLF();
                        }
                    }
                }
            }
            res.Paso2();
            res.MostrarF2();
            res.MostrarC2();
        } else {
            System.out.println("Las matrices no se pueden sumar.");
            System.out.print("\n");
        }
    }

    public void Mult2(Forma2 A) {
        if (Punta.getC() == A.Punta.getF()) {
            Forma2 res = new Forma2();

            Nodo p, q, y, x;
            y = new Nodo(0, Punta.getF(), A.Punta.getC());
            res.Punta = y;
            p = Punta.getLF();
            while (p != Punta) {
                q = A.Punta.getLC();
                while (q != A.Punta) {
                    if (p.getC() == q.getF()) {
                        x = new Nodo(p.getDato() * q.getDato(), p.getF(), q.getC());
                        res.InsertarFinal2(x);
                    }
                    q = q.getLC();
                }
                p = p.getLF();
            }
            res.Paso2();
            res.MostrarF2();
            res.MostrarC2();
        } else {
            System.out.println("Las matrices no se pueden multiplicar.");
            System.out.print("\n");
        }
    }
}
