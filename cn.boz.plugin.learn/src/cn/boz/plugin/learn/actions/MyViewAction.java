package cn.boz.plugin.learn.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;

public class MyViewAction implements IViewActionDelegate {

	private IViewPart view;

	public MyViewAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(IAction action) {

		MessageDialog.openInformation(view.getSite().getShell(), "视图操作按钮", "视图操作消息");
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IViewPart view) {
		this.view=view;
	}

}
