package org.tiandy.KFWebService.sendMsg.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.tiandy.KFWebService.sendMsg.dao.SendMsgDao;
import org.tiandy.KFWebService.sendMsg.entity.B2BLogMsgRequest;
import org.tiandy.KFWebService.sendMsg.entity.B2BMQMsgRequest;
import org.tiandy.KFWebService.sendMsg.entity.B2BMQMsgResponse;
import org.tiandy.KFWebService.sendMsg.entity.EfoxApiRequest;
import org.tiandy.KFWebService.sendMsg.entity.EfoxApiResponse;
import org.tiandy.KFWebService.sendMsg.entity.Config.B2BUrlEntity;
import org.tiandy.KFWebService.sendMsg.entity.efoxParno.MMprodmaster;
import org.tiandy.KFWebService.sendMsg.entity.efoxResult.EfoxComponent;
import org.tiandy.KFWebService.sendMsg.entity.efoxResult.OdmPartComponent;
import org.tiandy.KFWebService.sendMsg.entity.efoxResult.ServerComponent;
import org.tiandy.KFWebService.sendMsg.entity.log.EfoxLogModel;
import org.tiandy.KFWebService.sendMsg.entity.parseTestResult.OsTestComponent;
import org.tiandy.KFWebService.sendMsg.entity.parseTestResult.OsTestResultJsonModel;

import com.alibaba.fastjson.JSON;

@RestController
@Service
public class SendComponentService {
//	private String url ="https://tssp.tencent.com/open_api/logic_test";
//	private String serverIp="10.67.37.83";
//	private String serverPort="8082";
//	private String mqUrl ="http://"+serverIp+":"+serverPort+"/tencent/message";
//	private String logUrl="http://"+serverIp+":"+serverPort+"/logs";
	public static String SERVER_ACTION="SupplierWriteServerPartInfo";
	public static String ODM_ACTION="SupplierWriteOdmPartInfo";
	@Resource
	SendMsgDao osMsgDao;
	@Resource
	B2BUrlEntity b2BUrlEntity;
	
	
	Logger logger = Logger.getLogger(SendComponentService.class);
	@ResponseBody
	@RequestMapping(path="/test",produces="application/json")
	public EfoxComponent test(){
		OdmPartComponent component = new OdmPartComponent();
		component.setId("test");
		return component;
	}
	
	
	
	private void addLog(String apiname,String msgId,String msgType,String data){
		EfoxLogModel log = new EfoxLogModel();
		log.setLogDate(new Date());
		log.setData(data);
		log.setApiname(apiname);
		log.setMsgId(msgId);
		log.setMsgType(msgType);
		try {
			//this.osMsgDao.addLog(log);
		} catch (Exception e) {
			logger.error("recode log error:",e);
		}
	}
	
}
