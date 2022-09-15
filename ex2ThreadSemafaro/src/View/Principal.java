package View;

import controller.Cozinha;

public class Principal {

	public static void main(String[] args) {
		for (int idPrato=0;idPrato<5;idPrato++) {
			Thread cz = new Cozinha(idPrato) ;
			cz.start();
		}

	}

}
