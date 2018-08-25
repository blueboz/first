package cn.boz.swtjface.modifier;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.TableItem;

import cn.boz.swtjface.domain.People;
import cn.boz.swtjface.viewer.TableViewerDemo;

public class TableViewerCellModifier implements ICellModifier {

	private Viewer viewer;
	
	//保存的Viewer用于刷新
	public TableViewerCellModifier(Viewer viewer) {
		// TODO Auto-generated constructor stub
		this.viewer=viewer;
	}

	/**
	 * 能否进行修改、。
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	@Override
	public boolean canModify(Object arg0, String arg1) {
		return true;
	}

	/**
	 * 点击之后，会根据这个方法返回值填入文本框
	 * @param element 选中行的对象
	 * @param property 选中行的属性，columnProperties相结合
	 * @return
	 */
	@Override
	public Object getValue(Object element, String property) {
		People p=(People)element;
		switch (property) {
		case TableViewerDemo.ID:
			break;
		case TableViewerDemo.AGE:
			return Integer.valueOf(0);
		case TableViewerDemo.COLOR:
			return p.getColor();
		case TableViewerDemo.MALE:
			return p.isMale();
		case TableViewerDemo.NAME:
			return p.getName();
			//一旦有editor 必须保证不能null
			//return p.getName()+"Jj";
		case TableViewerDemo.POSITION:
			return p.getPosition();
		default:
			break;
		}
		return null;
	}

	/**
	 * 这个是作用在修改之后的返回值设置，同步到tableView中
	 * @param element tableItem
	 * @param property 属性
	 * @param value 最终值
	 */
	@Override
	public void modify(Object element, String property, Object value) {
		TableItem tableItem=(TableItem) element;
		Object data = tableItem.getData();
		People p=(People) data;
		switch (property) {
		case TableViewerDemo.ID:
			break;
		case TableViewerDemo.AGE:
			p.setAge((int)value);
			break;
		case TableViewerDemo.COLOR:
			p.setColor((RGB)value);
			break;
		case TableViewerDemo.MALE:
			p.setMale((boolean)value);
			break;
		case TableViewerDemo.NAME:
			p.setName((String)value);
			break;
		case TableViewerDemo.POSITION:
			p.setPosition((String)value);
			break;
		default:
			break;
		}
		
		viewer.refresh();

	}

}
