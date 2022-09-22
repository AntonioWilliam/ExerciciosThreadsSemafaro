package controller;

import java.util.concurrent.Semaphore;

public class Cozinha extends Thread {

	private int idThread;
	private Semaphore semaforo;

	public Cozinha(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {

		String[] infPrato = new String[2];

		try {

			cozinharPrato(infPrato);
			semaforo.acquire();
			entregaPrato(infPrato);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private String[] cozinharPrato(String[] tipo) {
		//Pratos de ID par, são chamados de Lasanha a Bolonhesa
		if ((idThread % 2) == 0) {

			try {
				// Lasanha a Bolonhesa e levam de 0,6 a 1,2 segundos para ficar prontos
				int tempoTotal = (int) (Math.random() * 601) + 600;

				tipo[0] = "Lasanha a Bolonhesa";
				System.out.println("Preparando uma " + tipo[0] + "\nThread n" + idThread + "\n");

				int tempo = 0;
				double percent = 0;
				while (tempoTotal > tempo) {
					//a cada 0,1 segundos, deve-se exibir o percentual de cozimento (O percentual é definido pelo tempo total dividido por 0,1 segundos).
					percent += 100 / (tempoTotal / 100);
					if (percent > 100)
						percent = 100;
					System.out.println("Thread n" + idThread + ":" + percent + "% finalizado\n");
					sleep(100);
					tempo += 100;

				}

				tipo[1] = String.valueOf(tempo);
				sleep(tempo);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		if ((idThread % 2) == 1) {

			try {

				int tempoTotal = (int) (Math.random() * 301) + 500;

				tipo[0] = "Sopa de Cebola";
				System.out.println("Preparando uma " + tipo[0] + "!\nThread n" + idThread + "\n");

				int tempo = 0;
				double percent = 0;
				while (tempoTotal > tempo) {

					percent += 100 / (tempoTotal / 100);
					if (percent > 100)
						percent = 100;
					System.out.println("Thread n" + idThread + ":" + percent + "% finalizado\n");
					sleep(100);
					tempo += 100;

				}

				tipo[1] = String.valueOf(tempo);
				sleep(tempo);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		return tipo;

	}

	private void entregaPrato(String[] tipo) {

		try {

			sleep(500);
			System.out.println( tipo[0] +": Thread num" + idThread  + " Tempo " + tipo[1] + "\n");
					} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}