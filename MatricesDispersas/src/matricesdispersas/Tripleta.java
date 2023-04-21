package matricesdispersas;

public class Tripleta {

    private int T[][];

    public Tripleta(int D) {
        T = new int[D + 1][3];
    }

    public int[][] getT() {
        return T;
    }

    public void setT(int[][] T) {
        this.T = T;
    }

    public int getT(int i, int j) {
        return T[i][j];
    }

    public void setT(int i, int j, int D) {
        T[i][j] = D;
    }

    public void Construir(int M[][], int CD) {
        int k = 1;

        T[0][0] = M.length;
        T[0][1] = M[0].length;
        T[0][2] = CD;

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] != 0) {
                    T[k][0] = i;
                    T[k][1] = j;
                    T[k][2] = M[i][j];
                    k++;
                }
            }
        }
        Redimensionar();
    }

    public void Mostrar() {
        //MOSTRAR TRIPLETA
        System.out.println("");
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + T[i][j] + "|");
            }
            System.out.println("");
        }
        System.out.print("\n");
    }

    public void Redimensionar() {
        int k = 1, Cont = 0, i = 1;

        while (k <= T[0][2]) {
            if (T[k][2] == 0) {
                Cont++;
            }
            k++;
        }
        k = 1;
        Tripleta B = new Tripleta(T[0][2] - Cont);
        B.T[0][0] = T[0][0];
        B.T[0][1] = T[0][1];
        B.T[0][2] = T[0][2] - Cont;

        while (k <= T[0][2]) {
            if (T[k][2] != 0) {
                B.T[i][0] = T[k][0];
                B.T[i][1] = T[k][1];
                B.T[i][2] = T[k][2];
                i++;
            }
            k++;
        }
        setT(B.T);
    }

    public void EliminarPosT(int C, int F) {
        int k = 1;

        while (k <= T[0][2]) {
            if (F == T[k][0]) {
                if (C == T[k][1]) {
                    T[k][2] = 0;
                }
            }
            k++;
        }
        Redimensionar();
    }

    public void EliminarNumT(int N) {
        int k = 1;

        while (k <= T[0][2]) {
            if (N == T[k][2]) {
                T[k][2] = 0;
            }
            k++;
        }
        Redimensionar();
    }

    public void SumarFT() {
        int[] V = new int[T[0][0]];

        for (int i = 1; i <= T[0][2]; i++) {
            V[T[i][0]] += T[i][2];
        }

        for (int i = 0; i < V.length; i++) {
            System.out.print("|" + V[i] + "|");
        }
        System.out.print("\n");
    }

    public void SumarCT() {
        int[] V = new int[T[0][1]];

        for (int i = 1; i <= T[0][2]; i++) {
            V[T[i][1]] += T[i][2];
        }

        for (int i = 0; i < V.length; i++) {
            System.out.print("|" + V[i] + "|");
        }
        System.out.print("\n");
    }

    public void InsertarT(int F, int C, int D) {
        int k = 1, m = 1;
        boolean Suma = false;

        while (k <= T[0][2]) {
            if (T[k][0] == F && T[k][1] == C) {
                T[k][2] += D;
                Suma = true;
            }
            k++;
        }

        if (Suma == true) {
            k = 1;
            while (k <= T[0][2]) {
                if (T[k][2] == 0) {
                    Redimensionar();
                    k = T[0][2];
                }
                k++;
            }
        }

        if (Suma == false) {
            int[][] Ta = new int[T[0][2] + 2][3];

            Ta[0][0] = T[0][0];
            Ta[0][1] = T[0][1];
            Ta[0][2] = T[0][2] + 1;

            k = 1;
            while (k <= T[0][2]) {
                if (T[k][0] == F && C < T[k][1] && D != 0) {
                    Ta[m][0] = F;
                    Ta[m][1] = C;
                    Ta[m][2] = D;
                    D = 0;
                } else {
                    if (T[k][0] == F && C > T[k][1]) {
                        Ta[m][0] = T[k][0];
                        Ta[m][1] = T[k][1];
                        Ta[m][2] = T[k][2];
                        k++;
                    } else {
                        if (T[k][0] > F && D != 0) {
                            Ta[m][0] = F;
                            Ta[m][1] = C;
                            Ta[m][2] = D;
                            D = 0;
                        } else {
                            Ta[m][0] = T[k][0];
                            Ta[m][1] = T[k][1];
                            Ta[m][2] = T[k][2];
                            k++;
                        }
                    }
                }
                m++;
            }
            setT(Ta);
        }
    }

    public void SumarT(Tripleta B) {
        if ((T[0][0] == B.T[0][0]) && ((T[0][1] == B.T[0][1]))) {
            int i = 1, j = 1, k = 1;
            Tripleta C = new Tripleta(T[0][0] * B.T[0][1]);
            C.T[0][0] = T[0][0];
            C.T[0][1] = T[0][1];
            if ((T[0][0] == B.T[0][0]) && (T[0][1] == B.T[0][1])) {
                do {
                    if (i <= T[0][2] && j <= B.T[0][2]) {
                        if ((T[i][0] == B.T[j][0]) && ((T[i][1] == B.T[j][1]))) {
                            C.T[k][0] = T[i][0];
                            C.T[k][1] = T[i][1];
                            C.T[k][2] = T[i][2] + B.T[j][2];
                            k++;
                            j++;
                            i++;
                        } else {
                            if (T[i][0] == B.T[j][0] && T[i][1] < B.T[j][1]) {
                                C.T[k][0] = T[i][0];
                                C.T[k][1] = T[i][1];
                                C.T[k][2] = T[i][2];
                                k++;
                                i++;
                            } else {
                                if (T[i][0] == B.T[j][0] && T[i][1] > B.T[j][1]) {
                                    C.T[k][0] = B.T[j][0];
                                    C.T[k][1] = B.T[j][1];
                                    C.T[k][2] = B.T[j][2];
                                    k++;
                                    j++;
                                } else {
                                    if (T[i][0] > B.T[j][0]) {
                                        C.T[k][0] = B.T[j][0];
                                        C.T[k][1] = B.T[j][1];
                                        C.T[k][2] = B.T[j][2];
                                        k++;
                                        j++;
                                    } else {
                                        C.T[k][0] = T[i][0];
                                        C.T[k][1] = T[i][1];
                                        C.T[k][2] = T[i][2];
                                        k++;
                                        i++;
                                    }
                                }
                            }
                        }
                    } else {
                        if (i >= T[0][2] && j < B.T[0][2]) {
                            C.T[k][0] = B.T[j][0];
                            C.T[k][1] = B.T[j][1];
                            C.T[k][2] = B.T[j][2];
                            k++;
                            j++;
                        } else {
                            if (j >= B.T[0][2] && i < T[0][2]) {
                                C.T[k][0] = T[i][0];
                                C.T[k][1] = T[i][1];
                                C.T[k][2] = T[i][2];
                                k++;
                                i++;
                            }
                        }
                    }
                    if (i == T[0][2] && j == B.T[0][2]) {
                        C.T[k][0] = T[i][0];
                        C.T[k][1] = T[i][1];
                        C.T[k][2] = T[i][2] + B.T[j][2];
                        k++;
                        j++;
                        i++;
                    }
                } while (i < T[0][2] || j < B.T[0][2]);
            }
            int cont = 1;
            for (int l = 0; l < C.T.length; l++) {
                if (C.T[l][2] != 0) {
                    cont++;
                }
            }
            C.T[0][2] = cont;
            C.Redimensionar();
            C.Mostrar();
        } else {
            System.out.println("Las matrices no se pueden sumar.");
            System.out.print("\n");
        }
    }

    public void MultiT(Tripleta B) {
        if (T[0][1] == B.T[0][0]) {
            int Pos, Suma = 0, F = 0, C = 0, i = 1, j = 1, k = 1;
            Tripleta T3 = new Tripleta(B.T[0][2] + T[0][2]);

            T3.T[0][0] = T[0][0];
            T3.T[0][1] = B.T[0][1];

            while (i <= T[0][2]) {
                Pos = i;
                C = 0;
                while (C < B.T[0][1]) {
                    if (T[i][0] == F) {
                        while (j <= B.T[0][2]) {
                            if (B.T[j][0] == T[i][1] && B.T[j][1] == C) {
                                T3.T[k][0] = F;
                                T3.T[k][1] = C;
                                T3.T[k][2] = B.T[j][2] * T[i][2];
                                k++;
                            }
                            j++;
                        }
                        i++;
                        j = 1;
                    } else {
                        C++;
                        i = Pos;
                    }
                }
                F++;
            }
            T3.T[0][2] = k;
            T3.Redimensionar();
            T3.Mostrar();
        } else {
            System.out.println("Las matrices no se pueden multiplicar.");
            System.out.print("\n");
        }
    }
}
