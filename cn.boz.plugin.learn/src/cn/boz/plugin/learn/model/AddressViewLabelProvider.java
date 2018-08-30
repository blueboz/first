package cn.boz.plugin.learn.model;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class AddressViewLabelProvider extends LabelProvider implements ITableLabelProvider {
	// �˴�һ�������
	@Override
	public String getColumnText(Object obj, int index) {
		if (obj != null && obj instanceof AddressItem) {
			AddressItem ai = (AddressItem) obj;
			switch (index) {
			case 0:
				return ai.getName();
			case 1:
				int category = ai.getCategory();
				return AddressItem.CATEGORYS[category];
			case 2:
				return ai.getMessageInfo();
			case 3:
				return ai.getAge();
			}
		}
		return "";
	}

	@Override
	public Image getColumnImage(Object obj, int index) {
		return getImage(obj);
	}

	@Override
	public Image getImage(Object obj) {
		return null;
	}
}