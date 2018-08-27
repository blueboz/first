package cn.boz.provider;

import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.TaskManagementConfigUtils;
import org.springframework.stereotype.Component;

import cn.boz.domain.pojo.ActReDeployment;
import cn.boz.domain.pojo.ActReDeploymentExample;
import cn.boz.domain.pojo.ActReProcdef;
import cn.boz.domain.pojo.ActReProcdefExample;
import cn.boz.domain.pojo.ActReProcdefExample.Criteria;
import cn.boz.domain.pojo.ActRuExecution;
import cn.boz.domain.pojo.ActRuExecutionExample;
import cn.boz.domain.pojo.ActRuTaskExample;
import cn.boz.mapper.ActReDeploymentMapper;
import cn.boz.mapper.ActReProcdefMapper;
import cn.boz.mapper.ActRuExecutionMapper;
import cn.boz.mapper.ActRuTaskMapper;

@Component
public class TreeViewerContentProvider extends ArrayContentProvider implements ITreeContentProvider {

	@Autowired
	private ActReDeploymentMapper deploymentMapper;

	@Autowired
	private ActReProcdefMapper procdefMapper;

	@Autowired
	private ActRuExecutionMapper executionMapper;

	@Autowired
	private ActRuTaskMapper taskMapper;

	@Override
	public Object[] getChildren(Object obj) {
		if (obj instanceof ActReDeployment) {
			ActReDeployment de = (ActReDeployment) obj;
			ActReProcdefExample example = new ActReProcdefExample();
			Criteria criteria = example.createCriteria();
			criteria.andDeploymentIdEqualTo(de.getId());
			List<ActReProcdef> rst = procdefMapper.selectByExample(example);
			return rst.toArray();
		} else if (obj instanceof ActReProcdef) {

			ActReProcdef def = (ActReProcdef) obj;
			ActRuExecutionExample exeQa = new ActRuExecutionExample();
			cn.boz.domain.pojo.ActRuExecutionExample.Criteria criteria = exeQa.createCriteria();
			criteria.andProcDefIdEqualTo(def.getId());
			List<ActRuExecution> rst = executionMapper.selectByExample(exeQa);
			return rst.toArray();
		} else if (obj instanceof ActRuExecution) {
			ActRuExecution exe = (ActRuExecution) obj;
			ActRuTaskExample taskQa = new ActRuTaskExample();
			cn.boz.domain.pojo.ActRuTaskExample.Criteria criteria = taskQa.createCriteria();
			criteria.andExecutionIdEqualTo(exe.getId());
			return taskMapper.selectByExample(taskQa).toArray();
		}
		return null;
	}

	@Override
	public Object getParent(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object obj) {
		if (obj instanceof ActReDeployment) {
			ActReDeployment de = (ActReDeployment) obj;
			ActReProcdefExample example = new ActReProcdefExample();
			Criteria criteria = example.createCriteria();
			criteria.andDeploymentIdEqualTo(de.getId());
			long cnt = procdefMapper.countByExample(example);
			if (cnt > 0) {
				return true;
			}
		} else if (obj instanceof ActReProcdef) {
			ActReProcdef def = (ActReProcdef) obj;
			ActRuExecutionExample exeQa = new ActRuExecutionExample();
			cn.boz.domain.pojo.ActRuExecutionExample.Criteria criteria = exeQa.createCriteria();
			criteria.andProcDefIdEqualTo(def.getId());
			long cnt = executionMapper.countByExample(exeQa);
			if (cnt > 0) {
				return true;
			}
		} else if (obj instanceof ActRuExecution) {
			ActRuExecution exe = (ActRuExecution) obj;
			ActRuTaskExample taskQa = new ActRuTaskExample();
			cn.boz.domain.pojo.ActRuTaskExample.Criteria criteria = taskQa.createCriteria();
			criteria.andExecutionIdEqualTo(exe.getId());
			long cnt = taskMapper.countByExample(taskQa);
			if (cnt > 0) {
				return true;
			}
		}

		return false;
	}

	public Object[] getRoot() {
		List<ActReDeployment> rst = deploymentMapper.selectByExample(new ActReDeploymentExample());
		return rst.toArray();
	}

}
