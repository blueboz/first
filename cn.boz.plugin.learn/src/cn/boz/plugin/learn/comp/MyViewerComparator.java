package cn.boz.plugin.learn.comp;

import java.util.Comparator;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;

public class MyViewerComparator extends ViewerComparator {
	private TableColumn[] tcs;

	private Comparator<Object>[] comps;
	
	private int index;

	public MyViewerComparator(TableColumn[] tcs, Comparator<Object>[] comps) {
		this.comps = comps;
		this.tcs = tcs;
	}

	public void postProcessTableColumns() {
		if (tcs != null && tcs.length > 0) {
			int i=0;
			for (TableColumn tc : tcs) {
				tc.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						index=i;
					}
				});
			}
		}
	}

	@Override
	public int compare(Viewer viewer, Object o1, Object o2) {
		return this.comps[index].compare(o1, o2);
	}
}
