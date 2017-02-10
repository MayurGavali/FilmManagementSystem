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

/**
 * Servlet implementation class UserInteractionServlet
 */
public class UserInteractionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		
		FilmServiceImpl filmService=new FilmServiceImpl();
		ActorServiceImpl actorService=new ActorServiceImpl();
		
		List<Actor> actor=actorService.getActorList();
		List<Language> languages=filmService.getLanguages();
		List<Category> category=filmService.getCategory();
		


		out.println("<html>");
		out.println("<head align='center'>");


		
		out.println(
				"<link rel='stylesheet' href='//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css'>"+
				  "<script src='//code.jquery.com/jquery-1.10.2.js'></script>"+
				  "<script src='//code.jquery.com/ui/1.11.4/jquery-ui.js'></script>"+
				  "<link rel='stylesheet' href='css/myStyle.css'>"+
				  "<script>$(function() {$('#datepicker1').datepicker({maxDate:'0'});});</script>"+
				"<script>$(function() {$( '#datepicker2' ).datepicker();});</script>");
		
		

		out.println( "<script type='text/javascript' src='Script/validate.js'></script>");	
		out.println("<title>Film Details</title>");
		out.println("</head>");

		out.println("<body>");


		out.println("<form name='filmf' method='post' action='SavefilmServlet'>");

		out.println("<h2><center>Film Registration Form</center></h1>");
		out.print("<table>");


		out.println("<tr>"
			+"<td>FilmTitle:</td>"
			+"<td><input type='text' name='filmtitle' size='20' onmouseout='return  istitlevalidate()'>"
			+"<div id='titleerr' class='errMsg'></td>"
			+"</td>"
			+"</tr>");
			
			
		out.println("<tr>"
			+"<td>Film Description:</td>"
			+"<td><textarea rows='4' name='filmdescription' cols='25' onmouseout='return  isdescriptionvalidate()'></textarea>"
			+"<div id='descerr' class='errMsg'></td>"
			+"</td>"
			+"</tr>");
			
			
			

		out.println("<tr>"
		+"<td>Release Date:</td>"
		+"<td>"
		+"<input type='text' name='releasedate' id='datepicker1' size='20' >"
		+"</td>"
		+"</tr>");
			
			
		out.println("<tr>"
				+"<td>Rental Duration:</td>"
				+"<td><input type='text' name='rentalduration' id='datepicker2' size='20' onmouseout='return isrentaldurationvalid()'>"
				+ "<div id='rentaldurationerr' class='errMsg'></td>"
				+"</tr>");
		

		out.println("<tr>"
				+"<td>FilmLength:</td>"
				+"<td><input type='text' name='filmlength' size='20' onmouseout='return  islengthvalid()'>"
						+"<div id='lenghterr' class='errMsg'> </div>"
						+"</td>"
		
		+"</tr>"
		+"<tr>");
			
			out.println("<tr>"
			+"<td>Replacement Cost:</td>"
			+"<td><input type='text' name='replacementcost' size='20' onmouseout='return isreplacementcostvalid()'>"
			+"<div id='replacementcosterr' class='errMsg'> </div>"
			+"</td>"
			
	+"</tr>"
	+"<tr>");
			
			
			out.println("<tr>"
				+"<td>Film Rating:</td>"
				+"<td>"
				+"<select name='rating' onmouseout='return isratingSelected()'>"
						+"<option value='1'>1</option>"
						+"<option value='2'>2</option>"
						+"<option value='3'>3</option>"
						+"<option value='4'>4</option>"
						+"<option value='5'>5</option>"
					+"</select>"
					+"<div id='rating' class='errMsg'></td>"
					+"</td>"
				+"</tr>");
				
			
			
			out.println("<tr>"
			+"<td>Special Features:</td>"
			+"<td>"
				+"<textarea rows='4' name='specialfeature' cols='25'></textarea>"
			+"</td>"
			+"</tr>");
			

			

							
		out.print("<tr><td>Actor :</td>"
+ "<td><select name='actor' multiple = ''>");
for(Actor actor1:actor){

out.print("<option value='"+actor1.getActor_Id()+"'>"+actor1.getActor_Id()+"-"+actor1.getFirstName()+"_"+actor1.getLastName()+"</option>");
}
out.print("</select>"
+"</td>"
+"</tr>");
				
			
			
			       
			
			out.print("<tr><td>Original Language :</td>"
					+ "<td><select name='orgLang'>");
			
			
			for(Language lang:languages){
				out.print("<option value='"+lang.getLanguage_Id()+"'>"+lang.getLanguage_Id()+" "+lang.getLanguageName()+"</option>");
			}
		out.print("</select></td></tr>");
		
		
		out.print("<tr><td>Other Language :</td>"
				+ "<td><select name='othLang'  multiple = ''>");
		
			for(Language lang:languages){
				out.print("<option value='"+lang.getLanguage_Id()+"'>"+lang.getLanguage_Id()+" "+lang.getLanguageName()+"</option>");
		}
		out.print("</select></td></tr>");
		
		
			
				
			
			out.print("<tr><td>Category:</td>"
					+ "<td><select name='category'>");
			for(Category category1:category){
				out.print("<option value='"+category1.getCategory_Id()+"'> "+category1.getcategory_name()+"</option>");
			}
		out.print("</select></td></tr>");
				
			
			
			out.println("<tr>"
				+"<td></td>"
				+"<td><input type='submit' value='Save'>"
				+"<input type='reset' value='Clear'>"
				 +"</td>"
			+"</tr>");
			
	out.println("</table>");


		out.println("</form>");


		out.println("</body>");
		out.println("</html>");

		
	}

	}

