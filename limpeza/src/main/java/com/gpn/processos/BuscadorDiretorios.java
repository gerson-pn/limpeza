package com.gpn.processos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BuscadorDiretorios implements Buscador {
	private File diretorioRaiz;
	private List<File> arquivosSelecionados = new ArrayList<>();

	public BuscadorDiretorios(File diretorioRaiz) {
		this.diretorioRaiz = diretorioRaiz;
	}

	private List<File> buscarProfundamente(List<File> arquivosSelecionados, File diretorioRaiz) {
		String[] nomesArquivosInternos = diretorioRaiz.list();
		for (String nome : nomesArquivosInternos) {
			File arquivoInterno = new File(diretorioRaiz, nome);
			if (arquivoInterno.isDirectory()) {
				arquivosSelecionados.add(arquivoInterno);
				buscarProfundamente(arquivosSelecionados, arquivoInterno);
			}
		}
		return arquivosSelecionados;
	}

	@Override
	public List<File> buscar() {
		return buscarProfundamente(arquivosSelecionados, diretorioRaiz);
	}
}