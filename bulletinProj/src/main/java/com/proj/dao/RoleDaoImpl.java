package com.proj.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public Role findRoleByName(String theRoleName) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using name
		Query<Role> theQuery = currentSession.createQuery("from Role where role_id=:roleName", Role.class);
		theQuery.setParameter("roleName", theRoleName);
		
		Role theRole = null;
		
		try {
			theRole = theQuery.getSingleResult();
		} catch (Exception e) {
			theRole = null;
		}
		System.out.println("theRole : "+theRole.toString());
		return theRole;
	}

}
