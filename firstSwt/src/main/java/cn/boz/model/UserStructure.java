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
	 * 模型中提供方法，可以理解为向模型中添加元素 ，模型一旦需要操作元素，那么模型
	 * @param parentPath
	 * @param newuser
	 */
	public void add(int[] parentPath, User newuser) {
		User parent = findUser(parentPath);
		if (parent != null && !parent.getUnderling().contains(newuser)) {
			if (parent.getUnderling().add(newuser)) {
				//通过该触发监听器进行更新
				firePropertyChange(new PropertyChangeEvent(this, ADD_USER, null, new Object[] { parentPath, newuser }));
			}
		}
	}
	
	public void remove(int []path) {
		User findUser = findUser(path);
		//如何删除掉一个user,首先需要在其父中删除掉自己	
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
