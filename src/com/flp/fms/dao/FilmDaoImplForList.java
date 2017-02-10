package com.flp.fms.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;

public class FilmDaoImplForList implements IFilmDao {


	
public Connection getConnection(){
		
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/fmsdatabase", "root", "Pass1234");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return connection;
	} 
	
	
	
	
	
	
	@Override
	public List<Language> getLanguages() {
		List<Language> languages=new ArrayList<>();
		
		
		
		Connection con=getConnection();
		String sql="select * from language";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
	
			
			ResultSet rs=pst.executeQuery();
			
		
		
			while(rs.next())
			{
		
			Language lang=new Language();
			lang.setLanguage_Id(rs.getInt(1));
			lang.setLanguageName(rs.getString(2));
			
			
			languages.add(lang);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		
		return languages;
	
	}

	@Override
	public List<Category> getCategory() {
		List<Category> categorys=new ArrayList<>();
		

		

		Connection con=getConnection();
		String sql="select * from category";
	
		
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				Category category1=new Category();
				category1.setCategory_Id(rs.getInt(1));
				category1.setCategory_name(rs.getString(2));
				
				
				categorys.add(category1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categorys;
		
}
	@Override
	public void addFilm(Film film) {
	//	film_Repository.put(film.getFilm_Id(), film);
		Film film1 = new Film();
		

		Connection con=getConnection();
		
		String sql="Insert into film (title,description,releaseYear,rentalDuration,originalLanguage,length,replacement,ratings,specialFeatures,category)"+" values (?,?,?,?,?,?,?,?,?,?)";
		
		
	try {
			
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, film.getTitle());
		pst.setString(2,film.getDescription());
		pst.setDate(3, new Date(film.getReleaseYear().getTime()));
		pst.setDate(4, new Date(film.getRentalDuration().getTime()));
		pst.setInt(5, film.getOriginalLanguage().getLanguage_Id());
		pst.setInt(6, film.getLength());
		pst.setDouble(7, film.getReplacement());
		pst.setInt(8, film.getRatings());
		pst.setString(9,film.getSpecialFeatures());
		pst.setInt(10,film.getCategory().getCategory_Id());
		int count=pst.executeUpdate();
		
		//if insertion to film table is success execute
		if(count>0){
			
			//insertion to third party tables
			int filmId=0;
			
			sql="select film_id from film order by film_id desc limit 1;";
					
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
					
				filmId = rs.getInt(1);
			}
			
			
			sql="insert into film_actors (film_id,actor_id) values(?,?)";
			pst = con.prepareStatement(sql);
			
			//getting all the actors in the film
			List<Actor> actors = film.getActors();		
			for(Actor act: actors){
				pst.setInt(1, filmId );
				pst.setInt(2, act.getActor_Id() );
				
				count=pst.executeUpdate();
			}
			
							
			sql="insert into film_language(film_id,language_id) values(?,?)";
			pst = con.prepareStatement(sql);
			
			//getting all the other languages
			List<Language> languages = film.getLanguages();				
			for(Language lang: languages){
				pst.setInt(1, filmId );
				pst.setInt(2, lang.getLanguage_Id());
				
				count=pst.executeUpdate();
			}
			
		}
	}
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		
		
		
		
		
	}
	





	@Override
	public Boolean deleteFilm(int filmid) {
		Connection con=getConnection();
		boolean flag=false;
		String sql="delete from film where film_id=?";
		String sql1="delete from film_language where film_id=?";
		String sql2="delete from film_actors where film_id=?";
		
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, filmid);
			int count=pst.executeUpdate();
			
			PreparedStatement pst1=con.prepareStatement(sql1);
			pst1.setInt(1, filmid);
			int count1=pst.executeUpdate();
			
			PreparedStatement pst2=con.prepareStatement(sql2);
			pst2.setInt(1, filmid);
			int count2=pst.executeUpdate();
			
