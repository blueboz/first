package cn.boz.plugin.learn.actions;

import java.util.Properties;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.handlers.IWorkbenchWindowHandlerDelegate;
import org.junit.jupiter.api.Test;


public class MyWorkbenchWindowHandlerDelegate implements IWorkbenchWindowHandlerDelegate {

	@Override
	public void dispose() {
		System.out.println("Dipose");
	}

	@Override
	public void init(IWorkbenchWindow window) {
		System.out.println("Init");
	}

	@Override
	public void run(IAction action) {
		System.out.println("Run");
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		System.out.println("SelectionChanged");
	}
	
	@Test
	public void runner() {
		Properties props = System.getProperties();
		props.forEach((k,v)->{
			System.out.println(k+":"+v);
		});
	}

}
