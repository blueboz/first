package cn.boz.plugin.learn.model;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class AddressViewLabelProvider extends LabelProvider implements ITableLabelProvider {
	//此处一并完成吗
	@Override
	public String getColumnText(Object obj, int index) {
		if(obj!=null&&obj instanceof AddressItem) {
			AddressItem ai=(AddressItem) obj;
			switch (index) {
			case 0:
				return ai.getName();
			case 1:
				return ai.getCategory();
			case 2:
				return ai.getMessageInfo();
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