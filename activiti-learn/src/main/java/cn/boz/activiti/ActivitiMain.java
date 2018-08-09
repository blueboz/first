package cn.boz.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class ActivitiMain {

	public static void main(String[] args) {
		
		ProcessEngineConfiguration pec = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
		//获取得到流程引擎
		ProcessEngine pe = pec.buildProcessEngine();

		/*
		 * 下面是第二种创建方式
		ProcessEngine buildProcessEngine = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
		.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE)
		.setJdbcUrl("jdbc:mysql:///activiti")
		.setJobExecutorActivate(true)
		.buildProcessEngine();
		*/	

	}
}