			if(count>0 && count1>0 && count2>0)
				flag=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return flag;
	}
	






	@Override
	public ArrayList<Film> getAllFilms() {
		Connection con=getConnection();	
		ArrayList<Film> films=new ArrayList<Film>();
		 String sql="select * from film";
		 
			try {
				PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Film film=new Film();
					film.setFilm_id(rs.getInt(1));
					film.setTitle(rs.getString(2));
					film.setDescription(rs.getString(3));
					film.setReleaseYear(rs.getDate(4));
					film.setRentalDuration(rs.getDate(5));
					film.setLength(rs.getInt(6));
					String subsql;
					subsql="select LanguageName from language where LanguageId="+rs.getInt(7);
					PreparedStatement pst1=con.prepareStatement(subsql);
					ResultSet rs3=pst1.executeQuery();
					Language lang=new Language();
					if(rs3.next())
					{
						lang.setLanguage_Id(rs.getInt(7));
						lang.setLanguageName(rs3.getString(1));
					}
					film.setOriginalLanguage(lang);
					
				
					film.setReplacement(rs.getInt(8));
					film.setRatings(rs.getInt(9));
					film.setSpecialFeatures(rs.getString(10));
					
					subsql="select CategoryName from category where CategoryId="+rs.getInt(11);
					PreparedStatement pst3=con.prepareStatement(subsql);
				    rs3=pst3.executeQuery();
					if(rs3.next())
					{
						Category cat=new Category();
						cat.setCategory_Id(rs.getInt(11));
						cat.setCategory_name(rs3.getString(1));
						film.setCategory(cat);
					}
					
					subsql="select language_id from film_language where film_id="+rs.getInt(1);
					System.out.println(rs.getInt(1));
					pst3=con.prepareStatement(subsql);
				    rs3=pst3.executeQuery();
				    List<Language> languages=new ArrayList<>();
					while(rs3.next())
					{
												
						String subsql1="select LanguageName from language where LanguageId="+rs3.getInt(1);
						PreparedStatement pst2=con.prepareStatement(subsql1);
						ResultSet rs1=pst2.executeQuery();
						while(rs1.next()){
							Language langs=new Language();
							langs.setLanguage_Id(rs3.getInt(1));
							langs.setLanguageName(rs1.getString(1));
							languages.add(langs);
							
						}
					}
					film.setLanguages(languages);
					subsql="select actor_id from film_actors where film_id="+rs.getInt(1);
				
					pst3=con.prepareStatement(subsql);
				    rs3=pst3.executeQuery();
				  //  Set<Actor> actors=new HashSet<>();
				    List<Actor> actors = new ArrayList<>();
					while(rs3.next())
					{
						String subsql1="select CustFN,CustLN from actortable where ActorId="+rs3.getInt(1);
						PreparedStatement pst2=con.prepareStatement(subsql1);
						ResultSet rs1=pst2.executeQuery();
						while(rs1.next()){
							Actor actr=new Actor();
							actr.setFirstName(rs1.getString(1));
							//System.out.println("******"+rs1.getString(1));
							actr.setLastName(rs1.getString(2));
							actr.setActor_Id(rs3.getInt(1));
							actors.add(actr);
							
						}
					}
					film.setActors(actors);
					film.setLanguages(languages);
					System.out.println(film);
					films.add(film);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return films;
		
		
	}



	@Override
	public List<Film> searchFilm(Film film) {
		{
			Connection con=getConnection();
			int count=0;
			String sql="select * from film where";
			ArrayList<Film> films=new ArrayList<Film>();
			System.out.println(film);
			if(film!=null)
			{
				if(film.getFilm_id()>0)
				{
					
					sql+=" film_id="+film.getFilm_id();
					
					count=1;
				}
				
				if(film.getTitle()!=null)
				{
					if(count==1)
					{
						sql+=" and title='"+film.getTitle()+"'";
					}
					else
					{
						sql+=" title='"+film.getTitle()+"'";
					}
					count=2;
				}
			

				if(film.getRatings()>0)
				{
					if(count==1||count==2)
					{
						sql+=" and ratings="+film.getRatings();
					}
					else
					{
						sql+=" ratings="+film.getRatings();
					}
					count=3;
				}
				if(film.getActors()!=null)
				{
					Actor actor=new Actor();
					List<Actor> act=film.getActors();
					for(Actor a:act)
						actor=a;
					if(count==1||count==2||count==3)
					{
						sql+=" and film_id In(Select film_id from film_actors where actor_id="+actor.getActor_Id()+")";
						
					}else
					{
					sql+=" film_id In(Select film_id from film_actors where actor_id="+actor.getActor_Id()+")";
					}
					count=4;
				}
				if(film.getLanguages()!=null)
				{
					Language lang=new Language();
					List<Language> langs=film.getLanguages();
				
					for(Language l:langs)
						lang=l;
					if(count==1||count==2||count==3||count==4)
					{
						sql+=" and( film_id In(Select film_id from film_language where language_id="+lang.getLanguage_Id()+") or film_id In( Select film_id from film where originalLanguage="+lang.getLanguage_Id()+"))";
						
					}else
					{
					sql+=" ( film_id In(Select film_id from film_language where language_id="+lang.getLanguage_Id()+") or film_id In(Select film_id from film where originalLanguage="+lang.getLanguage_Id()+"))";
					
					}
					count=5;
				}
			
				 
				if(film.getReleaseYear()!=null)
				{
					if(count==1||count==2||count==3||count==4||count==5)
					{
						sql+=" and releaseYear='"+new java.sql.Date(film.getReleaseYear().getTime())+"'";
					}
					else
					{
						sql+=" releaseYear='"+new java.sql.Date(film.getReleaseYear().getTime())+"'";
					}
					count=6;
				}
				System.out.println(sql);
				try {
					PreparedStatement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
				
					while(rs.next())
					{
						Film film1=new Film();
						film1.setFilm_id(rs.getInt(1));
						film1.setTitle(rs.getString(2));
						film1.setDescription(rs.getString(3));
						
						film1.setReleaseYear(rs.getDate(4));
						film1.setRentalDuration(rs.getDate(5));
						film1.setLength(rs.getInt(6));
						
						String subsql;
						subsql="select LanguageName from language where LanguageId="+rs.getInt(7);
						PreparedStatement pst1=con.prepareStatement(subsql);
						ResultSet rs3=pst1.executeQuery();
						Language lang=new Language();
						if(rs3.next())
						{
							lang.setLanguage_Id(rs.getInt(7));
							lang.setLanguageName(rs3.getString(1));
						}
						film1.setOriginalLanguage(lang);
						
						
						film1.setReplacement(rs.getInt(8));
						film1.setRatings(rs.getInt(9));
						film1.setSpecialFeatures(rs.getString(10));
						
						subsql="select CategoryName from Category where CategoryId="+rs.getInt(11);
						PreparedStatement pst3=con.prepareStatement(subsql);
					    rs3=pst3.executeQuery();
						if(rs3.next())
						{
							Category cat=new Category();
							cat.setCategory_Id(rs.getInt(11));
							cat.setCategory_name(rs3.getString(1));
							film1.setCategory(cat);
						}
						
						subsql="select language_id from film_language where film_id="+rs.getInt(1);
						System.out.println(rs.getInt(1));
						pst3=con.prepareStatement(subsql);
					    rs3=pst3.executeQuery();
					    List<Language> languages=new ArrayList<>();
						while(rs3.next())
						{
													
							String subsql1="select LanguageName from LANGUAGE where LanguageId="+rs3.getInt(1);
							PreparedStatement pst2=con.prepareStatement(subsql1);
							ResultSet rs1=pst2.executeQuery();
							while(rs1.next()){
								Language langs=new Language();
								langs.setLanguage_Id(rs3.getInt(1));
								langs.setLanguageName(rs1.getString(1));
								languages.add(langs);
								
							}
						}
						film1.setLanguages(languages);
						subsql="select actor_id from film_actors where film_id="+rs.getInt(1);
					
						pst3=con.prepareStatement(subsql);
					    rs3=pst3.executeQuery();
					   
					    
						List<Actor>actors=new ArrayList<Actor>();
						while(rs3.next())
						{
							String subsql1="select CustFN,CustLN from ActorTable where ActorId="+rs3.getInt(1);
							PreparedStatement pst2=con.prepareStatement(subsql1);
							ResultSet rs1=pst2.executeQuery();
							while(rs1.next()){
								Actor actr=new Actor();
								actr.setFirstName(rs1.getString(1));
								actr.setLastName(rs1.getString(2));
								actr.setActor_Id(rs3.getInt(1));
								actors.add(actr);
								
							}
						}
						film1.setActors(actors);
						film1.setLanguages(languages);
						System.out.println(film1);
						films.add(film1);
				} }catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			}
			
			return films;
		}

	}
	
	@Override
	public Boolean updateFilm(Film film ) {

		Connection con=getConnection();
		 String sql="Update film Set title=?,description=?,releaseYear=?,rentalDuration=?,LENGTH=?,originalLanguage=?,replacement=?,ratings=?,specialFeatures=?,category=? where film_id="+film.getFilm_id();
		 
		 try {
			 	PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1,film.getTitle() );
				pst.setString(2,film.getDescription() );
				
				pst.setDate(3,new java.sql.Date(film.getReleaseYear().getTime()));
				pst.setDate(4,new java.sql.Date(film.getRentalDuration().getTime()));
				pst.setInt(5,film.getLength());
				pst.setInt(6,film.getOriginalLanguage().getLanguage_Id());
				
				
				pst.setDouble(7,film.getReplacement());
				pst.setInt(8,film.getRatings());
				pst.setString(9,film.getSpecialFeatures());
				Category cat=film.getCategory();
				pst.setInt(10,cat.getCategory_Id());
				int count=pst.executeUpdate();
				//if insertion to film table is success execute
				if(count>0){
					
					//insertion to third party tables
					int filmId=film.getFilm_id();
					
							
					sql="delete from film_actor where film_id="+filmId;
					PreparedStatement stmt = con.prepareStatement(sql);
					int count1= stmt.executeUpdate();
					
					sql="insert into film_actor(film_id,Actor_id) values(?,?)";
					pst = con.prepareStatement(sql);
					
					//getting all the actors in the film
					List<Actor> actors = film.getActors();			
					for(Actor act: actors){
						pst.setInt(1, filmId );
						pst.setInt(2, act.getActor_Id());
						
						count=pst.executeUpdate();
					}
					
					sql="delete from film_language where film_id="+filmId;
					 stmt = con.prepareStatement(sql);
					 count1= stmt.executeUpdate();
									
					sql="insert into film_language(film_id,language_id) values(?,?)";
					pst = con.prepareStatement(sql);
					
					//getting all the other languages
					List<Language> languages = film.getLanguages();				
					for(Language lang: languages){
						pst.setInt(1, filmId );
						pst.setInt(2, lang.getLanguage_Id());
						
						count=pst.executeUpdate();
					}
				
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return null;
	}

}

	
	
	


