package cn.boz.plugin.learn.actions;

import java.util.Optional;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class OpenAddressViewAction extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		var command = event.getCommand();
		String id = command.getId();
		String name = null;
		try {
			name=command.getName();
		} catch (NotDefinedException e) {
			e.printStackTrace();
		}
		var sb=new StringBuilder();
		sb.append("Command ID:"+id+"\n");
		sb.append("Command Name:"+Optional.of(name)+"\n");

		MessageDialog.openInformation(
				window.getShell(),
				"×Ô¶¯··Âô»ú",
				sb.toString());
		return null;
	}
	
}
