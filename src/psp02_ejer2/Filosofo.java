package psp02_ejer2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa a un filósofo en el problema de la cena de los filósofos.
 */
public class Filosofo extends Thread {
    private Mesa mesa;
    private int numeroFilosofo;

    /**
     * Construye un filósofo asociado a una mesa.
     *
     * @param mesa           Mesa en la que se sientan los filósofos.
     * @param numeroFilosofo Número identificador del filósofo.
     */
    public Filosofo(Mesa mesa, int numeroFilosofo) {
        this.mesa = mesa;
        this.numeroFilosofo = numeroFilosofo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                pensar();
                System.out.println("Filosofo " + numeroFilosofo + " tiene hambre");
                mesa.cogerPalillos(numeroFilosofo);
                comer();
                System.out.println("Filosofo " + numeroFilosofo + " ha terminado de comer. Dejamos los palillos: "
                        + (mesa.obtenerPalilloIzquierdo(numeroFilosofo) + 1) + " y "
                        + (mesa.obtenerPalilloDerecho(numeroFilosofo) + 1));
                mesa.dejarPalillos(numeroFilosofo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Simula el estado de pensamiento de un filósofo.
     *
     * @throws InterruptedException Si ocurre una interrupción durante la ejecución.
     */
    public void pensar() throws InterruptedException {
        System.out.println("Filosofo " + numeroFilosofo + " esta pensando");
        sleep((long) (Math.random() * 2000));
    }

    /**
     * Simula el estado de comer de un filósofo.
     *
     * @throws InterruptedException Si ocurre una interrupción durante la ejecución.
     */
    public void comer() throws InterruptedException {
        System.out.println("Filosofo " + numeroFilosofo + " esta comiendo");
        sleep((long) (Math.random() * 2000));
    }
}
