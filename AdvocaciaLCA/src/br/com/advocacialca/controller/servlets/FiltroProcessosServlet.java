package br.com.advocacialca.controller.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.controller.util.DataFormatada;
import br.com.advocacialca.model.bo.ProcessoBO;
import br.com.advocacialca.model.to.Processo;

/**
 * Servlet implementation class FiltroProcessos
 */
@WebServlet("/Filtro")
public class FiltroProcessosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiltroProcessosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String numeroProcessoTexto = request.getParameter("numeroProcesso");
		String nomeCliente = request.getParameter("nomeCliente");
		String dataInicio = request.getParameter("deData");
		String dataFim = request.getParameter("ateData");
		
		List<Processo> processoList = new ArrayList<Processo>();
		
		//Verifica se usuário não preencheu nenhum campo
		if((numeroProcessoTexto.isEmpty()) && (nomeCliente.isEmpty()) && (dataInicio.isEmpty()) && (dataFim.isEmpty())){
			String mensagemAviso = "Preencha ao menos 1 campo para realizar a busca!";
			request.setAttribute("aviso", mensagemAviso);
			request.getRequestDispatcher("erro/listaProcesso.jsp").forward(request, response);
		} else 
			if(!(numeroProcessoTexto.isEmpty()) ){
				
				int numeroProcesso = Integer.parseInt(numeroProcessoTexto);
				
				try {
					
					processoList = ProcessoBO.getProcesso(numeroProcesso);
					
					request.setAttribute("listaProcessos", processoList);
					request.getRequestDispatcher("listaProcesso.jsp").forward(request, response);
					
				} catch (Exception e) {
					request.setAttribute("erro", e.getMessage());
					request.getRequestDispatcher("erro/listaProcesso.jsp").forward(request, response);
				}
		} else 
			if((numeroProcessoTexto.isEmpty()) && !(nomeCliente.isEmpty())){
				try {
					
					processoList = ProcessoBO.getProcesso(nomeCliente);
					
					request.setAttribute("listaProcessos", processoList);
					request.getRequestDispatcher("listaProcesso.jsp").forward(request, response);
					
				} catch (Exception e) {
					request.setAttribute("erro", e.getMessage());
					request.getRequestDispatcher("erro/listaProcesso.jsp").forward(request, response);
				}
		} else 
			if((numeroProcessoTexto.isEmpty()) && (nomeCliente.isEmpty()) && !(dataInicio.isEmpty()) && !(dataFim.isEmpty())){
				
				Calendar inicio = null;
				Calendar fim = null;
				
				try {
					inicio = DataFormatada.formatarData(dataInicio);
					fim = DataFormatada.formatarData(dataFim);
				} catch (ParseException e1) {
					request.setAttribute("erro", e1.getMessage());
					request.getRequestDispatcher("erro/listaProcesso.jsp").forward(request, response);
				}
				
				try {
					processoList =  ProcessoBO.getProcesso(inicio, fim);
					
					request.setAttribute("listaProcessos", processoList);
					request.getRequestDispatcher("listaProcesso.jsp").forward(request, response);
					
				} catch (Exception e) {
					request.setAttribute("erro", e.getMessage());
					request.getRequestDispatcher("erro/listaProcesso.jsp").forward(request, response);
				}
				
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
