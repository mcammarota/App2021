package br.edu.infnet.model.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.model.domain.Aluno;
import br.edu.infnet.model.repository.AlunoDao;

public class AlunoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public AlunoController() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tela = request.getParameter("tela");
		
		if("lista".equals(tela)) {
			request.getRequestDispatcher("aluno/cadastro.jsp").forward(request, response);
		} else {
			request.setAttribute("lista", AlunoDao.obterLista());		
			request.getRequestDispatcher("aluno/lista.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Aluno aluno = new Aluno(request.getParameter("nome"), request.getParameter("email"));
		aluno.setIdade(Integer.valueOf(request.getParameter("idade")));
		aluno.setMensalidade(Float.valueOf(request.getParameter("mensalidade")));
		aluno.setCurso(request.getParameter("curso"));
		aluno.setRegiao(request.getParameter("regiao"));
		aluno.setDisciplinas(request.getParameterValues("disciplinas"));
		
		AlunoDao.incluir(aluno);

		request.setAttribute("nomeDoAluno", aluno.getNome());	
		
		request.getRequestDispatcher("confirmacao.jsp").forward(request, response);
	}

}

//PrintWriter out = response.getWriter();
//
//out.println(
//		"<!DOCTYPE html>\r\n" + 
//		"<html>\r\n" + 
//		"<head>\r\n" + 
//		"<meta charset=\"ISO-8859-1\">\r\n" + 
//		"<title>APP2021 - Confirma!!!</title>\r\n" + 
//		"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n" + 
//		"</head>\r\n" + 
//		"<body>	\r\n" + 
//		"\r\n" + 
//		"	<div class=\"container\">\r\n" + 
//		"	  <h2>O aluno "+ aluno.getNome() +" foi cadastrado com sucesso!!!</h2>\r\n" + 
//		"	  <h3>Quantidade de alunos existentes: "+ alunos.size() +"</h3>\r\n" + 
//		"	  <hr>");
//
//for(Aluno a : alunos) {
//	out.println("<h3>Aluno: " + a.getNome()+"</h3>");
//}
//
//out.println(
//		"	  <a href='aluno'>Voltar</a>\r\n" + 
//		"	</div>\r\n" + 
//		"</body>\r\n" + 
//		"</html>");