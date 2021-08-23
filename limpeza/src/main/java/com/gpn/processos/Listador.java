package com.gpn.processos;

import java.io.File;
import java.util.List;

public class Listador {
	private List<File> arquivos;

	public Listador(List<File> arquivos) {
		this.arquivos = arquivos;
	}

	public void listarNomesArquivos() {
		for (File arquivo : arquivos) {
			System.out.println(arquivo.getName());
		}
	}
}