package br.com.advocacialca.controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.model.bo.TipoHonorarioBO;
import br.com.advocacialca.model.to.TipoHonorario;

/**
 * Servlet implementation class AlteraHonorarioServlet
 */
@WebServlet("/AlteraHonorario")
public class AlteraHonorarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlteraHonorarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numeroProcesso = request.getParameter("numeroProcesso");
		String nomeCliente = request.getParameter("cliente");
		String codigoTipoHonorario = request.getParameter("codigoHonorario");
		String codigoLancamento = request.getParameter("codigo");
		
		try {
			
			List<TipoHonorario> tiposHonoraioList = new ArrayList<TipoHonorario>();			
			tiposHonoraioList = TipoHonorarioBO.buscarTiposHonorario();
			
			//O que será enviado para JSP
			request.setAttribute("listaTiposHonorario", tiposHonoraioList);
			request.setAttribute("numeroProcesso", numeroProcesso);
			request.setAttribute("cliente", nomeCliente);
			request.setAttribute("codigoTipoHonorario", codigoTipoHonorario);
			request.setAttribute("codigo", codigoLancamento);
			
			request.getRequestDispatcher("alteraHonorario.jsp").forward(request, response);
			
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
