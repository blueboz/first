package cn.boz.plugin.learn.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMemento;

public class AddressViewFilterAction extends Action {

	private final Shell shell;
	private final AddressViewFilter categoryFilter;
	private StructuredViewer viewer;

	public AddressViewFilterAction(StructuredViewer viewer, String text, ImageDescriptor imageDescriptor) {

		super(text, imageDescriptor);
		this.shell = viewer.getControl().getShell();
		this.categoryFilter = new AddressViewFilter(viewer);
	}

	@Override
	public void run() {
		String initVal=categoryFilter.getPattern();
		InputDialog inputDialog = new InputDialog(shell, "类别过滤", "输入一个类别名称"+System.getProperty("line.seperator")+"或者置空", initVal, null);
		int open = inputDialog.open();
		if(open==InputDialog.OK) {
			categoryFilter.setFilter(inputDialog.getValue().trim());
			System.out.println("Filtering"+inputDialog.getValue());
		}

		super.run();
	}
	
	public void init(IMemento memento) {
		categoryFilter.init(memento);
	}

	public void saveState(IMemento memento) {
		categoryFilter.saveState(memento);
	}
}
