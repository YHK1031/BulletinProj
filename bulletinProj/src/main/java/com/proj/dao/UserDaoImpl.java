package com.proj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User> theQuery = 
				currentSession.createQuery("from User order by ID",
											User.class);
		
		List<User> users = theQuery.getResultList();
		
		return users;
	}

	@Override
	public User getUser(String theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		User theUser = null;
		try {
			theUser = currentSession.get(User.class, theId);
		}catch(Exception e) {
			theUser = null;
		}
		
		return theUser;
	}

	@Override
	public void saveUser(User theUser) {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("At UserDaoSave : "+theUser.toString());
		currentSession.save(theUser);
	}

	@Override
	public void deleteUser(String theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("update User set validity=:validity where ID=:userId");
		theQuery.setParameter("validity", 0);
		theQuery.setParameter("userId", theId);
		
		theQuery.executeUpdate();		
		
	}

}
