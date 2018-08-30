package cn.boz.plugin.learn.model;

import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

public class AddressItemPropertySource implements IPropertySource {

	private AddressItem addressItem;
	protected static final String PROP_CAT = "cat";
	protected static final String PROP_MSG = "msg";
	protected static final String PROP_NAME = "name";
	protected static final String PROP_AGE = "age";
	private int category;
	private String name;
	private String messageInfo;
	private String age;

	public AddressItemPropertySource(AddressItem addressItem) {
		this.addressItem = addressItem;
		this.category = addressItem.getCategory();
		this.name = addressItem.getName();
		this.messageInfo = addressItem.getMessageInfo();
		this.age = addressItem.getAge();
	}

	@Override
	public Object getEditableValue() {
		return "";
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		ComboBoxPropertyDescriptor d1 = new ComboBoxPropertyDescriptor(PROP_CAT, "类别", AddressItem.CATEGORYS);
		d1.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Integer) {
					int index = (int) element;
					return AddressItem.CATEGORYS[index];
				}
				return super.getText(element);
			}
		});

		TextPropertyDescriptor d2 = new TextPropertyDescriptor(PROP_NAME, "姓名");
		d2.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return super.getText(element);
			}
		});

		TextPropertyDescriptor d3 = new TextPropertyDescriptor(PROP_MSG, "地址");
		d3.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return super.getText(element);
			}
		});

		TextPropertyDescriptor d4 = new TextPropertyDescriptor(PROP_AGE, "年龄");
		d4.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return super.getText(element);
			}
		});

		IPropertyDescriptor pds[] = new IPropertyDescriptor[] { d1, d2, d3, d4 };
		return pds;
	}

	@Override
	public Object getPropertyValue(Object id) {
		if (id.equals(PROP_CAT)) {
			return category;
		} else if (id.equals(PROP_NAME)) {
			return name;
		} else if (id.equals(PROP_MSG)) {
			return messageInfo;
		} else if (id.equals(PROP_AGE)) {
			return age;
		}
		return null;
	}

	@Override
	public boolean isPropertySet(Object id) {
		return true;
	}

	@Override
	public void resetPropertyValue(Object id) {
	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		hookPropertyChanged(value, id);
		if (id.equals(PROP_CAT)) {
			this.category = (int) value;
		} else if (id.equals(PROP_NAME)) {
			this.name = (String) value;
		} else if (id.equals(PROP_MSG)) {
			this.messageInfo = (String) value;
		} else if (id.equals(PROP_AGE)) {
			this.age = (String) value;
		}

	}

	private void hookPropertyChanged(Object value, Object id) {
		PropertyChangeEvent propertyChangeEvent = null;
		if (id.equals(PROP_CAT)) {
			addressItem.setCategory((int) value);
			propertyChangeEvent = new PropertyChangeEvent(addressItem, AddressItem.CATEGORY_, category, value);
		} else if (id.equals(PROP_NAME)) {
			addressItem.setName((String) value);
			propertyChangeEvent = new PropertyChangeEvent(addressItem, AddressItem.NAME_, this.name, value);
		} else if (id.equals(PROP_MSG)) {
			addressItem.setMessageInfo((String) value);
			propertyChangeEvent = new PropertyChangeEvent(addressItem, AddressItem.MESSAGEINFO_, this.messageInfo,
					value);
		} else if (id.equals(PROP_AGE)) {
			addressItem.setAge((String) value);
			propertyChangeEvent = new PropertyChangeEvent(addressItem, AddressItem.AGE_, this.age, value);
		}
		AddressManager.getManager().propertyChange(propertyChangeEvent);
	}

}
