package org.tiandy.KFWebService.sendMsg.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.tiandy.KFWebService.sendMsg.entity.efoxParno.MMprodmaster;
import org.tiandy.KFWebService.sendMsg.entity.efoxResult.OdmPartComponent;
import org.tiandy.KFWebService.sendMsg.entity.efoxResult.ServerComponent;
import org.tiandy.KFWebService.sendMsg.entity.log.EfoxLogModel;
import org.tiandy.KFWebService.sendMsg.entity.parseTestResult.OsTestComponent;
import org.tiandy.KFWebService.sendMsg.entity.parseTestResult.OsTestResultJsonModel;

public interface OsMsgDao{
	public OsTestResultJsonModel findAll(Map<String,Object> map)  throws DataAccessException;
	
	public List<OsTestResultJsonModel> getTestResult()  throws DataAccessException;
	
	public void addComponent(OsTestComponent component) throws DataAccessException;
	
	public List<ServerComponent> getSendComponent(String pallents) throws DataAccessException;
	
	public void updateMMprocomponent(MMprodmaster mmprodmaster) throws DataAccessException;
	
	public List<MMprodmaster> findSkunos() throws DataAccessException;
	
	public List<OdmPartComponent> getOdmComponent(String pallents) throws DataAccessException;
	
	public void addLog(EfoxLogModel log) throws DataAccessException;
	
	public String getSendPallents(String transtype) throws DataAccessException;
	
	
}
