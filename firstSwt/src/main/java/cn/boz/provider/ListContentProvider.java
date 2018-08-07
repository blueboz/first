package cn.boz.provider;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;

import cn.boz.model.ListModel;

/**
 * ���ͻ��˵���setInput ��ʱ�򣬻����ContentProvider��inputChanged�������������ѣ�input�����Ѿ������ı䣬Ҫ���䰴���µ�InputΪ���ṩ����
 * @author Administrator
 *
 */
public class ListContentProvider implements IStructuredContentProvider,PropertyChangeListener{


	//�����inputChanged ������
	private ListViewer viewer;

	//�����inputChanged ������
	private ListModel model;

	/**
	 * ���ڼ��ģ�͵ı仯
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
