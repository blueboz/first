package cn.boz.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class ActivitiMain {

	public static void main(String[] args) {
		
		ProcessEngineConfiguration pec = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
		//��ȡ�õ���������
		ProcessEngine pe = pec.buildProcessEngine();

		/*
		 * �����ǵڶ��ִ�����ʽ
		ProcessEngine buildProcessEngine = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
		.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE)
		.setJdbcUrl("jdbc:mysql:///activiti")
		.setJobExecutorActivate(true)
		.buildProcessEngine();
		*/	

	}
}
