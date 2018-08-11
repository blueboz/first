package cn.boz.plugin.learn.actions;

import java.util.Optional;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.handlers.IWorkbenchWindowHandlerDelegate;

public class OpenViewHandlerDelegate implements IWorkbenchWindowHandlerDelegate {
	private IWorkbenchWindow window;

	@Override
	public void dispose() {

		this.window=null;
	}

	@Override
	public void init(IWorkbenchWindow window) {
		this.window = window;
		
	}

	@Override
	public void run(IAction action) {
		Optional.ofNullable(window).ifPresent(it->{
			var page = it.getActivePage();
			try {
				page.showView("cn.boz.plugin.learn.views.AddressView");
			} catch (PartInitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}


	@Override
	public void selectionChanged(IAction action, ISelection selection) {

	}

}
