import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Seleccione la forma geométrica para calcular el área:");
        System.out.println("1. Cuadrado");
        System.out.println("2. Rectángulo");
        System.out.println("3. Círculo");
        System.out.println("4. Triángulo");
        System.out.print("Ingrese el número correspondiente a la forma geométrica: ");

        int opcion = input.nextInt();

        double area = 0;

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el lado del cuadrado: ");
                double ladoCuadrado = input.nextDouble();
                area = ladoCuadrado * ladoCuadrado;
                break;
            case 2:
                System.out.print("Ingrese la base del rectángulo: ");
                double baseRectangulo = input.nextDouble();
                System.out.print("Ingrese la altura del rectángulo: ");
                double alturaRectangulo = input.nextDouble();
                area = baseRectangulo * alturaRectangulo;
                break;
            case 3:
                System.out.print("Ingrese el radio del círculo: ");
                double radioCirculo = input.nextDouble();
                area = Math.PI * radioCirculo * radioCirculo;
                break;
            case 4:
                System.out.print("Ingrese la base del triángulo: ");
                double baseTriangulo = input.nextDouble();
                System.out.print("Ingrese la altura del triángulo: ");
                double alturaTriangulo = input.nextDouble();
                area = (baseTriangulo * alturaTriangulo) / 2;
                break;
            default:
                System.out.println("Opción inválida.");
        }

        if (opcion >= 1 && opcion <= 4) {
            System.out.println("El área de la figura seleccionada es: " + area);
        }

        input.close();
    }
}