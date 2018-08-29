package cn.boz.provider;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import cn.boz.domain.ora.pojo.DbaRolePrivs;
import cn.boz.domain.ora.pojo.DbaUsers;
import cn.boz.utils.ImageStore;

@Component
public class DbaUserListLabelProvider implements ITableLabelProvider {

	@Lazy
	@Autowired
	private ImageStore imageStore;

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return imageStore.getImage(ImageStore.USER);
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof DbaUsers) {
			return ((DbaUsers) element).getUsername();
		}else if(element instanceof DbaRolePrivs) {
			return ((DbaRolePrivs) element).getGrantedRole();
		}
		return "";
	}
}
