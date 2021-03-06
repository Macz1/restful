package com.sec.ax.restful.persistence.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.sec.ax.restful.persistence.UserPersistence;
import com.sec.ax.restful.pojo.Paging;
import com.sec.ax.restful.pojo.Query;
import com.sec.ax.restful.pojo.User;

/**
 * 
 * @author heesik.jeon
 *
 */

public class UserPersistenceImpl extends SqlMapClientDaoSupport implements UserPersistence {

    private static final Logger logger = Logger.getLogger(UserPersistenceImpl.class);
    
	/* 
	 * @see com.sec.ax.restful.persistence.UserPersistence#getUsers(com.sec.ax.restful.pojo.Query)
	 */
	@Override
	public List<User> getUsers(Query query) throws DataAccessException {

        logger.debug("..");

        Paging paging = query.getPaging();
        
    	@SuppressWarnings("unchecked")
        List<User> list = getSqlMapClientTemplate().queryForList("user.getUsers", query, paging.getSkipResults(), paging.getMaxResults());
    	
		return list;
		
	}

	/* 
	 * @see com.sec.ax.restful.persistence.UserPersistence#cntUser()
	 */
	@Override
	public int cntUser() throws DataAccessException {
		
        logger.debug("..");
		
        return (int) getSqlMapClientTemplate().queryForObject("user.cntUser");
		
	}

	/* 
	 * @see com.sec.ax.restful.persistence.UserPersistence#getUser(String)
	 */
	@Override
	public User getUser(String name) throws DataAccessException {

        logger.debug("..");
        
    	User user = (User) getSqlMapClientTemplate().queryForObject("user.getUser", name);
        
		return user;
		
	}

	/* 
	 * @see com.sec.ax.restful.persistence.UserPersistence#createUser(com.sec.ax.restful.pojo.User)
	 */
	@Override
	public int createUser(User user) throws DataAccessException {

        logger.debug("..");
        
        return (int) getSqlMapClientTemplate().insert("user.createUser", user);
		
	}

	/* 
	 * @see com.sec.ax.restful.persistence.UserPersistence#updateSid(int)
	 */
	@Override
	public int updateSid(User user) throws DataAccessException {

        logger.debug("..");
        
        return getSqlMapClientTemplate().update("user.updateSid", user);
		
	}

	/* 
	 * @see com.sec.ax.restful.persistence.UserPersistence#updateUser(com.sec.ax.restful.pojo.User)
	 */
	@Override
	public int updateUser(User user) throws DataAccessException {
		
		logger.debug("..");
		
		return getSqlMapClientTemplate().update("user.updateUser", user);
		
	}
	
	/* 
	 * @see com.sec.ax.restful.persistence.UserPersistence#deleteUser(com.sec.ax.restful.pojo.User)
	 */
	@Override
	public int deleteUser(User user) throws DataAccessException {
		
		logger.debug("..");
		
		return getSqlMapClientTemplate().delete("user.deleteUser", user);
		
	}

	/* 
	 * @see com.sec.ax.restful.persistence.UserPersistence#loginUser(com.sec.ax.restful.pojo.User)
	 */
	@Override
	public User loginUser(User user) throws DataAccessException {

        logger.debug("..");
        
        user = (User) getSqlMapClientTemplate().queryForObject("user.loginUser", user);
        
		return user;

	}

}