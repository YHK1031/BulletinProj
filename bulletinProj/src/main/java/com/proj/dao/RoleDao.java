package com.proj.dao;

import com.proj.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
}
