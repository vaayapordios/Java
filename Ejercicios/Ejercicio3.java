import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese su primer numero ");
        int numero1 = input.nextInt();
        System.out.print("Ingrese su segundo numero ");
        int numero2 = input.nextInt();
        System.out.print("Ingrese su tercer numero ");
        int numero3 = input.nextInt();

        if (numero1 > numero2) {
            int temp1 = numero1;
            numero1 = numero2;
            numero2 = temp1;
        }
        if (numero2 > numero3) {
            int temp2 = numero2;
            numero2 = numero3;
            numero3 = temp2;
        }
        if (numero3 > numero1) {
            int temp3 = numero1;
            numero1 = numero2;
            numero2 = temp3;
        }

        System.out.println("Los números ordenados de menor a mayor son: " + numero1 + " " + numero2 + " " + numero3);
    }
}