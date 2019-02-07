package org.tiandy.KFWebService.sendMsg.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.tiandy.KFWebService.sendMsg.entity.msg.TbUser;

public interface SendMsgDao{
	public List<TbUser> findAll(Map<String,Object> map)  throws DataAccessException;
	
	
	
}
