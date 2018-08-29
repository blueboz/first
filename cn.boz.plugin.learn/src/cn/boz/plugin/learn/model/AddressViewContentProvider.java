package cn.boz.plugin.learn.model;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;

public class AddressViewContentProvider implements IStructuredContentProvider,AddressManagerListener{

	private TableViewer viewer;

	private AddressManager manager;

	@Override
	public Object[] getElements(Object inputElement) {
		//从模型中获取数据
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
		if(evt.getItemRemoved()!=null) {
			List<AddressItem> rms = evt.getItemRemoved();
			for (AddressItem addressItem : rms) {
				viewer.remove(addressItem);
			}
		}
		if(evt.getItemAdded()!=null) {
			viewer.add(evt.getItemAdded());
		}
		viewer.getTable().setRedraw(false);
	}

}
