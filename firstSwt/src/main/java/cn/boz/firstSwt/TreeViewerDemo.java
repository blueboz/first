package cn.boz.firstSwt;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.boz.base.BaseAppWindow;
import cn.boz.provider.TreeViewerContentProvider;
import cn.boz.provider.TreeViewerLabelProvider;

public class TreeViewerDemo extends BaseAppWindow {

	private ClassPathXmlApplicationContext appCtx;

	public static void main(String[] args) {
		new TreeViewerDemo().run();
	}

	TreeViewerLabelProvider treeViewerLabelProvider;
	TreeViewerContentProvider treeViewerContentProvider;

	@SuppressWarnings("resource")
	@Override
	public void run() {
		appCtx = new ClassPathXmlApplicationContext("app-ctx.xml");
//		DefaultListableBeanFactory bf=(DefaultListableBeanFactory) appCtx.getBeanFactory();
//		GenericBeanDefinition bd = new GenericBeanDefinition();
		treeViewerLabelProvider = appCtx.getBean(TreeViewerLabelProvider.class);
		treeViewerContentProvider = appCtx.getBean(TreeViewerContentProvider.class);
		super.run();

	}

	private TreeViewer treeViewer;

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.None);
		composite.setLayout(new FillLayout());
		treeViewer = new TreeViewer(composite, SWT.NONE);
		treeViewer.setLabelProvider(treeViewerLabelProvider);
		treeViewer.setContentProvider(treeViewerContentProvider);
		treeViewer.setInput(treeViewerContentProvider.getRoot());
		

		return composite;
	}
}
