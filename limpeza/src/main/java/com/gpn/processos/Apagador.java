package com.gpn.processos;

import java.io.File;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Apagador {
	private List<File> arquivos;

	public void excluirArquivos() {
		for (File arquivo : arquivos) {
			arquivo.delete();
		}
	}
}