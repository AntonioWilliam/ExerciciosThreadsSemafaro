package View;

import java.util.concurrent.Semaphore;

import controller.Cozinha;

public class Pincipal {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);

		for (int i = 1; i <= 5; i++) {

			Thread fila = new Cozinha(i, semaforo);
			fila.start();

		}

	}

}
