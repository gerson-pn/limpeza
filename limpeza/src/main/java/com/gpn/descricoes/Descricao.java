package com.gpn.descricoes;

public final class Descricao {
	private static final String comoUsar = "\n---------------------------------------------"
			+ "\nEste é o 'limpar', um aplicavo para excluir uma série de arquivos."
			+ "\nO limpar realiza uma busca por todos os arquivos a partir de seu diretório de execução."
			+ "\nOs arquivos que forem do mesmo tipo das extensões selecionadas serão apagados." + "\nComo executar:"
			+ "\n\njava-jar limpar[extensões]" + "\nAtenção as extenções serão passadas para um Array."
			+ "\nComo passar as extensões:" + "\njava -jar limpar -xls-pdf-doc" + "\n\nOnde:"
			+ "\n-xls é a extensão para excluir arquivos do tipo excel"
			+ "\n-pdf é a extensão para excluir arquivos do tipo PDF"
			+ "\n-doc é a extensão para excluir arquivos do tipo Microsoft Word"
			+ "\n\nEstas não são as únicas extensões aceitas, "
			+ "qualquer outra passada para o aplicativo será buscada. Portanto muito cuidado com seu uso!"
			+ "\n---------------------------------------------";

	public static String getComousar() {
		return comoUsar;
	}

}
