import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 La parte de las mates esta realizada con la ayuda de gpt ya que
 soy terrible en mates, pase a grado medio con las mates de 4to ESO suspensas =)
 */

public class Main {
    // Define constantes para el tamaño de la matriz y la cantidad de hilos, inicializar matrices...
    private static final int SIZE = 512;
    private static final int THREAD_COUNT = 16;
    private static final float[][] matrix = new float[SIZE][SIZE];
    private static final float[] vector = new float[SIZE];
    private static final float[] result = new float[SIZE];
    private static final AtomicBoolean[] finished = new AtomicBoolean[THREAD_COUNT];

    public static void main(String[] args) {
        // Inicializa la matriz y el vector con los valores aleatorios
        initializeMatrixAndVector();
        // Inicializ los flags utilizados para hacer el seguimiento de la finalizacion de los hilos
        initializeFinishedFlags();

        // Crea un pool de hilos fijo para ejecutar la multiplicacion de la matriz en paralelo
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        // Asignar filas de la matriz a diferentes hilos para la multiplicacion
        for (int i = 0; i < THREAD_COUNT; i++) {
            int startRow = i * (SIZE / THREAD_COUNT);
            int endRow = (i + 1) * (SIZE / THREAD_COUNT);
            executor.execute(new MatrixMultiplier(i, startRow, endRow));
        }

        // Apaga el executor y esperar a que los hilos terminen
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        // Crea un hilo adicional para calcular e imprimir el módulo del vector resultante
        Thread informador = new Thread(() -> {
            double modulo = calculateModulo();
            System.out.println("El módulo del vector resultante es: " + modulo);
        });
        informador.start();

        // Espera a que el hilo del calculo del modulo termine
        try {
            informador.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    // Inicializa la matriz y el vector con valores aleatorios float
    private static void initializeMatrixAndVector() {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            vector[i] = random.nextFloat();
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = random.nextFloat();
            }
        }
    }

    // Inicializa los flags que indican cuando cada hilo ha completado su tarea
    private static void initializeFinishedFlags() {
        for (int i = 0; i < THREAD_COUNT; i++) {
            finished[i] = new AtomicBoolean(false);
        }
    }

    // Runnable para manejar la multiplicacion matriz-vector
    static class MatrixMultiplier implements Runnable {
        private final int threadIndex;
        private final int startRow;
        private final int endRow;

        public MatrixMultiplier(int threadIndex, int startRow, int endRow) {
            this.threadIndex = threadIndex;
            this.startRow = startRow;
            this.endRow = endRow;
        }

        @Override
        public void run() {
            // Multiplicar las filas asignadas de la matriz por el vector y almacenar los resultados
            for (int i = startRow; i < endRow; i++) {
                result[i] = 0;
                for (int j = 0; j < SIZE; j++) {
                    result[i] += matrix[i][j] * vector[j];
                }
            }
            finished[threadIndex].set(true); // Marcar este hilo como terminado
        }
    }

    // Calcular el modulo del vector resultante
    private static double calculateModulo() {
        double sum = 0;
        for (float value : result) {
            sum += value * value;
        }
        return Math.sqrt(sum);
    }
}