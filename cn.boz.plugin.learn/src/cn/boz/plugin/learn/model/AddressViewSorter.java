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
		// ��ʼ����ʱ��Ӧ�ó�ʼ��һ��infos
		infos = new SortInfo[tcs.length];
		for (int i = 0; i < tcs.length; i++) {
			// ��ʼ����������
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
	 * Ϊÿһ��TableColumn �����˵�����¼�������ÿһ��Column ����һ��Status ������¼���Column ��ѡ��״̬
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
	 * �����ĸ������������
	 * 
	 * @param info
	 */
	protected void sortUsing(SortInfo info) {
		//�����ǰ������Ѿ����������ǰ���ô����
		//�������µ���
		if (info == infos[0])
			info.descending = !info.descending;
		else {
			for (int i = 0; i < infos.length; i++) {
				if (info == infos[i]) {
					// ��Ҫ�ǽ�Column ���е���
					//��Ҫ�ǽ��жԵ�������������
					//��Ҫ�õ���ǰ��������i
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
	 * �����б��˳���������
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
	 * ��ʼ��
	 * ��ȡmemento�б���ļ�¼�������ǰ���˳����м�¼��
	 * �ֱ���columns index,�����������˳����Ϊ
	 * ÿһ�����������в�ͬ�����ȼ���ÿ�α�������������ջ��
	 * ���ұ����Ԫ��λλ��
	 * ����ǰ��Ԫ����󼷼ȿ���
	 * �������ڴ���
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
	 *	����˵ڶ���֮�󣬻ᷢ���������
	 * 	��Ϊ��������tableColumn1��click �¼�����������descending �ᱻ���ó�Ϊtrue
	 *  �����յ����������
	 *
	 *  <?xml version="1.0" encoding="UTF-8"?>
	 *	<view>
	 *		<category columnIndex="1" descending="true"/>
	 *		<category columnIndex="2"/>
	 *		<category columnIndex="3"/>
	 *		<category columnIndex="0"/>
	 *	</view>
	 *
	 *  ��ô���ǳ��Ե��4������index=3�ģ�
	 *	<?xml version="1.0" encoding="UTF-8"?>
	 *	<view>
	 *		<category columnIndex="3"/>
	 *		<category columnIndex="1" descending="true"/>
	 *		<category columnIndex="2"/>
	 *		<category columnIndex="0"/>
	 *	</viewv>
	 *	���Կ������������ᵽ��ǰ���ˣ�ʣ�µ����ѹ ���������Ƿ��ֲ�û��descending
	 *	��Ϊ���ǵ�����ֻ�е�ǰ������ǰ�ģ������ٴα�������Ż���е��������
	 *
	 * 
	 */
	public void init(IMemento memento) {
		List newInfos = new ArrayList(infos.length);
		// û�б�������Ӧ���ǻ�ȡ������
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
	 * ����������Ϣ
	 *
	 */
	private class SortInfo {
		int columnIndex;
		Comparator comparator;
		boolean descending;
	}
}
