package com.gpn.processos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BuscadorArquivos implements Buscador {
	private List<File> diretorios;
	private String extensao;

	public BuscadorArquivos(List<File> diretorios, String extensao) {
		this.diretorios = diretorios;
		this.extensao = extensao;
	}

	private List<File> buscarPorExtensao() {
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

	private List<File> buscarTodos() {
		List<File> arquivosSelecionados = new ArrayList<>();
		for (File diretorio : diretorios) {
			String[] nomesArquivosInternos = diretorio.list();
			for (String nome : nomesArquivosInternos) {
				File arquivoInterno = new File(diretorio, nome);
				if (arquivoInterno.isFile()) {
					arquivosSelecionados.add(arquivoInterno);
				}
			}
		}
		return arquivosSelecionados;
	}

	@Override
	public List<File> buscar() {
		List<File> arquivosSelecionados = new ArrayList<>();
		if (this.extensao != null) {
			arquivosSelecionados = this.buscarPorExtensao();
		} else {
			arquivosSelecionados = this.buscarTodos();
		}
		return arquivosSelecionados;
	}
}