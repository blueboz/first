package cn.boz.swtjface.provider;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import cn.boz.swtjface.domain.People;

public class PeopleLabelProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		People people = (People) element;
		switch (columnIndex) {
		case 0:// 第一列
			return people.getID().toString();
		case 1:// 第二列
			return people.getName();
		case 2:// 第三列
			return people.isMale() ? "男" : "女";
		case 3:// 第四列
			return people.getAge().toString();
		case 4:// 第五列
			return people.getPosition();
		// return Salary.INSTANCES[people.getSalary().intValue()];
		case 5:// 第六列
			return people.getColor().toString();
		}
		return null;
	}

}
