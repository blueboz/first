package cn.boz.plugin.learn.model;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.views.properties.IPropertySource;

import cn.boz.plugin.learn.base.BaseModel;

public class AddressItem extends BaseModel implements IAdaptable {

	public static String[] COLUMNS = { "NAME", "AGE", "MESSAGEINFO", "CATEGORY" };
	public static String[] CATEGORYS = { "普通", "商业", "VIP", "朋友", "师长", "家庭" };
	public static String NAME_ = COLUMNS[0];
	public static String AGE_ = COLUMNS[1];
	public static String CATEGORY_ = COLUMNS[2];
	public static String MESSAGEINFO_ = COLUMNS[3];
	private String age;
	private String messageInfo;
	private String name;
	private int category;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	@Override
	public Object getAdapter(Class adapter) {
		// 点击AddressItem 的时候，会触发这个方法，需要返回一个PropertySoruce
		if (adapter == IPropertySource.class) {
			return new AddressItemPropertySource(this);
		}
		return null;
	}

}
