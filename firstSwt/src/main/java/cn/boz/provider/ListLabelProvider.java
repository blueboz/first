package cn.boz.provider;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

import cn.boz.domain.User;

public class ListLabelProvider implements ILabelProvider {

	private Image image;

	public ListLabelProvider() {
		super();
		var is=this.getClass().getResourceAsStream("../res/Cursor.ico");
		var id=new ImageData(is);
		Display current = Display.getCurrent();
		image = new Image(current, id);
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void dispose() {
		image.dispose();
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImage(Object element) {
		return image;
	}

	@Override
	public String getText(Object element) {
		var u=(User)element;
		return u.getName();
	}

}
