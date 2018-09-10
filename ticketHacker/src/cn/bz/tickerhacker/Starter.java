package cn.bz.tickerhacker;

import org.eclipse.swt.widgets.Display;

import com.sun.jna.platform.win32.Winevt.EVT_VARIANT.field1_union;

import cn.bz.tickerhacker.utils.ImageCache;
import cn.bz.tickerhacker.view.Login;

public class Starter {

	public static void main(String[] args) {
		try {
			Login window = new Login();
			window.setBlockOnOpen(true);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ImageCache.getInstance().dispose();
			Display.getCurrent().dispose();
		}
	}
}
