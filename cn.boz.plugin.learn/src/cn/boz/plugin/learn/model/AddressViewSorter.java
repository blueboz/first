package cn.boz.plugin.learn.model;

import java.util.Comparator;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.widgets.TableColumn;

public class AddressViewSorter extends ViewerComparator {
	private TableColumn[] tcs;
	private TableViewer tv;
	private Comparator[] cps;
	public AddressViewSorter(TableViewer tv,TableColumn [] tcs,Comparator[] cps) {
		this.tv=tv;
		this.tcs=tcs;
		this.cps=cps;
	}

	@Override
	public boolean isSorterProperty(Object element, String property) {
		return true; 
	}
	@Override
	public int category(Object element) {
		return super.category(element);
	}


	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		return super.compare(viewer, e1, e2);
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
