package cn.boz.model;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import cn.boz.domain.User;
import cn.boz.provider.ListContentProvider;


public class ListModel {
	private ListContentProvider lcp=null;
	private List<Object> content=new ArrayList<Object>();

	public static String ADD_ELEMENT="add";
	public static String REMOVE_ELEMENT="remove";

	public void add(Object element) {
		if(content.add(element)) {
			firePropertyChange(new PropertyChangeEvent(this, ADD_ELEMENT, null, element));
		}
	}
	
	public void remove(Object element) {
		if(content.remove(element)) {
			firePropertyChange(new PropertyChangeEvent(this, REMOVE_ELEMENT, null, element));
		}
	}
	
	private void firePropertyChange(PropertyChangeEvent evt) {
		lcp.propertyChange(evt);
	}

	public Object[] getElements() {
		var list=new ArrayList<Object>();
		IntStream.range(0, 7).forEach(it->{
			User user = new User();
			user.setId(it+"");
			user.setName(Math.random()+"");
			user.setAge(new Random().nextInt(99)+"");
			list.add(user);
		});
		return list.toArray();
	}

	public void removePropertyChangeListener(ListContentProvider listContentProvider) {
		lcp=null;
	}

	public void addPropertyChangeListener(ListContentProvider listContentProvider) {
		lcp=listContentProvider;
	}

}
