package com.gpn.processos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BuscadorDiretoriosVazios implements Buscador {
	private List<File> diretorios;

	public BuscadorDiretoriosVazios(List<File> diretorios) {
		this.diretorios = diretorios;
	}

	private List<File> buscarVazios() {
		List<File> diretoriosVazios = new ArrayList<File>();
		for (File diretorio : diretorios) {
			String[] arquivosInternos = diretorio.list();
			if (arquivosInternos != null) {
				if (arquivosInternos.length == 0) {
					diretoriosVazios.add(diretorio);
				}
			}
		}
		return diretoriosVazios;
	}

	@Override
	public List<File> buscar() {
		return buscarVazios();
	}

}
