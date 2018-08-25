package cn.boz.swtjface.viewer;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.DefaultUndoManager;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import cn.boz.swtjface.base.BaseCode;

public class UndoTextDemo extends BaseCode {
	DefaultUndoManager defaultUndoManager;

	@SuppressWarnings("deprecation")
	@Override
	protected void render() {
		// TODO Auto-generated method stub
		shell.setLayout(new FillLayout());

		Menu menu = new Menu(shell, SWT.BAR);
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.setText("Redo");
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				defaultUndoManager.redo();
				super.widgetSelected(e);
			}
		});
		MenuItem menuItem2 = new MenuItem(menu, SWT.NONE);
		menuItem2.setText("Undo");
		menuItem2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				defaultUndoManager.undo();
				super.widgetSelected(e);
			}
		});
		shell.setMenuBar(menu);

		TextViewer textViewer = new TextViewer(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		Document document = new Document();
		textViewer.setDocument(document);
		defaultUndoManager = new DefaultUndoManager(1000);
		textViewer.setUndoManager(defaultUndoManager);
		defaultUndoManager.connect(textViewer);

	}

	class UndoAction extends Action {
		public UndoAction() {
			super("撤销(&U)键入@Ctrl+Z", Action.AS_PUSH_BUTTON);
			setToolTipText("取消键入");
			try {
				// 载入图像
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL("file:icons/undo.bmp"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			defaultUndoManager.undo();/**
										 * tv.doOperation(ITextOperationTarget.UNDO); 执行目标操作，ITextOperation 接口用来定义文本目标操作
										 */
		}
	}

	class RedoAction extends Action {
		public RedoAction() {
			super("&恢复(&R)键入@Ctrl+R", Action.AS_PUSH_BUTTON);
			setToolTipText("恢复键入");
			try {
				// 载入图像
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL("file:icons/redo.bmp"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			// tv.doOperation(ITextOperationTarget.REDO);
			defaultUndoManager.redo();
		}
	}

	public static void main(String[] args) {
		new UndoTextDemo().start();
	}
}
