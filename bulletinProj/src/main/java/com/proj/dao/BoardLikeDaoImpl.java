package com.proj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.entity.BoardLike;

@Repository
public class BoardLikeDaoImpl implements BoardLikeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<BoardLike> getBoardLikes() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<BoardLike> theQuery = 
				currentSession.createQuery("from BoardLike order by boardLikeIdx",
						BoardLike.class);
		
		List<BoardLike> boards = theQuery.getResultList();
		
		return boards;
	}

	@Override
	public BoardLike getBoardLike(Long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		BoardLike theBoardLike = null;
		try {
			theBoardLike = currentSession.get(BoardLike.class, theId);
		}catch(Exception e) {
			theBoardLike = null;
		}
		
		return theBoardLike;
	}

	@Override
	public void saveBoardLike(BoardLike theBoardLike) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theBoardLike);
	}

	@Override
	public void deleteBoardLike(Long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("delete from BoardLike where boardLikeIdx=:idx");
		theQuery.setParameter("idx", theId);
		
		theQuery.executeUpdate();	
	}

}
