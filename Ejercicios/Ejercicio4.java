import javax.swing.*;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese un numero entre 1 y 1000 ");
        int numero = input.nextInt();

        if (numero < 1 || numero > 1000) {
            System.out.println("Lo siento pero ese numero no se encuentra entre 1 y 1000");
        }else{
            String numeroS = String.valueOf(numero);
            int cantidadDigitos = numeroS.length();
            System.out.println("El numero " + numero + " tiene " + cantidadDigitos + " digitos.");
        }
    }


}
