package com.gpn.processos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BuscadorArquivos implements Buscador {
	private List<File> diretorios;
	private String extensao;

	@Override
	public List<File> buscar() {
		List<File> arquivosSelecionados = new ArrayList<>();
		for (File diretorio : diretorios) {
			String[] nomesArquivosInternos = diretorio.list();
			for (String nome : nomesArquivosInternos) {
				File arquivoInterno = new File(diretorio, nome);
				if (arquivoInterno.getName().endsWith(extensao)) {
					arquivosSelecionados.add(arquivoInterno);
				}
			}
		}
		return arquivosSelecionados;
	}

}
