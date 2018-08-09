package cn.boz.activiti;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:activiti.cfg.xml")
public class ActivitiTest {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private DeploymentBuilder deploymentBuilder; 

	@Autowired
	private RuntimeService runtimeService;
	

	@Autowired
	private StandaloneProcessEngineConfiguration spec;



	@Test
	public void deploy() throws JsonProcessingException{
		var dp = repositoryService.createDeployment();
		var rst=dp.addClasspathResource("cn/boz/activiti/def/Blueboz.bpmn")
				.addClasspathResource("cn/boz/activiti/def/Blueboz.png")
				.name("�����������")
				.category("sscz")
				.deploy();
		var rtn=objectMapper.writeValueAsString(rst);
		System.out.println(rtn);
	}
	
	@Test
	public void startProcess() throws JsonProcessingException {
		var pi=runtimeService.startProcessInstanceByKey("boz");
		System.out.println(pi.getId());
	}

	@Autowired
	private TaskService taskService ;
	@Test
	public void queryMyTask() {
		var tsks= taskService.createTaskQuery().taskAssignee("fozzie").list();
		tsks.forEach(it->{
			System.out.println(it.getId()+"===>"+it.getName());
		});
		System.out.println(tsks.size());
	}
	
	@Test
	public void completeTask() {
		taskService.complete("105002");
		System.out.println("�������");
	}
	
	@Test
	public void deleteDeployment() {
		var list=repositoryService.createProcessDefinitionQuery()
							.processDefinitionKey("myProcess3")
							.orderByProcessDefinitionVersion().asc()
							.list();
		list.forEach(it->{
			//ɾ��ָ������ID������
			repositoryService.deleteDeployment(it.getDeploymentId(),true);
		});
	}

	
	@Test
	public void queryLastest() {
		var list=repositoryService.createProcessDefinitionQuery()
						.orderByProcessDefinitionVersion().asc()
						.list();
		var map=new HashMap<String,ProcessDefinition>();
		if(!CollectionUtils.isEmpty(list)) {
			list.forEach(it->{
				map.put(it.getKey(), it);
			});
		}
		map.forEach((k,v)->{
			System.out.println(v.getName()+":"+v.getVersion());
	
		});
	}
	
	@Test
	public void queryPI() {
		var pi=runtimeService.createProcessInstanceQuery() 
				.processInstanceId("100001")
				.singleResult();
		//ע��ProcessInstance�Ǽ̳���Execution��
		if(pi!=null) {
			System.out.println("��ǰ�����ڣ�"+pi.getActivityId());
		}else {
			System.out.println("�����Ѿ�����");
		}
	}

	@Autowired
	private HistoryService historyService;
	
	@Test
	public void queryHis() throws JsonProcessingException {
		var rst=historyService.createHistoricProcessInstanceQuery()
				.processInstanceId("100001")
				.singleResult();
		System.out.println(objectMapper.writeValueAsString(rst));
	}
	
	@Test
	public void addVariable() throws IOException {
		//var map=Map.of("username","jayChou","reason","����","days","12");

		File f=new File("C:\\Users\\Administrator\\git\\firstSwt\\activiti-learn\\src\\test\\java\\cn\\boz\\activiti\\ActivitiTest.java");
		InputStream is=new FileInputStream(f);
		var str=new String(is.readAllBytes(),"UTF-8");
		taskService.setVariable("82502","file",str);
	}
	
	@Test
	public void localVar() {
		var map=Map.of("days","12");
		taskService.setVariablesLocal("82502",map);
	}
}

