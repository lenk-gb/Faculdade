package br.com.advocacialca.controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.model.bo.DespesaBO;
import br.com.advocacialca.model.to.Despesa;

/**
 * Servlet implementation class ListarDespesas
 */
@WebServlet("/ListaDespesa")
public class ListaDespesaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaDespesaServlet() {
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
			
			List<Despesa> listaDespesas = DespesaBO.getDespesa(numeroProcesso);
			request.setAttribute("listaDespesas", listaDespesas);
			request.setAttribute("razaoSocial", nomeCliente);
			
			request.getRequestDispatcher("listaDespesa.jsp").forward(request, response);
			
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
