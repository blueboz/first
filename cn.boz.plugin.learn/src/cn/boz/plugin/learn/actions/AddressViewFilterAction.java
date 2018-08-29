package cn.boz.plugin.learn.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPartSite;

public class AddressViewFilterAction implements IViewActionDelegate{
	
	private IViewPart view;

	@Override
	public void run(IAction action) {
		IWorkbenchPartSite site = view.getSite();
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
