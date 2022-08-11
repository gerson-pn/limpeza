package com.gpn.processos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BuscadorDiretoriosGit implements Buscador {
	private List<File> diretorios;
	private Buscador buscadorDiretorios;

	public BuscadorDiretoriosGit(List<File> diretorios) {
		this.diretorios = diretorios;
	}

	private List<File> buscarRaizes() {
		List<File> diretoriosGit = new ArrayList<File>();
		for (File diretorio : diretorios) {
			String nome = diretorio.getName();
			if (nome.startsWith(".git")) {
				diretoriosGit.add(diretorio);
			}
		}
		return diretoriosGit;
	}

	private List<File> buscarInternos(List<File> diretoriosRaizes) {
		List<File> diretoriosInternos = new ArrayList<File>();
		for (File diretorio : diretoriosRaizes) {
			buscadorDiretorios = new BuscadorDiretorios(diretorio);
			diretoriosInternos.addAll(buscadorDiretorios.buscar());
		}
		return diretoriosInternos;
	}

	@Override
	public List<File> buscar() {
		List<File> raizes = this.buscarRaizes();
		List<File> internos = this.buscarInternos(raizes);
		List<File> todos = new ArrayList<File>();
		todos.addAll(raizes);
		todos.addAll(internos);
		return todos;
	}

}
