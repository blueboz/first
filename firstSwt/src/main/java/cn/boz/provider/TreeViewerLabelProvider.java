package cn.boz.provider;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.springframework.stereotype.Component;

import cn.boz.domain.pojo.ActReDeployment;
import cn.boz.domain.pojo.ActReProcdef;
import cn.boz.domain.pojo.ActRuExecution;
import cn.boz.domain.pojo.ActRuTask;

//@Component
public class TreeViewerLabelProvider implements ILabelProvider {

	@Override
	public void addListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImage(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText(Object obj) {
		if(obj instanceof ActReDeployment) {
			ActReDeployment de=(ActReDeployment) obj;
			return de.getId()+":"+de.getName()+":"+de.getCategory();
		}else if(obj instanceof ActReProcdef) {
			ActReProcdef pd=(ActReProcdef) obj;
			return pd.getId()+"==>"+pd.getName();
		}else if(obj instanceof ActRuExecution) {
			ActRuExecution exe=(ActRuExecution) obj;
			return exe.getId()+"==>"+exe.getActId();
		}else if(obj instanceof ActRuTask) {
			ActRuTask tsk=(ActRuTask) obj;
			return tsk.getName();
		}
		// TODO Auto-generated method stub
		return "未命名";
	}

}
