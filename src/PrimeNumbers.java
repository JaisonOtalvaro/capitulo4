import java.util.Scanner;

/**
 * Clase PrimeNumbers muestra los numeros primos
 * @author Admin
 * @version 1.0.1
 * @see <a href="https://es.wikipedia.org/wiki/N%C3%BAmero_primo">Numeros primos</a>
 */
public class PrimeNumbers {
    private static boolean [] esPrimo;
    private static int [] primos;

    /**
     * Este es el metodo que genera los numeros primos hasta valor maximo que introduce usuario
     * @param max numero maximo hasta donde se genera los numeros primos
     * @return <ul>
     *     <li>Si cumple condicion trae vector de primos</li>
     *     <li>Si no cumple condicion trae vector vacio</li>
     * </ul>
     */
    public static int[] generarPrimos (int max) {
        if (max >= 2) {
            esPrimo = recorrerTabla(max);
            descartarNumerosMultiplos();
            primos = contarRellenar();
            return primos;
        } else {
            return new int[0];
        }
    }

    /**
     * Este metodo recorre vector
     * @param max numero maximo hasta donde se genera los numeros primos
     * @return vector booleano esPrimo sin el cero ni el uno
     *
     */
    private static boolean[] recorrerTabla(int max) {
        int i;
        esPrimo = new boolean[max + 1];
        for (i=0; i< esPrimo.length; i++)
            esPrimo[i] = true;
        esPrimo[0] = false;
        esPrimo[1] = false;
        return esPrimo;
    }

    /**
     * Este metodo descarta los numeros con multiplos ya que no seran primos
     */
    private static void descartarNumerosMultiplos() {
        int i;
        int j;
        for (i=2; i<Math.sqrt(esPrimo.length)+1; i++) {
            if (esPrimo[i]) {
                for (j=2*i; j< esPrimo.length; j+=i)
                    esPrimo[j] = false;
            }
        }
    }

    /**
     * Este metodo cuenta y rellena el vector con los numeros primos
     * @return vector primos con los numeros primos
     */
    private static int[] contarRellenar() {
        int i;
        int j;
        int cuenta = 0;
        for (i=0; i< esPrimo.length; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        primos = new int[cuenta];
        for (i=0, j=0; i< esPrimo.length; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }


    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int[] vector =new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vector[i]+"\t");
        }
    }
}
