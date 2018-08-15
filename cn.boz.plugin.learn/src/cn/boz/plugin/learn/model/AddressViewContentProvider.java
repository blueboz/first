package cn.boz.plugin.learn.model;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;

public class AddressViewContentProvider implements IStructuredContentProvider,AddressManagerListener{

	private TableViewer viewer;

	private AddressManager manager;
	@Override
	public void addressesChanged() {
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return manager.loadAddressses().toArray();
	}
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer=(TableViewer) viewer;
		if(manager!=null) {
			manager.removeAddressManagerListener();
		}
		manager=(AddressManager) newInput;
		if(manager!=null) {
			manager.addAddressManagerListener(this);
		}
		IStructuredContentProvider.super.inputChanged(viewer, oldInput, newInput);
	}

	@Override
	public void addressesChanged(AddressManagerEvent evt) {
		viewer.getTable().setRedraw(true);
		viewer.remove(evt.getItemRemoved());
		viewer.add(evt.getItemAdded());
		viewer.getTable().setRedraw(false);
		
	}

}
