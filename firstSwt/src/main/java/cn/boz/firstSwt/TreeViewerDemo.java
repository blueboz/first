package cn.boz.firstSwt;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import cn.boz.base.BaseAppWindow;

public class TreeViewerDemo extends BaseAppWindow{

	public static void main(String[] args) {
		new TreeViewerDemo().run();
	}

	private TreeViewer treeViewer;

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.None);
		composite.setLayout(new FillLayout());
		treeViewer = new TreeViewer(composite,SWT.NONE);
		return composite;
	}
}
