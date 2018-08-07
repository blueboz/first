package cn.boz.firstSwt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class Demo3 {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Demo3 window = new Demo3();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Tree tree = new Tree(shell, SWT.BORDER | SWT.CHECK);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		
		TreeColumn trclmnC = new TreeColumn(tree, SWT.NONE);
		trclmnC.setWidth(100);
		trclmnC.setText("C1");
		
		TreeColumn trclmnNewColumn = new TreeColumn(tree, SWT.NONE);
		trclmnNewColumn.setWidth(100);
		trclmnNewColumn.setText("C2");
		
		TreeItem treeItem = new TreeItem(tree, SWT.NONE);
		treeItem.setText(new String[] {"1", "2"});
		
		TreeItem treeItem_1 = new TreeItem(treeItem, SWT.NONE);
		treeItem_1.setText(new String[] {"2", "2"});
		
		TreeItem treeItem_2 = new TreeItem(treeItem, SWT.NONE);
		treeItem_2.setText(new String[] {"3", "3"});
		treeItem.setExpanded(true);
		
		TreeItem treeItem_3 = new TreeItem(tree, SWT.NONE);
		treeItem_3.setText(new String[] {"1", "2"});
		
		TreeItem treeItem_4 = new TreeItem(treeItem_3, SWT.NONE);
		treeItem_4.setText("3");
		
		TreeItem treeItem_5 = new TreeItem(treeItem_3, SWT.NONE);
		treeItem_5.setText("4");
		treeItem_3.setExpanded(true);

	}
}
