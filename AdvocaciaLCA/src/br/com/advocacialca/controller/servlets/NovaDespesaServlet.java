package br.com.advocacialca.controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.model.bo.TipoDespesaBO;
import br.com.advocacialca.model.to.TipoDespesa;

/**
 * Servlet implementation class LancarDespesaServlet
 */
@WebServlet("/NovaDespesa")
public class NovaDespesaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovaDespesaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numeroProcessoTexto = request.getParameter("numeroProcesso");
		String nomeCliente = request.getParameter("cliente");
		
		int numeroProcesso = Integer.parseInt(numeroProcessoTexto);
		
		try {
			
			List<TipoDespesa> tiposDespesaList = new ArrayList<TipoDespesa>();
			
			tiposDespesaList = TipoDespesaBO.buscarTiposDespesa();
			
			//O que será enviado para JSP
			request.setAttribute("listaTiposDespesa", tiposDespesaList);
			request.setAttribute("numeroProcesso", numeroProcesso);
			request.setAttribute("cliente", nomeCliente);
			
			request.getRequestDispatcher("novaDespesa.jsp").forward(request, response);
			
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
