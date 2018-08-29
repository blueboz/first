package cn.boz.firstSwt;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import cn.boz.base.BaseAppWindow;
import cn.boz.provider.DbaUserListContentProvider;
import cn.boz.provider.DbaUserListLabelProvider;
import cn.boz.provider.DbaUserPrivsTreeConentProvider;
import cn.boz.provider.DbaUserPrivsTreeLabelProvider;
import cn.boz.utils.ImageStore;

@Component
public class DbaRoleManager extends BaseAppWindow implements InitializingBean {

	@Autowired
	private DbaUserListContentProvider listContentProvider;

	@Autowired
	private DbaUserListLabelProvider listLabelProvider;

	@Autowired
	private DbaUserPrivsTreeConentProvider treeConentProvider;

	@Autowired
	private DbaUserPrivsTreeLabelProvider treeLabelProvider;

	private TreeViewer treeViewer;
	
	@Lazy
	@Autowired
	private ImageStore imageStore;

	public DbaRoleManager() {
		super(.7f, .7f);
	}
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setImage(imageStore.getImage(ImageStore.ORACLE));
		shell.setText("Oracle授权情况预览");
	}

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("app-ctx.xml");
	}

	private DbaUserListContentProvider dbaUser;

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.None);
		composite.setLayout(new FillLayout());
		SashForm sashForm = new SashForm(composite, SWT.HORIZONTAL);
//		ListViewer listViewer = new ListViewer(sashForm, SWT.V_SCROLL);
//		listViewer.setContentProvider(listContentProvider);
//		listViewer.setLabelProvider(listLabelProvider);
//		listViewer.setInput(listContentProvider.getElements());
		TableViewer tableViewer = new TableViewer(sashForm, SWT.V_SCROLL);
		Table table = tableViewer.getTable();
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] tis = table.getSelection();
				if (tis.length == 1) {
					TableItem ti = tis[0];
					String text = ti.getText();
					Object[] roots = treeConentProvider.getRoots(text);
					treeViewer.setInput(roots);
					//treeViewer.refresh();
				}
				super.widgetSelected(e);
			}
		});
		TableColumn tableColumn = new TableColumn(table, SWT.None);
		tableColumn.setWidth(200);
		tableColumn.setText("用户名");
		tableColumn.setAlignment(SWT.CENTER);
		table.setHeaderVisible(true);
		tableViewer.setContentProvider(listContentProvider);
		tableViewer.setLabelProvider(listLabelProvider);
		tableViewer.setInput(listContentProvider.getElements());
		treeViewer = new TreeViewer(sashForm, SWT.NONE);
		treeViewer.setContentProvider(treeConentProvider);
		treeViewer.setLabelProvider(treeLabelProvider);
		//treeViewer.setInput(new Object[] {});
		sashForm.setWeights(new int[] { 1, 3 });

		return composite;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.run();
	}

}
