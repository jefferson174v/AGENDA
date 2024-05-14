import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tamano1 = metodo1(sc);
        String[][] arreglo = new String[tamano1][2];
        String[][] arreglo2 = metodo2(arreglo, sc);
        String[][] arreglo3 = metodo1(arreglo2, sc);
        metodo4();
        System.out.println("Su agenda es: ");
        metodo3(arreglo3);
        metodo4();
        metodo5();
        metodo4();
        String opcion2 = metodo6(sc);
        while (true) {
            if (opcion2.equals("0")) {
                completar(arreglo3, sc);
                metodo3(arreglo3);
            } else if (opcion2.equals("L")) {
                arreglo3 = anadir(arreglo3, sc);
                metodo3(arreglo3);
            } else if (opcion2.equals("P")) {
                arreglo3 = eliminar(arreglo3, sc);
                metodo3(arreglo3);

            } else if (opcion2.equals("X")) {
                descompletar(arreglo3, sc);
                metodo3(arreglo3);

            } else if (opcion2.equals("Y")) {
                break;
            }
            metodo4();
            metodo5();
            metodo4();
            opcion2 = metodo6(sc);
        }
        sc.close();
    }

    public static int metodo1(Scanner sc) {
        while (true) {
            try {
                System.out.println("Dijite las tareas a realizar");
                int tamano = sc.nextInt();
                if (tamano >= 1) {
                    return tamano;
                } else {
                    System.out.println("Dijite un numero del 1 a infinit0 pues.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Dijite un valor valido de 1 a numeros positivos enteros.");
                sc.nextLine();
            }
        }
    }

    public static String[][] metodo2(String[][] arreglo, Scanner sc) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.println("Dijite la tarea numero: " + (i + 1));
                arreglo[i][j] = sc.next();
            }
        }
        return arreglo;
    }

    public static String[][] metodo1(String[][] arreglo, Scanner sc) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 1; j < 2; j++) {
                arreglo[i][j] = "0";
            }
        }
        return arreglo;
    }

    public static void metodo3(String[][] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println((i + 1) + " " + arreglo[i][0] + " " + arreglo[i][1]);
        }
    }

    public static void metodo4() {
        System.out.println("---------------------------------");
    }

    public static void metodo5() {
        System.out.println("Dijite 0 si desea completar la tarea.");
        System.out.println("Dijite L si Desea agregar una tarea extra. ");
        System.out.println("Dijite P si desea eliminar una tarea");
        System.out.println("Dijite X para descompletar. ");
        System.out.println("Dijite Y para salir.");

    }

    public static String metodo6(Scanner sc) {
        while (true) {
            try {
                sc.nextLine();
                String opcion2 = sc.nextLine();
                if (opcion2.equals("0")) {
                    return opcion2;
                } else if (opcion2.equals("L")) {
                    return opcion2;
                } else if (opcion2.equals("P")) {
                    return opcion2;
                } else if (opcion2.equals("X")) {
                    return opcion2;
                } else if (opcion2.equals("Y")) {
                    return opcion2;
                } else {
                    System.out.println("Dijite una opcion valida kbron.");
                    sc.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Dijite un valor valido");
                sc.nextLine();
            }
        }
    }

    public static void completar(String[][] arreglo, Scanner sc) {
        while (true) {
            try {
                System.out.println("Dijite el número de la tarea a completar:");
                int tarea = sc.nextInt();
                sc.nextLine();
                if (tarea >= 1 && tarea <= arreglo.length) {
                    arreglo[tarea - 1][1] = "1";
                    System.out.println("Tarea completada: " + arreglo[tarea - 1][0]);
                    break;
                } else {
                    System.out.println("Dijite un número válido de tarea (entre 1 y " + arreglo.length + ")");
                }
            } catch (NumberFormatException e) {
                System.out.println("Dijite un número válido.");
            }
        }
    }

    public static void descompletar(String[][] arreglo, Scanner sc) {
        while (true) {
            try {
                System.out.println("Dijite el número de la tarea a descompletar:");
                int tarea = sc.nextInt();
                if (tarea >= 1 && tarea <= arreglo.length) {
                    if (arreglo[tarea - 1][1].equals("1")) {
                        arreglo[tarea - 1][1] = "0";
                        System.out.println("Tarea descompletada: " + arreglo[tarea - 1][0]);
                        break;
                    } else if (arreglo[tarea - 1][1].equals("0")) {
                        System.out.println("La tarea esta no ha sido completada aun.");
                        break;
                    }
                } else {
                    System.out.println("Dijite un número válido de tarea (entre 1 y " + arreglo.length + ")");
                }
            } catch (InputMismatchException e) {
                System.out.println("Dijite le num de la tarea valida.");
                sc.nextLine();
            }
        }
    }

    public static String[][] eliminar(String[][] arreglo, Scanner sc) {
        while (true) {
            try {
                System.out.println("Dijite la tarea a eliminar.");
                sc.nextLine();
                int tareaeliminar = sc.nextInt();
                if (tareaeliminar >= 1 && tareaeliminar <= arreglo.length) {
                    String[][] temp = new String[arreglo.length - 1][2];
                    int o = 0;
                    for (int i = 0; i < arreglo.length; i++) {
                        if (i + 1 == tareaeliminar) {
                            continue;
                        }
                        for (int j = 0; j < arreglo[i].length; j++) {
                            temp[o][j] = arreglo[i][j];
                        }
                        o++;
                    }
                    arreglo = temp;
                    return arreglo;
                } else {
                    System.out.println("Ingrese num valido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opcion valida.");
                sc.nextLine();
            }
        }
    }

    public static String[][] anadir(String[][] arreglo, Scanner sc) {
        String[][] temp = new String[arreglo.length + 1][2];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                temp[i][j] = arreglo[i][j];
            }
        }
        System.out.println("Dijite el valor " + (temp.length));
        sc.nextLine();
        temp[temp.length - 1][0] = sc.nextLine();
        temp[temp.length - 1][1] = "0";
        return temp;
    }
}
