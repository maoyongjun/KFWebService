package org.tiandy.KFWebService.sendMsg.factory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.tiandy.KFWebService.sendMsg.dao.OsMsgDao;
import org.tiandy.KFWebService.sendMsg.entity.efoxResult.EfoxComponent;
import org.tiandy.KFWebService.sendMsg.service.SendComponentService;

@Component
public class EfoxComponentFactorys {
	@Resource
	OsMsgDao osMsgDao;
	
	public class EfoxComponentFactory{
		public List<? extends EfoxComponent> getComponent(String action,String pallents){
			List<? extends  EfoxComponent> list  =null;
			if(SendComponentService.SERVER_ACTION.equals(action)){
				list = osMsgDao.getSendComponent(pallents); 
			}else if(SendComponentService.ODM_ACTION.equals(action)){
				list = osMsgDao.getOdmComponent(pallents); 
			}
			
			return list;
		}
	}
}
