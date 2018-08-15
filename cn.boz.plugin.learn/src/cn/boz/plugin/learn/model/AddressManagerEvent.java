package cn.boz.plugin.learn.model;

import java.util.List;

public class AddressManagerEvent {
	
	private List<AddressItem> itemRemoved;
	private List<AddressItem> itemAdded;
	public List<AddressItem> getItemRemoved() {
		return itemRemoved;
	}
	public void setItemRemoved(List<AddressItem> itemRemoved) {
		this.itemRemoved = itemRemoved;
	}
	public List<AddressItem> getItemAdded() {
		return itemAdded;
	}
	public void setItemAdded(List<AddressItem> itemAdded) {
		this.itemAdded = itemAdded;
	}
	
}
