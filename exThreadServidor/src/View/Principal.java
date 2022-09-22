package View;

import java.util.concurrent.Semaphore;

import controller.ThreadServidor;

public class Principal {

	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);

		for (int i = 1; i <= 21; i++) {

			ThreadServidor server = new  ThreadServidor(i, semaforo);
			server.start();

		}

	}

}