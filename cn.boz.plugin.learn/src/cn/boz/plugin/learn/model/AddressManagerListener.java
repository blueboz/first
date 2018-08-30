package cn.boz.plugin.learn.model;

import org.eclipse.jface.util.PropertyChangeEvent;

public interface AddressManagerListener {

	public void addressesChanged(AddressManagerEvent evt);

	void addressItemChange(PropertyChangeEvent event);
	

}

