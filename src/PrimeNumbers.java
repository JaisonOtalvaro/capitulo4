import java.util.Scanner;
public class PrimeNumbers {
    private static boolean [] esPrimo;

    public static int[] generarPrimos (int max) {
        int i,j;
        if (max >= 2) {
            esPrimo = getBooleans(max);
// Criba
            for (i=2; i<Math.sqrt(esPrimo.length)+1; i++) {
                if (esPrimo[i]) {
// Eliminar los múltiplos de i
                    for (j=2*i; j< esPrimo.length; j+=i)
                        esPrimo[j] = false;
                }
            }
// ¿Cuántos primos hay?
            int cuenta = 0;
            for (i=0; i< esPrimo.length; i++) {
                if (esPrimo[i])
                    cuenta++;
            }
// Rellenar el vector de números primos
            int[] primos = new int[cuenta];
            for (i=0, j=0; i< esPrimo.length; i++) {
                if (esPrimo[i])
                    primos[j++] = i;
            }
            return primos;
        } else {
            return new int[0];
        }
    }

    private static boolean[] getBooleans(int max) {
        int i;
        esPrimo = new boolean[max + 1];
        for (i=0; i< esPrimo.length; i++)
            esPrimo[i] = true;
        esPrimo[0] = false;
        esPrimo[1] = false;
        return esPrimo;
    }

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int vector[]=new int[dato];
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
