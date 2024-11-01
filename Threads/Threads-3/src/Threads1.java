public class Threads1 extends Thread {
    /* Entero donde se almacenan los numeros para los calculos
    */
    private int[] numeros;

    /* String que define el tipo de calculo que se va a realizar.
    */
    private String tipoCalculo;

    /* Variables donde se almacenaran los resultados
     */
    private double resultadoMedia;
    private int valorMaximo;
    private int valorMinimo;
    private double resultadoDesviacion;

    /**
     * Constructor de la clase Threads1.
     * @param numeros arreglo de enteros sobre el que se realizaran los calculos
     * @param tipoCalculo String que especifica el tipo de calculo a realizar (media, maxMin y la desviacion)
     */
    public Threads1(int[] numeros, String tipoCalculo) {
        this.numeros = numeros;
        this.tipoCalculo = tipoCalculo;
    }

    /**
     * Este metodo se ejecuta cuando el hilo es iniciado
     * Dependiendo del valor de 'tipoCalculo'se ejecuta el cálculo correspondiente.
     */
    @Override
    public void run() {
        // Utilizamos un switch para saber el tipo de calculo solicitado.
        switch (tipoCalculo) {
            case "media":
                // Si el tipo de cálculo es "media", se llama al método calcularMedia
                calcularMedia();
                break;
            case "maxMin":
                 // Si el tipo de cálculo es "maxMin", se llama al método calcularMaxMin.
                calcularMaxMin();
                break;
            case "desviacion":
                // Si el tipo de calculo es "desviacion", se llama al metodo calcularDesviacionTipica
                calcularDesviacionTipica();
                break;
            default:
                // Se imprime un mensaje de error
                System.out.println("Tipo de calculo no reconocido");
                break;
        }
    }

    /**
     * Metodo que calcula la media aritmetica de los numeros en el arreglo.
     * El resultado se almacena en la variable 'resultadoMedia'.
     */
    private void calcularMedia() {
        double suma = 0; // Variable para acumular la suma de los numeros
        for (int num : numeros) {
            suma += num; // Se suman todos los elementos del arreglo
        }
        // La media se obtiene dividiendo la suma entre el numero de elementos
        resultadoMedia = suma / numeros.length;
    }

    /**
     * Metodo que encuentra el valor maximo y minimo del arreglo de numeros.
     * Los resultados se almacenan en las variables 'valorMaximo' y 'valorMinimo'.
     */
    private void calcularMaxMin() {
        /* Inicialización de los valores maximo y minimo con el primer elemento del arreglo
         */
        valorMaximo = numeros[0];
        valorMinimo = numeros[0];

        /* Recorrer el arreglo para encontrar los valores maximo y minimo
         */
        for (int num : numeros) {
            if (num > valorMaximo) {
                valorMaximo = num; // Actualizar el valor maximo si se encuentra un numero mayor
            }
            if (num < valorMinimo) {
                valorMinimo = num; // Actualizar el valor minimo si se encuentra un numero menor
            }
        }
    }

    /**
     * Metodo que calcula la desviacion estandar de los numeros en el arreglo.
     * El resultado se almacena en la variable 'resultadoDesviacion'.
     */
    private void calcularDesviacionTipica() {
        double suma = 0; // Variable para acumular la suma de los numeros
        for (int num : numeros) {
            suma += num; // Suma de todos los numeros del arreglo
        }
        // Calcular la media aritmetica
        double media = suma / numeros.length;

        double sumDiferencias = 0; // Variable para acumular la suma de las diferencias al cuadrado
        for (int num : numeros) {
            // Sumar el cuadrado de la diferencia de cada numero con la media
            sumDiferencias += Math.pow(num - media, 2);
        }

        // Calcular la desviacion estandar (raiz cuadrada del promedio de las diferencias al cuadrado)
        resultadoDesviacion = Math.sqrt(sumDiferencias / numeros.length);
    }

    /**
     * Metodo para obtener el resultado de la media aritmetica calculada.
     * @return double que contiene el valor de la media.
     */
    public double getResultadoMedia() {
        return resultadoMedia;
    }

    /**
     * Metodo para obtener el valor maximo calculado en el arreglo.
     * @return int que contiene el valor maximo.
     */
    public int getValorMaximo() {
        return valorMaximo;
    }

    /**
     * Metodo para obtener el valor minimo calculado en el arreglo.
     * @return int que contiene el valor minimo.
     */
    public int getValorMinimo() {
        return valorMinimo;
    }

    /**
     * Metodo para obtener el resultado de la desviacion estandar calculada.
     * @return double que contiene el valor de la desviacion estandar.
     */
    public double getResultadoDesviacion() {
        return resultadoDesviacion;
    }
}
