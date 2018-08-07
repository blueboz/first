package cn.boz.model;

import java.beans.PropertyChangeEvent;
import java.util.Optional;
import java.util.Vector;

import cn.boz.domain.User;
import cn.boz.provider.TreeContentProvider;

public class UserStructure {
	
	private TreeContentProvider tcp;

	public static final String ADD_USER = "add_user";
	public static final String REMOVE_USER = "remove_user";
	private User president;
	

	public User getPresident() {
		return president;
	}

	public void setPresident(User president) {
		this.president = president;
	}

	private Object oldValue;

	/**
	 * ģ�����ṩ�������������Ϊ��ģ�������Ԫ�� ��ģ��һ����Ҫ����Ԫ�أ���ôģ��
	 * @param parentPath
	 * @param newuser
	 */
	public void add(int[] parentPath, User newuser) {
		User parent = findUser(parentPath);
		if (parent != null && !parent.getUnderling().contains(newuser)) {
			if (parent.getUnderling().add(newuser)) {
				//ͨ���ô������������и���
				firePropertyChange(new PropertyChangeEvent(this, ADD_USER, null, new Object[] { parentPath, newuser }));
			}
		}
	}
	
	public void remove(int []path) {
		User findUser = findUser(path);
		//���ɾ����һ��user,������Ҫ���丸��ɾ�����Լ�	
		if(findUser!=null&&findUser.getManager().getUnderling().remove(findUser)) {
			firePropertyChange(new PropertyChangeEvent(this, REMOVE_USER, null, findUser));
		}
	}

	private void firePropertyChange(PropertyChangeEvent propertyChangeEvent) {
		tcp.propertyChange(propertyChangeEvent);
	}

	private User findUser(int[] parentPath) {
		// TODO Auto-generated method stub
		Vector underling = president.getUnderling();
		Vector temp=underling;
		Object rst=president;
		for(int i:parentPath) {
			Object object = temp.get(i);
			rst=object;
			if(object!=null&&object instanceof User) {
				temp=((User)object).getUnderling();
			}else {
				return null;
			}
		}
		return (User) rst;
	}

	public void addPropertyChangeListener(TreeContentProvider treeContentProvider) {
		this.tcp=treeContentProvider;
	}

	public void removePropertyChangeListener(TreeContentProvider treeContentProvider) {
		this.tcp=null;
	}
}
