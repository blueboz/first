package cn.boz.plugin.learn.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Shell;

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
		InputDialog inputDialog = new InputDialog(shell, "������", "����һ���������"+System.getProperty("line.seperator")+"�����ÿ�", initVal, null);
		int open = inputDialog.open();
		if(open==InputDialog.OK) {
			categoryFilter.setFilter(inputDialog.getValue().trim());
			System.out.println("Filtering"+inputDialog.getValue());
		}

		super.run();
	}
}
