package com.proj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.entity.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Board> getBoards() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Board> theQuery = 
				currentSession.createQuery("from Board order by boardIdx desc",
						Board.class);
		
		List<Board> boards = theQuery.getResultList();
		
		return boards;
	}

	@Override
	public Board getBoard(Long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Board theBoard = null;
		try {
			theBoard = currentSession.get(Board.class, theId);
		}catch(Exception e) {
			theBoard = null;
		}

		return theBoard;
	}

	@Override
	public void saveBoard(Board theBoard) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theBoard);

	}

	@Override
	public void deleteBoard(Long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("delete from Board where boardIdx=:idx");
		theQuery.setParameter("idx", theId);
		
		theQuery.executeUpdate();	

	}

}
