package com.flp.fms.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;
import com.flp.fms.service.FilmServiceImpl;
import com.flp.fms.service.IFilmService;

/**
 * Servlet implementation class DeleteFilmServlet
 */
public class DeleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		IFilmService filmService=new FilmServiceImpl();
		ArrayList<Film> films=filmService.getAllFilms();
		PrintWriter out=response.getWriter();	
		out.println("<html>");
		out.println("<head>"
				+"<link rel='stylesheet' type='text/css' href='CSS_Style/Styles.css'>"
				+ "</head>"
				+ "<body>"
				+ "<div style='margin-left:500px;'>  </div>"
				
				
				+ "<table border=1>"
				+ "<tr>"
				+ "<th> Film Id </th>"
				+ "<th> Name </th>"
				+ "<th>	Description	</th>"
				+ "<th>	Release Year	</th>"
				+ "<th>	Original Language	</th>"
				+ "<th>	Rental Duration	</th>"
				+ "<th> Other Lanugages"
				+ "<th> Actors"
				+ "<th>	Length	</th>"
				+ "<th>	Replacement Cost	</th>"
				+ "<th>	Category	</th>"
				+ "</tr>");
		
			for(Film film:films){
				out.println("<tr>");
				out.println("<td>"+film.getFilm_id()+"</td>");
				out.println("<td>"+film.getTitle()+"</td>");
				out.println("<td>"+film.getDescription()+"</td>");
				out.println("<td>"+film.getReleaseYear()+"</td>");
				out.println("<td>"+film.getOriginalLanguage().getLanguageName()+"</td>");
				out.println("<td>"+film.getRentalDuration()+"</td>");
				List<Language>langs=new ArrayList<>();
				langs=film.getLanguages();
				out.println("<td>");
				for(Language lang:langs)
					out.println(lang.getLanguageName());
				out.println("</td>");
			//	Set<Actor> actors =new HashSet<>();
				List<Actor> actors = new ArrayList<>();
				actors=film.getActors();
				out.println("<td>");
				
				for(Actor act:actors)
					out.println(act.getFirstName()+" "+act.getLastName());
				out.println("</td>");
				out.println("<td>"+film.getLength()+"</td>");
				out.println("<td>"+film.getReplacement()+"</td>");
				out.println("<td>"+film.getCategory().getcategory_name()+"</td>");
				out.println("<td><a href='DeleteServlet?filmid="+film.getFilm_id()+"'>Delete</a></td>");
				out.println("</tr>");
			}
				out.println("</table></body>");
	
				out.println("</html>");
		
			}


	}


