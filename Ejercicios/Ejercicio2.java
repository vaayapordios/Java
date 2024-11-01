import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese un numero y le dire si es positivo o negativo ");
        int numero = input.nextInt();

        if (numero < 0) {
            System.out.println("Su numero es negativo");
        } else if (numero == 0) {
            System.out.println("Su numero es cero que no se considera ni negativo ni positivo");
        } else {
            System.out.println("Su numero es positivo");
        }

    }
}