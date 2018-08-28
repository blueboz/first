package cn.boz.firstSwt;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import cn.boz.base.BaseAppWindow;
import cn.boz.provider.DbaUserListContentProvider;
import cn.boz.provider.DbaUserListLabelProvider;

@Component
public class DbaRoleManager extends BaseAppWindow implements InitializingBean {

	@Autowired
	private DbaUserListContentProvider listContentProvider;

	@Autowired
	private DbaUserListLabelProvider listLabelProvider;

	public DbaRoleManager() {
		super(.7f, .7f);
	}

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("app-ctx.xml");
	}

	private DbaUserListContentProvider dbaUser;

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.None);
		composite.setLayout(new FillLayout());
		SashForm sashForm = new SashForm(composite, SWT.V_SCROLL);
//		ListViewer listViewer = new ListViewer(sashForm, SWT.V_SCROLL);
//		listViewer.setContentProvider(listContentProvider);
//		listViewer.setLabelProvider(listLabelProvider);
//		listViewer.setInput(listContentProvider.getElements());
		TableViewer tableViewer = new TableViewer(sashForm,SWT.V_SCROLL);
		Table table = tableViewer.getTable();
		TableColumn tableColumn = new TableColumn(table, SWT.LEFT);
		tableColumn.setWidth(100);
		tableColumn.setText("用户名");
		table.setHeaderVisible(true);
		tableViewer.setContentProvider(listContentProvider);
		tableViewer.setLabelProvider(listLabelProvider);
		tableViewer.setInput(listContentProvider.getElements());
		
		return composite;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.run();
	}

}
