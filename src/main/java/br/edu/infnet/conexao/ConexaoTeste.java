package br.edu.infnet.conexao;

import br.edu.infnet.conexao.Conexao;

public class ConexaoTeste {
	
	public static void main(String[] args) {
		
		if(Conexao.obterConexao() != null) {
			System.out.println("Conectou!");
		} else {
			System.err.println("Erro na conex�o!");
		}
	}
}
