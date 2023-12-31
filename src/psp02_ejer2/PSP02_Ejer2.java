package psp02_ejer2;

/**
 * Clase principal que crea una mesa y cinco filósofos, y los inicia.
 */
public class PSP02_Ejer2 {

    /**
     * Método principal del programa.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Mesa mesa = new Mesa(5);
        for (int i = 1; i <= 5; i++) {
            Filosofo filosofo = new Filosofo(mesa, i);
            filosofo.start();
        }
    }
}
