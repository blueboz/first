package cn.boz.plugin.learn.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class AddressManager {

	private List<AddressItem> addresses=new ArrayList<AddressItem>();
	private List<AddressViewContentProvider> listeners=new ArrayList<AddressViewContentProvider>();
	private static AddressManager manager;
	
	private AddressManager() {
		IntStream.range(0, 5).forEach(i->{
			AddressItem ai = new AddressItem();
			ai.setName("JayChou"+i);
			ai.setCategory("nop"+i);
			ai.setMessageInfo(i+"From the world that is far away");
			addresses.add(ai);
		});
	}
	
	public void setAddresses(List<AddressItem> addresses) {
		this.addresses = addresses;
	}
	
	public void fireAddressChanged(AddressManagerEvent evt) {
		listeners.forEach(it->{
			it.addressesChanged(evt);
		});
		return ;
	}
	
	public void removeAddressManagerListener(){
		
	}
	
	public void removeAddresses() {
		
	}
	
	public static AddressManager getManager() {
		if(manager==null) {
			manager=new AddressManager();
		}
		return manager;
	}

	public void addAddressManagerListener(AddressViewContentProvider listener) {
		listeners.add(listener);
	}
	
	public List<AddressItem> loadAddressses(){
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
}
