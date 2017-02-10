package com.flp.fms.view;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Language;
import com.flp.fms.service.ActorServiceImpl;
import com.flp.fms.service.FilmServiceImpl;
import com.flp.fms.service.IActorService;
import com.flp.fms.service.IFilmService;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IFilmService filmService =new FilmServiceImpl();
		IActorService actorService=new ActorServiceImpl();
		List<Language> languages=filmService.getLanguages();
		List<Actor>actors=actorService.getActorList();
		List<Category>category=filmService.getCategory();
		PrintWriter out=response.getWriter();
		out.println("<html align='center'>");
		out.println("<head><title>Search Film</title>");
		out.println("<script type='text/javascript' src=''></script>"
				+ "<link rel='stylesheet' type='text/css' href='CSS_Style/Styles.css'>"
		+ "<link href='http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css' rel='stylesheet'>"
		 +"     <script src='http://code.jquery.com/jquery-1.10.2.js'></script>"
		    +"  <script src='http://code.jquery.com/ui/1.10.4/jquery-ui.js'></script>"
		      +"<!-- Javascript -->"
		  +"    <script>"
		  +"       $(function() {"
		     +"       $( '#datepicker1' ).datepicker({dateFormat:'dd-MM-yy'});"
		        +"    $( '#datepicker1' ).datepicker('show');"
		         +"});"
		         + "</script>");
		out.println("</head>"
						+"<body>");
		out.println("<h2>Search Film Here:</h2>");
		out.println("<form name='searchForm' action='SearchCoreServlet'");
		out.println("<div>");
			out.println("<table>");
				out.println("<tr>"
							+ "<td>");
								out.println("By FilmId:<input type='textbox' name='byId'/> ");
							out.println("</td>"
				+ "</tr>");
				out.println("<tr>"
							+ "<td>");
		
							out.println("By Rating:<input type='textbox' name='byRating'/> ");
							out.println("</td>"
							+ "</tr>");
					out.println("	<tr>"
							+"	<td>Release Date:<input type='text' id='datepicker1' name='releasedate' size='20'>"
							+"	</td>"
							+"	</tr>");
		out.println("<tr>"
				+ "	<td>");
					out.println("By Title:<input type='textbox' name='byTitle'/> ");
		out.println("</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>");
		
		out.println("By Language:<select name='byLanguage'>"
				+"<option value='0'>--Select--</option>");
		  for(Language lang:languages){
				out.println("<option value='"+ lang.getLanguage_Id()+"'>"
						+lang.getLanguageName()+ "</option>");	
		   }
		out.println("</select>");
		out.println("</td></tr>");
	
		out.println("<tr><td>");
		out.println("By Actor:<select name='byActor'>"
				+ "<option value='0'>--Select--</option>");
		for(Actor act: actors)
		{
			out.println("<option value='"+act.getActor_Id()+"'>"
					+act.getFirstName()+" "+act.getLastName()
					+"</option>");
			
		}
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>"
				+ "<tr>"
				+ "<td>"
				+ "<input type='submit' value='search' name='search'>"
				+ "</td>"
				+ "</tr>"
				);

		out.println("</table>");
		out.println("</div>");
	
	
	
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
