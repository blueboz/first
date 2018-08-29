package cn.boz.provider;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import cn.boz.domain.ora.pojo.DbaRolePrivs;
import cn.boz.domain.ora.pojo.DbaSysPrivs;
import cn.boz.domain.ora.pojo.RoleRolePrivs;
import cn.boz.domain.ora.pojo.RoleSysPrivs;
import cn.boz.utils.ImageStore;

@Component
public class DbaUserPrivsTreeLabelProvider implements ILabelProvider {

	@Lazy
	@Autowired
	private ImageStore imageStore;

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
	public void addListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof DbaRolePrivs) {
			return imageStore.getImage(ImageStore.ROLE);
		}else if(element instanceof DbaSysPrivs) {
			return imageStore.getImage(ImageStore.RIGHT);
		}else if(element instanceof RoleSysPrivs) {
			return imageStore.getImage(ImageStore.RIGHT);
		}else if(element instanceof RoleRolePrivs) {
			return imageStore.getImage(ImageStore.ROLE);
		}
		return imageStore.getImage(ImageStore.USER);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof DbaRolePrivs) {
			return ((DbaRolePrivs) element).getGrantedRole();
		}else if (element instanceof DbaSysPrivs) {
			return ((DbaSysPrivs) element).getPrivilege();
		}else if (element instanceof RoleSysPrivs) {
			return ((RoleSysPrivs) element).getPrivilege();
		}else if (element instanceof RoleRolePrivs) {
			return ((RoleRolePrivs) element).getGrantedRole();
		}
		return element.getClass().getSimpleName();

	}
}
