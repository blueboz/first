package cn.boz.plugin.learn.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

public class AddressManager implements IPropertyChangeListener {

	private List<AddressItem> addresses = new ArrayList<AddressItem>();
	private List<AddressViewContentProvider> listeners = new ArrayList<AddressViewContentProvider>();
	private static AddressManager manager;

	private AddressManager() {
		Random random = new Random();
		IntStream.range(0, 20).forEach(i -> {
			AddressItem ai = new AddressItem();
			ai.setName("周杰伦" + i);
			ai.setCategory(random.nextInt(AddressItem.CATEGORYS.length));
			ai.setAge(random.nextInt(100) + "岁");
			ai.setMessageInfo(i + "From the world that is far away");
			addresses.add(ai);
		});
	}

	public void setAddresses(List<AddressItem> addresses) {
		this.addresses = addresses;
	}

	public void fireAddressChanged(AddressManagerEvent evt) {
		listeners.forEach(it -> {
			it.addressesChanged(evt);
		});
		return;
	}

	public void removeAddressManagerListener() {

	}

	public void removeAddresses() {

	}

	// 可以采用单例的模式进行开发
	public static AddressManager getManager() {
		if (manager == null) {
			manager = new AddressManager();
		}
		return manager;
	}

	public void addAddressManagerListener(AddressViewContentProvider listener) {
		listeners.add(listener);
	}

	public List<AddressItem> loadAddressses() {
		return addresses;

	}

	public List<AddressItem> getAddresses() {
		return addresses;
	}

	public void removeAddresses(AddressItem[] selectedAddress) {
		AddressManagerEvent evt = new AddressManagerEvent();
		evt.setItemRemoved(Arrays.asList(selectedAddress));
		fireAddressChanged(evt);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		fireAddressItemChanged(event);
	}

	private void fireAddressItemChanged(PropertyChangeEvent event) {

		listeners.forEach(it -> {
			it.addressItemChange(event);
		});
	}

}
