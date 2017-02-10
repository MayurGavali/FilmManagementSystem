package com.flp.fms.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.fms.service.FilmServiceImpl;
import com.flp.fms.service.IFilmService;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String filmid=request.getParameter("filmid");
		System.out.println(filmid);
		IFilmService filmService=new FilmServiceImpl();
		boolean flag=filmService.deleteFilm(Integer.parseInt(filmid));
		if(!flag){
			request.getRequestDispatcher("DeleteFilmServlet").forward(request, response);
	}

	}}
