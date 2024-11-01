import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // Crear un arreglo de 100 numeros aleatorios
        int[] numeros = new int[100];
        Random rand = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rand.nextInt(1000);
        }

        // Crea los hilos para realizar los calculos (media, max/min y desviacion)
        Threads1 hiloMedia = new Threads1(numeros, "media");
        Threads1 hiloMaxMin = new Threads1(numeros, "maxMin");
        Threads1 hiloDesviacion = new Threads1(numeros, "desviacion");

        // Iniciar los hilos
        hiloMedia.start();
        hiloMaxMin.start();
        hiloDesviacion.start();

        // Esperar a que los hilos terminen
        try {
            hiloMedia.join();
            hiloMaxMin.join();
            hiloDesviacion.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimir los resultados obtenidos por los hilos
        System.out.printf("La media es: %.2f\n", hiloMedia.getResultadoMedia());
        System.out.println("El valor maximo es: " + hiloMaxMin.getValorMaximo());
        System.out.println("El valor minimo es: " + hiloMaxMin.getValorMinimo());
        System.out.printf("La desviacion tipica es: %.2f\n", hiloDesviacion.getResultadoDesviacion());

        // Mensaje de finalizacion
        System.out.println("Se han realizado todos los calculos.");
    }
}
