package com.gpn.processos;

import java.io.File;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Listador {
	private List<File> arquivos;
	
	public void listarNomesArquivos() {
		for (File arquivo : arquivos) {
			System.out.println(arquivo.getName());
		}
	}
}