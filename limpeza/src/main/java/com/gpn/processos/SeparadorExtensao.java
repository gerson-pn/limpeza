package com.gpn.processos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SeparadorExtensao {
	private String[] extensoes;

	public List<String> separarExtensoes() {
		List<String> extensoesCorretas = new ArrayList<>();
		for (String extensao : extensoes) {
			String espacoRemovido = extensao.trim();
			if (!espacoRemovido.equals("")) {
				extensoesCorretas.add(espacoRemovido);
			}
		}
		return extensoesCorretas;
	}
}