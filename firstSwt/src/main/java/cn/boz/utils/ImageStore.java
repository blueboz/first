package cn.boz.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class ImageStore implements InitializingBean, DisposableBean {

	public static final Integer USER = 0x01;
	public static final Integer ROLE = 0x02;
	public static final Integer RIGHT = 0x03;
	public static final Integer ORACLE = 0x04;

	private Display display;

	private Map<Integer, Image> map = new HashMap<Integer, Image>();

	public Image getImage(int id) {
		return map.get(id);
	}

	@Override
	public void destroy() throws Exception {

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		display = Display.getCurrent();
		Image user = new Image(display,
				"C:\\Users\\Administrator\\git\\firstSwt\\firstSwt\\src\\main\\resources\\User.png");
		map.put(USER, user);
		Image right = new Image(display,
				"C:\\Users\\Administrator\\git\\firstSwt\\firstSwt\\src\\main\\resources\\Right.png");
		map.put(RIGHT, right);
		Image role = new Image(display,
				"C:\\Users\\Administrator\\git\\firstSwt\\firstSwt\\src\\main\\resources\\Role.png");
		map.put(ROLE, role);
		Image oracle = new Image(display,
				"C:\\Users\\Administrator\\git\\firstSwt\\firstSwt\\src\\main\\resources\\Oracle.png");
		map.put(ORACLE, oracle);
	}

}
