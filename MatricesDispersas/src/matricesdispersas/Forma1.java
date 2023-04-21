package matricesdispersas;

public class Forma1 {

    Nodo Punta;

    public Forma1() {
        Punta = null;
    }

    public void Crear(int Mat[][]) {
        Paso1(Mat);
        Paso2(Mat);
        Paso3();
    }

    private void Paso1(int Mat[][]) {
        int May = 0, i = 0;
        Nodo X = new Nodo(0, Mat.length, Mat[0].length), P;
        Punta = X;

        if (Mat.length > Mat[0].length) {
            May = Mat.length;
        } else {
            May = Mat[0].length;
        }
        P = Punta;
        while (i < May) {
            Nodo Y = new Nodo();
            Y.setDato(0);
            Y.setF(i);
            Y.setC(i);
            P.setLiga(Y);
            P = P.getLiga();
            i++;
        }
        P.setLiga(Punta);
    }

    private void Paso2(int Mat[][]) {
        Nodo P = Punta.getLiga(), Q = P;
        int i = 0, j;

        while (i < Punta.getF()) {
            j = 0;
            while (j < Punta.getC()) {
                if (Mat[i][j] != 0) {
                    Nodo Y = new Nodo(Mat[i][j], i, j);
                    Q.setLF(Y);
                    Q = Q.getLF();
                }
                j++;
            }
            Q.setLF(P);
            P = P.getLiga();
            Q = P;
            i++;
        }
    }

    private void Paso3() {
        Nodo RC = Punta.getLiga(), P, Q, A;

        while (RC != Punta) {
            P = Punta.getLiga();
            Q = P.getLF();
            A = RC;
            while (P != Punta) {
                while (Q != P) {
                    if (Q.getC() == RC.getC()) {
                        A.setLC(Q);
                        A = Q;
                    }
                    Q = Q.getLF();
                }
                P = P.getLiga();
                Q = P.getLF();
            }
            A.setLC(RC);
            RC = RC.getLiga();
        }
//        Mostrar1();
    }

    public void Mostrar1() {

        Nodo P = Punta, Q, K;
        System.out.println("|  " + P.getF() + " | " + P.getC() + "  |" + "\n" + "|" + "Registros" + "|\n" + "     |\n     V");
        P = P.getLiga();
        while (P != Punta) {
            System.out.print("|  " + P.getF() + " | " + P.getC() + "   |" + "\n" + "|" + "RegistrosF" + "|--->");
            Q = P.getLF();
            while (Q != P) {
                System.out.print("| " + Q.getF() + " | " + Q.getC() + " |" + "| " + Q.getDato() + " |--->");
                Q = Q.getLF();
            }
            System.out.print("|" + "RegistrosF" + "|");
            K = P.getLC();
            System.out.print("\n|" + "RegistrosC" + "|--->");
            while (K != P) {
                System.out.print("| " + K.getF() + " | " + K.getC() + " |" + "| " + K.getDato() + " |--->");
                K = K.getLC();
            }
            System.out.print("|" + "RegistrosC" + "|");

            System.out.println("\n     |\n     V");
            P = P.getLiga();
        }
        System.out.print("|" + "Registros" + "|\n");
        System.out.print("\n");
    }

    private void RC(int F, int C) {
        int May, i = 0;
        Nodo X = new Nodo(0, F, C), P;
        Punta = X;
        if (F > C) {
            May = F;
        } else {
            May = C;
        }
        P = Punta;
        while (i < May) {
            Nodo Y = new Nodo();
            Y.setDato(0);
            Y.setF(i);
            Y.setC(i);
            P.setLiga(Y);
            P = P.getLiga();
            i++;
        }
        P.setLiga(Punta);
    }

    private void InsertarFinal1(Nodo X, Nodo RC) {
        Nodo k = RC;
        while (k.getLF() != RC) {
            k = k.getLF();
        }
        k.setLF(X);
        X.setLF(RC);
    }

