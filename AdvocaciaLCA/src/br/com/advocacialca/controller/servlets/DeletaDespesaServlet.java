package br.com.advocacialca.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.model.bo.DespesaBO;

/**
 * Servlet implementation class DeletaDespesaServlet
 */
@WebServlet("/DeletaDespesa")
public class DeletaDespesaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletaDespesaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numeroProcesso = request.getParameter("numeroProcesso");
		String codigoTexto = request.getParameter("codigo");
		String cliente = request.getParameter("Cliente");
		
		int codigo = Integer.parseInt(codigoTexto);
		
		try {
			
			DespesaBO.deletarDespesa(codigo);
			
			String textoConfirmacao = "Despesa Excluída com sucesso";
			
			request.setAttribute("mensagem", textoConfirmacao);		
			request.getRequestDispatcher("ListaDespesa?numeroProcesso="+numeroProcesso+"&cliente="+cliente).forward(request, response);
			
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
