package matricesdispersas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class MatricesDispersas {

    public static void main(String[] args) {
        int[][] a = matriz();
        int cont = NumeroD(a), C, F, D, Opc;
        Scanner Leer = new Scanner(System.in);

        Tripleta T = new Tripleta(cont);
        T.Construir(a, cont);
        Forma1 F1 = new Forma1();
        F1.Crear(a);
        Forma2 F2 = new Forma2();
        F2.Crear(a);

        do {
            Opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Tripletas.\n"
                    + "2. Forma 1.\n"
                    + "3. Forma 2. \n"
                    + "4. Sumar entre formas. \n"
                    + "5. Salir.", "MENÚ PRINCIPAL", 3));

            switch (Opc) {
                case 1:
                    do {
                        Opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Mostrar. \n"
                                + "2. Insertar término.\n"
                                + "3. Eliminar término por posición. \n"
                                + "4. Eliminar término por número.\n"
                                + "5. Suma de las filas.\n"
                                + "6. Suma de las columnas.\n"
                                + "7. Multiplicar dos matrices.\n"
                                + "8. Sumar dos matrices.\n"
                                + "9. Regresar al menú principal.", "MENÚ TRIPLETAS", 3));

                        switch (Opc) {
                            case 1:
                                T.Mostrar();
                                break;

                            case 2:
                                System.out.print("Ingrese la fila del nuevo dato: ");
                                F = Leer.nextInt();
                                System.out.print("Ingrese la columna del nuevo dato: ");
                                C = Leer.nextInt();
                                System.out.print("Ingrese el nuevo dato: ");
                                D = Leer.nextInt();
                                System.out.print("\n");

                                T.InsertarT(F, C, D);
                                break;

                            case 3:
                                System.out.print("Ingrese la fila del dato a eliminar: ");
                                F = Leer.nextInt();
                                System.out.print("Ingrese la columna del dato a eliminar: ");
                                C = Leer.nextInt();
                                System.out.print("\n");

                                T.EliminarPosT(C, F);
                                break;

                            case 4:
                                System.out.print("Ingrese el nuevo dato: ");
                                D = Leer.nextInt();
                                System.out.print("\n");

                                T.EliminarNumT(D);
                                break;

                            case 5:
                                T.SumarFT();
                                break;

                            case 6:
                                T.SumarCT();
                                break;

                            case 7:
                                int[][] b = matriz();
                                int DtM = NumeroD(b);
                                Tripleta TM = new Tripleta(DtM);
                                TM.Construir(b, DtM);
                                T.MultiT(TM);
                                break;

                            case 8:
                                int[][] c = matriz();
                                int DtS = NumeroD(c);
                                Tripleta TS = new Tripleta(DtS);
                                TS.Construir(c, DtS);
                                T.SumarT(TS);
                                break;

                            case 9:
                                break;

                            default:
                                JOptionPane.showInternalMessageDialog(null, "Opción incorrecta.");
                        }
                    } while (Opc != 9);
                    break;

                case 2:
                    do {
                        Opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Mostrar. \n"
                                + "2. Insertar término.\n"
                                + "3. Eliminar término por posición. \n"
                                + "4. Eliminar término por número.\n"
                                + "5. Suma de las filas.\n"
                                + "6. Suma de las columnas.\n"
                                + "7. Multiplicar dos matrices.\n"
                                + "8. Sumar dos matrices.\n"
                                + "9. Regresar al menú principal.", "MENÚ FORMA 1", 3));

                        switch (Opc) {
                            case 1:
                                F1.Mostrar1();
                                break;

                            case 2:
                                System.out.print("Ingrese la fila del nuevo dato: ");
                                F = Leer.nextInt();
                                System.out.print("Ingrese la columna del nuevo dato: ");
                                C = Leer.nextInt();
                                System.out.print("Ingrese el nuevo dato: ");
                                D = Leer.nextInt();
                                System.out.print("\n");

                                Nodo X = new Nodo(D, F, C);
                                F1.Insertar1(X);
                                break;

                            case 3:
                                System.out.print("Ingrese la fila del dato a eliminar: ");
                                F = Leer.nextInt();
                                System.out.print("Ingrese la columna del dato a eliminar: ");
                                C = Leer.nextInt();
                                System.out.print("\n");

                                F1.EliminarPos1(F, C);
                                break;

                            case 4:
                                System.out.print("Ingrese el nuevo dato: ");
                                D = Leer.nextInt();
                                System.out.print("\n");

                                F1.EliminarNum1(D);
                                break;

                            case 5:
                                F1.SumaF1();
                                break;

                            case 6:
                                F1.SumaC1();
                                break;

                            case 7:
                                int[][] d = matriz();
                                Forma1 F1M = new Forma1();
                                F1M.Crear(d);
                                F1M.Mostrar1();

                                F1.Mult1(F1M);
                                break;

                            case 8:
                                int[][] e = matriz();
                                Forma1 F1S = new Forma1();
                                F1S.Crear(e);
                                F1S.Mostrar1();

                                F1.Sumar1(F1S);
                                break;

                            case 9:
                                break;

                            default:
                                JOptionPane.showInternalMessageDialog(null, "Opción incorrecta.");
                        }
                    } while (Opc != 9);
                    break;

                case 3:
                    do {
                        Opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Mostrar. \n"
                                + "2. Insertar término.\n"
                                + "3. Eliminar término por posición. \n"
                                + "4. Eliminar término por número.\n"
                                + "5. Suma de las filas.\n"
                                + "6. Suma de las columnas.\n"
                                + "7. Multiplicar dos matrices.\n"
                                + "8. Sumar dos matrices.\n"
                                + "9. Regresar al menú principal.", "MENÚ FORMA 2", 3));

                        switch (Opc) {
                            case 1:
                                F2.MostrarF2();
                                F2.MostrarC2();
                                break;

                            case 2:
                                System.out.print("Ingrese la fila del nuevo dato: ");
                                F = Leer.nextInt();
                                System.out.print("Ingrese la columna del nuevo dato: ");
                                C = Leer.nextInt();
                                System.out.print("Ingrese el nuevo dato: ");
                                D = Leer.nextInt();
                                System.out.print("\n");

                                F2.Insertar2(F, C, D);
                                break;

                            case 3:
                                System.out.print("Ingrese la fila del dato a eliminar: ");
                                F = Leer.nextInt();
                                System.out.print("Ingrese la columna del dato a eliminar: ");
                                C = Leer.nextInt();
                                System.out.print("\n");

                                F2.EliminarPos2(F, C);
                                break;

                            case 4:
                                System.out.print("Ingrese el nuevo dato: ");
                                D = Leer.nextInt();
                                System.out.print("\n");

                                F2.EliminarNum2(D);
                                break;

                            case 5:
                                F2.SumarF2();
                                break;

                            case 6:
                                F2.SumarC2();
                                break;

                            case 7:
                                int[][] f = matriz();
                                Forma2 F2S = new Forma2();
                                F2S.Crear(f);
                                F2S.MostrarF2();
                                F2S.MostrarC2();

                                F2.Mult2(F2S);
                                break;

                            case 8:
                                int[][] g = matriz();
                                Forma2 F2M = new Forma2();
                                F2M.Crear(g);
                                F2M.MostrarF2();
                                F2M.MostrarC2();

                                F2.Sumar2(F2M);
                                break;

                            case 9:
                                break;

                            default:
                                JOptionPane.showInternalMessageDialog(null, "Opción incorrecta.");
                        }
                    } while (Opc != 9);
                    break;

                case 4:
                    int[][] h = matriz();

                    Forma2 F2s = new Forma2();
                    F2s.Crear(h);
                    F1.Sumar12T(F2s);
                    break;

                case 5:
                    break;

                default:
                    JOptionPane.showInternalMessageDialog(null, "Opción incorrecta.");
            }

        } while (Opc != 5);
    }

    public static int NumeroD(int[][] m) {
        int cont = 0;
        Scanner Leer = new Scanner(System.in);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] != 0) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public static int[][] matriz() {
        int C = 0, i = 0;
        String S = "", separador = Pattern.quote("|");
        int filas, columnas;
        Scanner escan = new Scanner(System.in);
        System.out.print("Ingresa el numero de filas: ");
        filas = escan.nextInt();
        System.out.print("Ingresa el numero de columnas: ");
        columnas = escan.nextInt();
        System.out.print("\n");
        int[][] matriz = new int[filas][columnas];

        try {
            FileReader A = new FileReader("Matriz.txt");
            BufferedReader leer = new BufferedReader(A);

            i = 0;
            while (i < filas) {
                S = leer.readLine();
                if (S != null) {
                    String[] Nums = S.split(separador);
                    for (int j = 0; j < columnas; j++) {
                        matriz[i][j] = Integer.parseInt(Nums[j]);
                    }
                    i++;
                }
            }
            A.close();
            leer.close();
        } catch (IOException e) {
        }
        return matriz;
    }
}
