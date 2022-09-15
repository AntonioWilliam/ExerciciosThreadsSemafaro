package controller;

public class Cozinha extends Thread {

	private int idPrato;
	static int inicio;
	static int fim;
	static int posicao=0;
	

	public Cozinha(int idPrato) {
		this.idPrato = idPrato;
	}

	// PratosImpares = int idImp = (int)((Math.random)()*)
	//
	@Override
	public void run() {
		pratoInicio();
		pratoFeito();
		pratoEntregue();

	}

	private void pratoInicio() {

		int cozinhando = 0;
		int tempoEspera = 50;
		int tempo = 100;

		if (idPrato % 2 == 0) {
			int tempoTotal = 1200;
			while (cozinhando < tempoTotal) {
				cozinhando += tempoEspera;
				System.out.println("#" + idPrato + " = " + " andamento: " + cozinhando);
				try {
					sleep(tempo);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("#" + idPrato + " = " + "posição:" + posicao);
			}
			
			
			
		} else {
			int tempoTotal = 800;
			while (cozinhando < tempoTotal) {
				cozinhando += tempoEspera;
				System.out.println("#" + idPrato + " = " + " andamento: " + cozinhando);
				try {
					sleep(tempo);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				posicao++;
				System.out.println("#" + idPrato + " = " + "posição:" + posicao);
			}
		}

	}

	private void pratoFeito() {

	}

	private void pratoEntregue() {

	}

}
