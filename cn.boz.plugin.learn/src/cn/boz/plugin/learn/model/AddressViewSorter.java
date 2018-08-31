package cn.boz.plugin.learn.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IMemento;

public class AddressViewSorter extends ViewerComparator {

	private static final String TAG_DESENDING = "descending";
	private static final String TAG_INDEX = "columnIndex";
	private static final String TAG_CATEGORY = "category";
	private static final String TAG_TRUE = "true";
	private TableColumn[] tcs;
	private TableViewer tv;
	private Comparator[] cps;
	private int index = 1;
	private Boolean flag = false;

	public AddressViewSorter(TableViewer tv, TableColumn[] tcs, Comparator[] cps) {
		// 初始化的时候，应该初始化一套infos
		infos = new SortInfo[tcs.length];
		for (int i = 0; i < tcs.length; i++) {
			// 初始化都是正序
			infos[i] = new SortInfo();
			infos[i].columnIndex = i;
			infos[i].comparator = cps[i];
			infos[i].descending = false;
			createSelectionListener(tcs[i], infos[i]);
		}
		this.tv = tv;
		this.tcs = tcs;
		this.cps = cps;
		// postProcessTableColumns();
	}

	/**
	 * 为每一个TableColumn 新增了点击绑定事件，并且每一个Column 含有一个Status 用来记录这个Column 的选中状态
	 * 
	 * @param tableColumn
	 * @param sortInfo
	 */
	private void createSelectionListener(TableColumn tableColumn, SortInfo sortInfo) {
		tableColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sortUsing(sortInfo);
			}
		});
	}

	/**
	 * 按照哪个对象进行排序？
	 * 
	 * @param info
	 */
	protected void sortUsing(SortInfo info) {
		//如果当前被点击已经是排序的最前项，那么倒叙
		//否则，重新调度
		if (info == infos[0])
			info.descending = !info.descending;
		else {
			for (int i = 0; i < infos.length; i++) {
				if (info == infos[i]) {
					// 主要是将Column 进行地推
					//主要是进行对调而不是往后推
					//需要拿到最前的坐标是i
					// 0 1  2  3  4  6
					for(int j=i;j-1>=0;j--) {
						infos[j]=infos[j-1];
					}
					//System.arraycopy(infos, 0, infos, 1, i);
					infos[0] = info;
					info.descending = false;
					break;
				}
			}
		}
		tv.refresh();
	}

	@Override
	public boolean isSorterProperty(Object element, String property) {
		return true;
	}

	@Override
	public int category(Object element) {
		return super.category(element);
	}

	/**
	 * 按照列表的顺序进行排列
	 */
	@Override
	public int compare(Viewer viewer, Object o1, Object o2) {
		for (int i = 0; i < infos.length; i++) {
			int result = infos[i].comparator.compare(o1, o2);
			if (result != 0) {
				if (infos[i].descending)
					return -result;
				return result;
			}
		}
		return 0;
	}

	@Override
	protected Comparator<? super String> getComparator() {
		return super.getComparator();
	}

	@Override
	public void sort(Viewer viewer, Object[] elements) {
		super.sort(viewer, elements);
	}

	private SortInfo[] infos;

	public void saveState(IMemento memento) {
		for (int i = 0; i < infos.length; i++) {
			SortInfo info = infos[i];
			IMemento mem = memento.createChild(TAG_CATEGORY);
			mem.putInteger(TAG_INDEX, info.columnIndex);
			if (info.descending)
				mem.putString(TAG_DESENDING, TAG_TRUE);
		}
	}

	/**
	 * 初始化
	 * 获取memento中保存的记录，他们是按照顺序进行记录的
	 * 分别是columns index,即排序的优先顺序，因为
	 * 每一个排序器都有不同的优先级，每次被点击的项都会置于栈顶
	 * 并且被提的元素位位空
	 * 所以前面元素完后挤既可以
	 * 这样在内存中
	 * 1 	2 	3 	4
	 * c3	c4	c1	c2
	 *  <?xml version="1.0" encoding="UTF-8"?>
	 *	<view>
	 *		<category columnIndex="1"/>
	 *		<category columnIndex="2"/>
	 *		<category columnIndex="3"/>
	 *		<category columnIndex="0"/>
	 *	</view>
	 *
	 *	点击了第二栏之后，会发生如下情况
	 * 	因为触发的是tableColumn1的click 事件，所以他的descending 会被设置成为true
	 *  即按照倒叙进行排列
	 *
	 *  <?xml version="1.0" encoding="UTF-8"?>
	 *	<view>
	 *		<category columnIndex="1" descending="true"/>
	 *		<category columnIndex="2"/>
	 *		<category columnIndex="3"/>
	 *		<category columnIndex="0"/>
	 *	</view>
	 *
	 *  那么我们尝试点击4栏，即index=3的，
	 *	<?xml version="1.0" encoding="UTF-8"?>
	 *	<view>
	 *		<category columnIndex="3"/>
	 *		<category columnIndex="1" descending="true"/>
	 *		<category columnIndex="2"/>
	 *		<category columnIndex="0"/>
	 *	</viewv>
	 *	可以看到第三栏被提到最前面了，剩下的完后挤压 ，但是我们发现并没有descending
	 *	因为我们的设置只有当前栏是最前的，而且再次被点击，才会进行倒叙排序的
	 *
	 * 
	 */
	public void init(IMemento memento) {
		List newInfos = new ArrayList(infos.length);
		// 没有保存这里应该是获取不到的
		IMemento[] mems = memento.getChildren(TAG_CATEGORY);
		for (int i = 0; i < mems.length; i++) {
			IMemento mem = mems[i];
			Integer value = mem.getInteger(TAG_INDEX);
			if (value == null)
				continue;
			int index = value.intValue();
			if (index < 0 || index >= infos.length)
				continue;
			SortInfo info = infos[index];
			if (newInfos.contains(info))
				continue;
			info.descending = TAG_TRUE.equals(mem.getString(TAG_DESENDING));
			newInfos.add(info);
		}
		for (int i = 0; i < infos.length; i++)
			if (!newInfos.contains(infos[i]))
				newInfos.add(infos[i]);
		infos = (SortInfo[]) newInfos.toArray(new SortInfo[newInfos.size()]);
	}

	/**
	 * 保存排序信息
	 *
	 */
	private class SortInfo {
		int columnIndex;
		Comparator comparator;
		boolean descending;
	}
}
