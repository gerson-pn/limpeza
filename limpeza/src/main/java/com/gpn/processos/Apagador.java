package com.gpn.processos;

import java.io.File;
import java.util.List;

public class Apagador {
	private List<File> arquivos;

	public Apagador(List<File> arquivos) {
		this.arquivos = arquivos;
	}

	public void excluirArquivos() {
		for (File arquivo : arquivos) {
			arquivo.delete();
		}
	}
}