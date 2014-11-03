package br.com.advocacialca.controller.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.controller.util.DataFormatada;
import br.com.advocacialca.model.bo.HonorarioBO;
import br.com.advocacialca.model.to.Honorario;
import br.com.advocacialca.model.to.Processo;
import br.com.advocacialca.model.to.TipoHonorario;

/**
 * Servlet implementation class LancaHonorario
 */
@WebServlet("/LancaHonorario")
public class LancaHonorario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LancaHonorario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String numeroProcessoTexto = request.getParameter("numeroProcesso");
		String tipoHonorarioTexto = request.getParameter("tipoHonorario");
		String dataHonorarioTexto = request.getParameter("dataHonorario");
		String valorHonorarioTexto = request.getParameter("quantidadeHora");
		String observacao = request.getParameter("observacao");
		
		// Faendo conversão dados que vem como String e precisam sere convertidos para tipos diversos
		int numeroProcesso = Integer.parseInt(numeroProcessoTexto);
		int tipoHonorario = Integer.parseInt(tipoHonorarioTexto);
		double quantidadeHora = Double.parseDouble(valorHonorarioTexto.replace(",", "."));
		
		// Convertendo data
		Calendar data = null;
		try {
			data = DataFormatada.formatarData(dataHonorarioTexto);
		} catch (ParseException e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("erro/listaProcesso.jsp").forward(request, response);
		}
		
		Honorario objHonorario = new Honorario();
		TipoHonorario objTipoHonorario = new TipoHonorario();
		Processo objProcesso = new Processo();
		
		objTipoHonorario.setCodigo(tipoHonorario);		
		objHonorario.setTipoHonorario(objTipoHonorario);
		
		objProcesso.setNumeroProcesso(numeroProcesso);
		objHonorario.setProcesso(objProcesso);
		
		objHonorario.setQuantidadeHora(quantidadeHora);
		objHonorario.setData(data);
		objHonorario.setObservacao(observacao);
		
		try {
			
			HonorarioBO.inserirHonorario(objHonorario);
			
			String mensagem = "Lançamento de honorário realizado com sucesso para o processo número: "+ objHonorario.getProcesso().getNumeroProcesso();
			
			request.setAttribute("sucesso", mensagem);
			request.getRequestDispatcher("ListaProcesso").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("erro/listaProcesso.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
