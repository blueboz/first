package cn.boz.swtjface.viewer;

import java.io.IOException;
import java.util.logging.Logger;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TextViewerDemo {
	private int dw = 0;
	private int dh = 0;
	private int sw = 0;
	private int sh = 0;
	private double dlgwp = .6;
	private double dlghp = .6;
	protected Shell shell;
	protected Display display;

	public static void main(String[] args) {
		Logger.getLogger("jj");
		TextViewerDemo app = new TextViewerDemo();
		app.start();
	}

	private void start() {
		display = new Display();
		shell = new Shell(display);
		shell.setText("TextViewer/SourceViewer视图");
		Rectangle ca = display.getClientArea();
		dh = ca.height;
		dw = ca.width;
		int rw = (int) (dw * dlgwp);
		int rh = (int) (dh * dlghp);
		int x = (dw - rw) / 2;
		int y = (dh - rh) / 2;
		shell.setBounds(x, y, rw, rh);
		sw = shell.getClientArea().width;
		sh = shell.getClientArea().height;
		render();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	
	private void render() {
		shell.setLayout(new FillLayout());
		SashForm sashForm = new SashForm(shell, SWT.HORIZONTAL);
		CompositeRuler ruler = new CompositeRuler();
		LineNumberRulerColumn lineCol = new LineNumberRulerColumn();
		lineCol.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
		ruler.addDecorator(0, lineCol);

		SourceViewer sourceViewer = new SourceViewer(sashForm, ruler, SWT.BORDER|SWT.V_SCROLL|SWT.H_SCROLL);
		Document document = new Document();
		sourceViewer.setDocument(document);
		TextViewer text = new TextViewer(sashForm, SWT.BORDER|SWT.MULTI|SWT.V_SCROLL);
		text.setDocument(document);
		StyledText textWidget = text.getTextWidget();
		textWidget.setWordWrap(true);
		textWidget.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
		textWidget.setForeground(display.getSystemColor(SWT.COLOR_WHITE));
		sashForm.setWeights(new int[] {2,1});
		
		
		byte[] bs;
		try {
			bs = this.getClass().getResourceAsStream("TextViewerDemo.class").readAllBytes();
			document.set(new String(bs,"UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