    public void Insertar1(Nodo X) {
        Nodo RC = Punta.getLiga(), P, A;
        boolean Suma = false;

        while (RC != Punta) {
            P = RC.getLF();
            while (P != RC) {
                if (P.getF() == X.getF() && P.getC() == X.getC()) {
                    P.setDato(P.getDato() + X.getDato());
                    Suma = true;
                }
                P = P.getLF();
            }
            RC = RC.getLiga();
        }

        if (Suma == true) {
            EliminarNum1(0);
        }

        if (Suma == false) {
            RC = Punta.getLiga();

            while (RC != Punta) {
                if (RC.getF() == X.getF()) {
                    A = RC;
                    P = RC.getLF();
                    if (P != RC) {
                        while (P != RC) {
                            if (P.getC() < X.getC()) {
                                A = P;
                                P = P.getLF();
                                A.setLF(X);
                                X.setLF(P);
                                P = RC;
                            } else {
                                if (P.getC() > X.getC()) {
                                    A.setLF(X);
                                    X.setLF(P);
                                    P = RC;
                                } else {
                                    A = P;
                                    P = P.getLF();
                                }
                            }
                        }
                        RC = Punta;
                    } else {
                        P.setLF(X);
                        X.setLF(P);
                    }
                } else {
                    RC = RC.getLiga();
                }
            }
            Paso3();
        }
    }

    public void EliminarPos1(int F, int C) {
        Nodo RC = Punta.getLiga(), P, A;

        while (RC != Punta) {
            if (RC.getF() == F) {
                P = RC.getLF();
                A = RC;
                while (P != RC) {
                    if (P.getC() == C) {
                        A.setLF(P.getLF());
                        P.setLF(null);
                        P.setLC(null);
                        RC = Punta;
                        P = RC;
                    } else {
                        A = P;
                        P = P.getLF();
                    }
                }
            } else {
                RC = RC.getLiga();
            }
        }
        Paso3();
    }

    public void EliminarNum1(int D) {
        Nodo RC = Punta.getLiga(), P, A;

        while (RC != Punta) {
            A = RC;
            P = RC.getLF();
            while (P != RC) {
                if (P.getDato() == D) {
                    A.setLF(P.getLF());
                    P.setLF(null);
                    P.setLC(null);
                    P = A.getLF();
                } else {
                    A = P;
                    P = P.getLF();
                }
            }
            RC = RC.getLiga();
        }
        Paso3();
    }

    public void SumaF1() {
        int Total;
        Nodo P = Punta.getLiga(), Q;
        while (P != Punta) {
            Q = P.getLF();
            Total = 0;
            while (Q != P) {
                Total += Q.getDato();
                Q = Q.getLF();
            }
            System.out.println("Suma de la fila " + P.getF() + " es " + Total);
            P = P.getLiga();
        }
        System.out.print("\n");
    }

    public void SumaC1() {
        int Total;
        Nodo P = Punta.getLiga(), Q;
        while (P != Punta) {
            Q = P.getLC();
            Total = 0;
            while (Q != P) {
                Total += Q.getDato();
                Q = Q.getLC();
            }
            System.out.println("Suma de la columna " + P.getC() + " es " + Total);
            P = P.getLiga();
        }
        System.out.print("\n");
    }

    public void Sumar1(Forma1 B) {
        if (Punta.getF() == B.Punta.getF() && Punta.getC() == B.Punta.getC()) {
            Forma1 C = new Forma1();
            C.RC(Punta.getF(), Punta.getC());
            Nodo P = Punta.getLiga(), Q = B.Punta.getLiga(), K = C.Punta.getLiga(), i, j, y;
            while (P != Punta || Q != B.Punta) {
                i = P.getLF();
                j = Q.getLF();
                while (i != P || j != Q) {
                    if (i != P && j != Q) {
                        if (i.getF() == j.getF() && i.getC() == j.getC()) {
                            y = new Nodo((i.getDato() + j.getDato()), i.getF(), j.getC());
                            C.InsertarFinal1(y, K);
                            i = i.getLF();
                            j = j.getLF();
                        } else {
                            if (i.getF() == j.getF() && i.getC() < j.getC()) {
                                y = new Nodo((i.getDato()), i.getF(), i.getC());
                                C.InsertarFinal1(y, K);
                                i = i.getLF();
                            } else {
                                if (i.getF() == j.getF() && i.getC() > j.getC()) {
                                    y = new Nodo((j.getDato()), j.getF(), j.getC());
                                    C.InsertarFinal1(y, K);
                                    j = j.getLF();
                                }
                            }
                        }
                    } else {
                        if (i == P && j != Q) {
                            y = new Nodo((j.getDato()), j.getF(), j.getC());
                            C.InsertarFinal1(y, K);
                            j = j.getLF();
                        } else {
                            if (i != P && j == Q) {
                                y = new Nodo((i.getDato()), i.getF(), i.getC());
                                C.InsertarFinal1(y, K);
                                i = i.getLF();
                            }
                        }
                    }
                }
                P = P.getLiga();
                Q = Q.getLiga();
                K = K.getLiga();
            }
            C.Paso3();
            C.Mostrar1();
        } else {
            System.out.println("Las matrices no se pueden sumar.");
            System.out.print("\n");
        }
    }

