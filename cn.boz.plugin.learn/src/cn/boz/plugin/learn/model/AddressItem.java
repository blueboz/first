package cn.boz.plugin.learn.model;

import cn.boz.plugin.learn.base.BaseModel;

public class AddressItem extends BaseModel{
	
	private String category;
	private String messageInfo;
	private String name;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMessageInfo() {
		return messageInfo;
	}
	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
