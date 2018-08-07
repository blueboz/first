package cn.boz.provider;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;

import cn.boz.model.ListModel;

/**
 * 当客户端调用setInput 的时候，会调用ContentProvider的inputChanged方法，用于提醒，input内容已经发生改变，要求其按照新的Input为其提供数据
 * @author Administrator
 *
 */
public class ListContentProvider implements IStructuredContentProvider,PropertyChangeListener{


	//这个在inputChanged 会送入
	private ListViewer viewer;

	//这个在inputChanged 会送入
	private ListModel model;

	/**
	 * 用于检测模型的变化
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String evtType = evt.getPropertyName();
		if(ListModel.ADD_ELEMENT.equals(evtType)) {
			viewer.add(evt.getNewValue());
		}else {
			viewer.remove(evt.getNewValue());
		}
	}

	@Override
	public Object[] getElements(Object arg0) {
		return model.getElements();
	}
	
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer=(ListViewer)viewer;

		if(oldInput instanceof ListModel) {
			((ListModel) oldInput).removePropertyChangeListener(this);
		}
		if(newInput instanceof ListModel) {
			this.model=(ListModel) newInput;
			((ListModel)newInput).addPropertyChangeListener(this);
		}
		IStructuredContentProvider.super.inputChanged(viewer, oldInput, newInput);
	}


	
}
