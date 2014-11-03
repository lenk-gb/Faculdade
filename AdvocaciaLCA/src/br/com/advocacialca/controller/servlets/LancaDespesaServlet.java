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
import br.com.advocacialca.model.bo.DespesaBO;
import br.com.advocacialca.model.to.Despesa;
import br.com.advocacialca.model.to.Processo;
import br.com.advocacialca.model.to.TipoDespesa;

/**
 * Servlet implementation class LancarDespesaServlet
 */
@WebServlet("/LancaDespesa")
public class LancaDespesaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LancaDespesaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String numeroProcessoTexto = request.getParameter("numeroProcesso");
		String tipoDespesaTexto = request.getParameter("tipoDespesa");
		String dataDespesaTexto = request.getParameter("dataDespesa");
		String valorDespesaTexto = request.getParameter("valorDespesa");
		String observacao = request.getParameter("observacaoDespesa");
		
		// Faendo conversão dados que vem como String e precisam sere convertidos para tipos diversos
		int numeroProcesso = Integer.parseInt(numeroProcessoTexto);
		int tipoDispesa = Integer.parseInt(tipoDespesaTexto);
		double valorDespesa = Double.parseDouble(valorDespesaTexto.replace(",", "."));
		
		// Convertendo data
		Calendar data = null;
		try {
			data = DataFormatada.formatarData(dataDespesaTexto);
		} catch (ParseException e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("erro/listaProcesso.jsp").forward(request, response);
		}
		
		// Objetos para passar através do TO
		Despesa objDespesa = new Despesa();
		TipoDespesa objTipoDespesa = new TipoDespesa();
		Processo objProcesso = new Processo();
		
		//Setando valores
		objTipoDespesa.setCodigo(tipoDispesa);
		objDespesa.setTipoDespesa(objTipoDespesa);
		
		objProcesso.setNumeroProcesso(numeroProcesso);
		objDespesa.setProcesso(objProcesso);

		objDespesa.setData(data);
		objDespesa.setValor(valorDespesa);
		objDespesa.setObservacao(observacao);
		
		try {
			
			DespesaBO.inserirDespesa(objDespesa);
			
			String mensagem = "Lançamento de despesa realizado com sucesso para o processo número: "+ objDespesa.getProcesso().getNumeroProcesso();
			
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
		
	}

}
