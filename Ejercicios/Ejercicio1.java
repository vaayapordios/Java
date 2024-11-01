import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingresa el primer número: ");
        int numero1 = input.nextInt();

        System.out.print("Ingresa el segundo número: ");
        int numero2 = input.nextInt();

        if (numero1 == numero2) {
            System.out.print("Los numeros son iguales");
        } else {
            System.out.print("Los numeros no son iguales");
        }
    }
}