    public void Mult1(Forma1 A) {
        if (Punta.getC() == A.Punta.getF()) {
            Forma1 res = new Forma1();
            int total = 0;
            Nodo p, q, r, s, rc;
            res.RC(Punta.getF(), A.Punta.getC());
            p = Punta.getLiga();

            while (p != Punta) {
                q = p.getLF();
                while (q != p) {
                    r = A.Punta.getLiga();
                    while (r != A.Punta) {
                        s = r.getLC();
                        while (s != r) {
                            if (q.getC() == s.getF()) {
                                total += q.getDato() * s.getDato();
                            }
                            s = s.getLC();
                        }
                        if (total != 0) {
                            Nodo y = new Nodo(total, q.getF(), s.getC());
                            res.Insertar1(y);
                            total = 0;
                        }
                        r = r.getLiga();
                    }
                    q = q.getLF();
                }
                p = p.getLiga();
            }
            res.Paso3();
            res.Mostrar1();
        } else {
            System.out.println("Las matrices no se pueden multiplicar.");
            System.out.print("\n");
        }
    }

    public void Sumar12T(Forma2 B) {
        if (Punta.getF() == B.Punta.getF() && Punta.getC() == B.Punta.getC()) {
            Nodo RC = Punta.getLiga(), P, Q = B.Punta.getLF();
            Tripleta TS = new Tripleta(Punta.getF() * B.Punta.getC());
            int i = 1;

            TS.setT(0, 0, Punta.getF());
            TS.setT(0, 1, B.Punta.getC());

            while (RC != Punta || Q != B.Punta) {
                P = RC.getLF();
                if (RC != Punta && Q != B.Punta) {
                    while (P != RC) {
                        if (P.getF() == Q.getF() && P.getC() == Q.getC()) {
                            TS.setT(i, 0, P.getF());
                            TS.setT(i, 1, Q.getC());
                            TS.setT(i, 2, P.getDato() + Q.getDato());
                            P = P.getLF();
                            Q = Q.getLF();
                        } else {
                            if (P.getF() == Q.getF() && P.getC() > Q.getC()) {
                                TS.setT(i, 0, Q.getF());
                                TS.setT(i, 1, Q.getC());
                                TS.setT(i, 2, Q.getDato());
                                Q = Q.getLF();
                            } else {
                                if (P.getF() == Q.getF() && P.getC() < Q.getC()) {
                                    TS.setT(i, 0, P.getF());
                                    TS.setT(i, 1, P.getC());
                                    TS.setT(i, 2, P.getDato());
                                    P = P.getLF();
                                } else {
                                    if (P.getF() > Q.getF()) {
                                        TS.setT(i, 0, Q.getF());
                                        TS.setT(i, 1, Q.getC());
                                        TS.setT(i, 2, Q.getDato());
                                        Q = Q.getLF();
                                    } else {
                                        if (P.getF() < Q.getF()) {
                                            TS.setT(i, 0, P.getF());
                                            TS.setT(i, 1, P.getC());
                                            TS.setT(i, 2, P.getDato());
                                            P = P.getLF();
                                        }
                                    }
                                }
                            }
                        }
                        i++;
                    }
                } else {
                    if (RC == Punta) {
                        TS.setT(i, 0, Q.getF());
                        TS.setT(i, 1, Q.getC());
                        TS.setT(i, 2, Q.getDato());
                        Q = Q.getLF();
                    } else {
                        if (Q == B.Punta) {
                            TS.setT(i, 0, P.getF());
                            TS.setT(i, 1, P.getC());
                            TS.setT(i, 2, P.getDato());
                            P = P.getLF();
                        }
                    }
                    i++;
                }
                RC = RC.getLiga();
            }
            TS.setT(0, 2, i);
            TS.Redimensionar();
            TS.Mostrar();
        }
    }
}
