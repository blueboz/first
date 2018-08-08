package cn.boz.provider;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.IntStream;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import cn.boz.domain.User;
import cn.boz.model.UserStructure;

public class TreeContentProvider implements ITreeContentProvider,PropertyChangeListener{

	private TreeViewer treeViewer; 
	
	private UserStructure userStructure;
	
	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

	public void setTreeViewer(TreeViewer treeViewer) {
		this.treeViewer = treeViewer;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof UserStructure) {
			User president = ((UserStructure) inputElement).getPresident();
			return new Object [] {president};
		}
		return new Object[0] ;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		//最好的方法是直接查询
		return ((User)parentElement).getUnderling().toArray();
	}

	@Override
	public Object getParent(Object element) {
		return ((User)element).getManager();
	}

	@Override
	public boolean hasChildren(Object element) {
		Vector underling = ((User)element).getUnderling();
		return !(underling==null||underling.size()==0);

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.treeViewer=(TreeViewer)viewer;
		if(oldInput instanceof UserStructure) {
			((UserStructure)oldInput).removePropertyChangeListener(this);
		}
		if(newInput instanceof UserStructure) {
			((UserStructure) newInput).addPropertyChangeListener(this);
		}
		ITreeContentProvider.super.inputChanged(viewer, oldInput, newInput);
	}

	/**
	 * 属性发生改变，与其说是属性还不如说是state
	 * statechange
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals(UserStructure.ADD_USER)) {
			Object[] vals = (Object[]) evt.getNewValue();
			treeViewer.add(vals[0], vals[1]);
			treeViewer.refresh();
		}else {
			treeViewer.remove(evt.getNewValue());
		}
		
		
	}
}
