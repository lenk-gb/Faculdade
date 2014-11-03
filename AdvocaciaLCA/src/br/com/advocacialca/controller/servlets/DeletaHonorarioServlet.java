package br.com.advocacialca.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.model.bo.HonorarioBO;

/**
 * Servlet implementation class DeletaHonorarioServlet
 */
@WebServlet("/DeletaHonorario")
public class DeletaHonorarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletaHonorarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigoTexto = request.getParameter("codigo");
		int codigo = Integer.parseInt(codigoTexto);
		
		try {
			
			HonorarioBO.deletarHonorario(codigo);
			
			String textoConfirmacao = "Despesa Excluída com sucesso";
			
			request.setAttribute("mensagem", textoConfirmacao);		
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
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
