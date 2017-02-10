package com.flp.fms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.flp.fms.domain.Actor;


public class ActorDaoImplForList implements IActorDao {

	@Override
	public List<Actor> addActor() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public List<Actor> getActorList() {
		List<Actor> actor=new ArrayList<>();

		
		
		FilmDaoImplForList filmDao=new FilmDaoImplForList();
		Connection con=filmDao.getConnection();
		
		String sql="select * from actortable";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				Actor actor1=new Actor();
				actor1.setActor_Id(rs.getInt(1));
				actor1.setFirstName(rs.getString(2));
				actor1.setLastName(rs.getString(3));
				actor.add(actor1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actor;
	}
}

	

		
	