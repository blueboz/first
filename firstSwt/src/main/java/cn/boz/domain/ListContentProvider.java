package cn.boz.domain;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;

public class ListContentProvider implements IStructuredContentProvider,PropertyChangeListener{

	private ListViewer viewer;

	private ListModel model;
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
