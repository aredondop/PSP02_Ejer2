package psp02_ejer2;

import java.util.concurrent.Semaphore;

/**
 * Clase que representa una mesa con palillos para resolver el problema de la cena de los filósofos.
 */
public class Mesa {
    private Semaphore[] palillos;

    /**
     * Construye una mesa con palillos para la cena de los filósofos.
     *
     * @param numPalillos Número de palillos en la mesa.
     */
    public Mesa(int numPalillos) {
        this.palillos = new Semaphore[numPalillos];
        for (int i = 0; i < numPalillos; i++) {
            this.palillos[i] = new Semaphore(1); //Exactamente 1
        }
    }

    /**
     * Devuelve el índice del palillo a la izquierda del filósofo.
     *
     * @param filosofo Índice del filósofo.
     * @return Índice del palillo a la izquierda.
     */
    public int obtenerPalilloIzquierdo(int filosofo) {
        return filosofo;
    }

    /**
     * Devuelve el índice del palillo a la derecha del filósofo.
     *
     * @param filosofo Índice del filósofo.
     * @return Índice del palillo a la derecha.
     */
    public int obtenerPalilloDerecho(int filosofo) {
        return (filosofo + 1) % palillos.length; //Brujería
    }

    /**
     * Método que simula a un filósofo cogiendo palillos para comer.
     *
     * @param filosofo Índice del filósofo.
     * @throws InterruptedException Si ocurre una interrupción durante la ejecución.
     */
    public void cogerPalillos(int filosofo) throws InterruptedException {
        palillos[obtenerPalilloIzquierdo(filosofo)].acquire();
        palillos[obtenerPalilloDerecho(filosofo)].acquire();
    }

    /**
     * Método que simula a un filósofo dejando palillos después de comer.
     *
     * @param filosofo Índice del filósofo.
     */
    public void dejarPalillos(int filosofo) {
        palillos[obtenerPalilloIzquierdo(filosofo)].release();
        palillos[obtenerPalilloDerecho(filosofo)].release();
    }
}
