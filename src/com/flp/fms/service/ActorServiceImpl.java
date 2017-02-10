package com.flp.fms.service;

import java.util.List;


import com.flp.fms.dao.ActorDaoImplForList;

import com.flp.fms.domain.Actor;

public class ActorServiceImpl implements IActorService{

	ActorDaoImplForList actorDao=new ActorDaoImplForList();

	@Override
	public List<Actor> addActor() {
		// TODO Auto-generated method stub
		return actorDao.addActor();
	}

	@Override
	public List<Actor> getActorList() {
		// TODO Auto-generated method stub
		return actorDao.getActorList();
	}

	
	
	
}
