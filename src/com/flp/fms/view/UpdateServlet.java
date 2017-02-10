package com.flp.fms.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;
import com.flp.fms.service.ActorServiceImpl;
import com.flp.fms.service.FilmServiceImpl;
import com.flp.fms.service.IActorService;
import com.flp.fms.service.IFilmService;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filmid=request.getParameter("filmid");
		SimpleDateFormat df=new SimpleDateFormat("dd-MMMM-yyyy");
		IFilmService filmService=new FilmServiceImpl();
		IActorService actorService=new ActorServiceImpl();
		List<Language> languages=filmService.getLanguages();
		List<Actor> actors=actorService.getActorList();
		List<Category> category=filmService.getCategory();
		PrintWriter out=response.getWriter();
		Film tempFilm=new Film();
		tempFilm.setFilm_id(Integer.parseInt(filmid));
		List<Film> films=filmService.searchFilm(tempFilm);
		Film film=new Film();
		if(!films.isEmpty())
			for(Film f:films)
				film=f;
		out.println("<!DOCTYPE html>"
				+"<html>"
				+"<head>"
				+"<link rel='stylesheet' type='text/css' href='CSS_Style/Styles.css'>"
				+"<meta charset='ISO-8859-1'>"
				+ "<link href='http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css' rel='stylesheet'>"
				 +"     <script src='http://code.jquery.com/jquery-1.10.2.js'></script>"
				    +"  <script src='http://code.jquery.com/ui/1.10.4/jquery-ui.js'></script>"
				      +"<!-- Javascript -->"
				  +"    <script>"
				  +"       $(function() {"
				     +"       $( '#datepicker1' ).datepicker({maxDate:'0', dateFormat:'dd-MM-yy'});"
				        +"    $( '#datepicker1' ).datepicker('show');"
				         +"});"
				         +"$(function() {"
				           +  "$( '#datepicker2' ).datepicker({dateFormat:'dd-MM-yy'});"
				            +" $( '#datepicker2' ).datepicker('show');"
				         +" });"
				      +"</script>"
				      +"<script type='text/javascript' src='Script/validate.js'></script>"
			+"	<title>Update Film</title>"
			+"</head>"
			+"	<body>"
			+"	<form name='updatefilm' method='get'action='UpdatingServlet' >"
			+"	<h3>Film Registration Form</h3>"
			+"	<table>"
					+ "<tr><td><input type=text  name=filmid value='"+filmid+"' hidden><td><tr>"
					+"<tr>"
					+"<td>Film Title:</td>"
					+"<td><input type='text' name='filmtitle' size='20' value="+film.getTitle()+" onmouseout='return isValidTitle()'>"
					+"<div id='titleErr' class='errMsg'></div></td></td>"
					+"</tr>"
					
					+"<tr>"
				+"	<td>Description:</td>"
				+"	<td>"
					+"	<textarea rows='4' name='filmdescription' cols='25' >"+film.getDescription()+"</textarea>"
				+"	</td>"
					+"</tr>"
					
				+"	<tr>"
				+"	<td>Release Date:</td>"
					+"<td><input type='text' id='datepicker1' name='releasedate' size='20' value="+df.format(film.getReleaseYear())+" >"
				+"	</td>"
				+"	</tr>"
				+"	<tr>"
				+"	<td>Rental Duration:</td>"
					+"<td><input type='text' id ='datepicker2' name='rentaldate' size='20' value='"+df.format(film.getRentalDuration())+"'onmouseout='return isValidRentalDate()'>"
					+"<div id='dateErr' class='errMsg'></div></td>"
					+"</tr>"
					
					+"<tr>"
					+"<td>Film Duration:</td>"
					+"<td><input type='text' name='filmduration' size='20'value="+film.getLength()+" onmouseout='return isValidLength()'>"
					+"<div id='lengthErr' class='errMsg'></div>"
					+"</td>"
					+"</tr>"
					
					+"<tr>"
					+"<td>Replacement Cost:</td>"
					+"<td><input type='text' name='filmreplacementcost' size='20' value="+film.getReplacement()+" onmouseout='return isValidCost()'>"
					+"<div id='costErr' class='errMsg'></div></td>"
					+"</tr>"
					
					+"<tr>"
					+"	<td>Rating:</td>"
						+"<td>"
					+"	<select name='rating' >");
						for(int i=1;i<5;i++)
						{	if(i==film.getRatings())
							out.println("<option value='"+i+"'selected>"+i+"</option>");
						else
							out.println("<option value='"+i+"'>"+i+"</option>");
						}
						
							
							
						
					out.println("</select>"
						
					+"	</td>"
				+"	</tr>"
					
					+"<tr>"
				+"	<td>Special Features:</td>"
					+"<td>"
					+"	<textarea rows='4' name='filmspecialfeatures' cols='25'>"+film.getSpecialFeatures()+"</textarea>"
					+"</td>"
				+"	</tr>"
					
					
					+"<tr>"
					+"	<td>Actors:</td>"
						+"<td>"
					+"	<select name='actors'  multiple >");
						for(Actor actor:actors)
						{
							int flag=0;
							for(Actor act:film.getActors())
							{
								if(act.getActor_Id()==actor.getActor_Id())
								{
									out.println("<option value='"+actor.getActor_Id()+"'selected>"+actor.getFirstName()+" "+actor.getLastName() +"</option>");
									flag=1;
									break;
								}
								}
							if(flag!=1)
								out.println("<option value='"+actor.getActor_Id()+"'>"+actor.getFirstName()+" "+actor.getLastName() +"</option>");
								
						}	
						out.println("</select>"
						
					+"	</td>"
						
					
					+"</tr>"
					
			+"<tr>"
					+"	<td>Original Language:</td>"
						+"<td s>"
						+"<select name='language'>");
							for(Language language:languages){
								if(film.getOriginalLanguage().getLanguage_Id()==language.getLanguage_Id())
								{out.println("<option value='"+ language.getLanguage_Id()+"'selected>" + language.getLanguageName() +"</option>");
							}
								else
									out.println("<option value='"+ language.getLanguage_Id()+"'>" + language.getLanguageName() +"</option>");
							}
									out.println("</select>");
								
							
						
						
						
						out.println("</td>"
					+"</tr>"
					+"<tr>"
					+"	<td>Other Languages:</td>"
						+"<td>"
					+"	<select name='languages' multiple> ");
						for(Language language:languages)
						{
							 int flag=0;
							for(Language lang:film.getLanguages())
								{
								if(lang.getLanguage_Id()==language.getLanguage_Id()){
									out.println("<option value='"+ language.getLanguage_Id()+"'selected>" + language.getLanguageName() +"</option>");
									flag=1;
									break;
								}}
							
							if(flag!=1)
								
									out.println("<option value='"+ language.getLanguage_Id()+"'>" + language.getLanguageName() +"</option>");
								
							
						}
								out.println("</select>"
							
						
						+"</select>"
						
					+"	</td>"
					+"</tr>"
					
					+"<tr>"
					+"	<td>Category:</td>"
						+"<td >"
						+"<select name='category'>");
								for(Category cat:category){
								if(cat.getCategory_Id()==film.getCategory().getCategory_Id())
									out.println("<option value='"+ cat.getCategory_Id()+"' selected>" + cat.getcategory_name()+"</option>");
								else
									out.println("<option value='"+ cat.getCategory_Id()+"'>" + cat.getcategory_name()+"</option>");
								}
					out.println("</select>"
						
						+"</td>"
				+"	</tr>"
					
				+"	<tr>"
						+"<td></td>"
						+"<td><input type='submit' value='Update'>"
						+"<input type='reset' value='Clear'>"
						+" </td>"
					+"</tr>"
					
				+"</table>"


				+"</form>"

			+"	</body>"
			+"	</html>");
					
				
					
					
		Boolean flag=filmService.updateFilm(film);
		//if(!flag)
		}
		
	
	}

	




