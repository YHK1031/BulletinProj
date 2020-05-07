package com.proj.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.entity.BoardKind;

@Repository
public class BoardKindDaoImpl implements BoardKindDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public BoardKind getBoardKind(String theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		BoardKind theBoardKind = null;
		try {
			theBoardKind = currentSession.get(BoardKind.class, theId);
		}catch(Exception e) {
			theBoardKind = null;
		}
		
		return theBoardKind;
	}

	@Override
	public void saveBoard(BoardKind theBoardKind) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoardKind(String theId) {
		// TODO Auto-generated method stub

	}

}
