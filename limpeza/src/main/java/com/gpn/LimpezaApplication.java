package com.gpn;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gpn.descricoes.Descricao;
import com.gpn.processos.Apagador;
import com.gpn.processos.Buscador;
import com.gpn.processos.BuscadorArquivos;
import com.gpn.processos.BuscadorDiretorios;
import com.gpn.processos.BuscadorDiretoriosVazios;
import com.gpn.processos.Listador;
import com.gpn.processos.SeparadorExtensao;

@SpringBootApplication
public class LimpezaApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(LimpezaApplication.class, args);
		if (args.length < 1) {
			System.out.println(Descricao.getComousar());
		} else {
			String[] extensoes = args[0].split("-");
			SeparadorExtensao separadorExtensao = new SeparadorExtensao(extensoes);
			List<String> extensoesCorretas = separadorExtensao.separarExtensoes();
			File diretorioRaiz = new File(".");
			Buscador buscadorDiretorios = new BuscadorDiretorios(diretorioRaiz);
			List<File> diretorios = buscadorDiretorios.buscar();
			diretorios.add(diretorioRaiz);
			for (String extensao : extensoesCorretas) {
				System.out.println("Excluindo arquivos da extensão: ." + extensao);
				Buscador buscadorArquivos = new BuscadorArquivos(diretorios, extensao);
				List<File> arquivos = buscadorArquivos.buscar();
				Listador listador = new Listador(arquivos);
				listador.listarNomesArquivos();
				Apagador apagador = new Apagador(arquivos);
				apagador.excluirArquivos();
			}
			Buscador buscadorDiretoriosVazios = new BuscadorDiretoriosVazios(diretorios);
			List<File> diretoriosVazios = buscadorDiretoriosVazios.buscar();
			do {
				Apagador apagadorDiretoriosVazios = new Apagador(diretoriosVazios);
				apagadorDiretoriosVazios.excluirArquivos();
				diretoriosVazios = buscadorDiretoriosVazios.buscar();
			} while (diretoriosVazios.size() > 0);
		}
	}
}