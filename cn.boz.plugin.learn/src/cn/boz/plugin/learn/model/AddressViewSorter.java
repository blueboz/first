package cn.boz.plugin.learn.model;

import java.util.Comparator;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;

public class AddressViewSorter extends ViewerComparator {
	private TableColumn[] tcs;
	private TableViewer tv;
	private Comparator[] cps;
	private int index = 1;
	private Boolean flag = false;

	public AddressViewSorter(TableViewer tv, TableColumn[] tcs, Comparator[] cps) {

		this.tv = tv;
		this.tcs = tcs;
		this.cps = cps;
		postProcessTableColumns();
	}

	@Override
	public boolean isSorterProperty(Object element, String property) {
		return true;
	}

	@Override
	public int category(Object element) {
		return super.category(element);
	}

	public void postProcessTableColumns() {

		for (int i = 0; i < tcs.length; i++) {
			int j = i;
			TableColumn tc = tcs[i];
			tc.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					System.out.println(j);
					flag = !flag;
					index = j;
					tv.refresh();
				}
			});
		}
	}

	@Override
	public int compare(Viewer viewer, Object o1, Object o2) {
		int rst = this.cps[index].compare(o1, o2);
		if (!flag)
			return -rst;
		return rst;
	}

	@Override
	protected Comparator<? super String> getComparator() {
		return super.getComparator();
	}

	@Override
	public void sort(Viewer viewer, Object[] elements) {
		super.sort(viewer, elements);
	}

}
