package br.estacio.progII.ex01;

import java.util.ArrayList;
import java.util.List;

public class Ex01Class {

	private List<String> listaDaTabuada = new ArrayList<>();


	/**
	 * Alimenta a tabuada.
	 * @param tabuadaDo
	 * @param valorDe
	 * @param valorAte
	 * @return
	 */
	public List<String> alimentaListagem(String tabuadaDo, String valorDe, String valorAte) {

		listaDaTabuada = new ArrayList<>();

		for (int index = Integer.valueOf(valorDe); index <= Integer.valueOf(valorAte); index++) {

			
			listaDaTabuada.add(tabuadaDo + "x" + String.valueOf(index) + " = "
					+ String.valueOf((Integer.valueOf(tabuadaDo) * index) + " / "));

		}

		return listaDaTabuada;

	}

}
