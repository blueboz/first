package cn.boz.plugin.learn.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

public class ImageCache {

	private static ImageCache imageCache;

	public static ImageCache getInstance() {
		if (imageCache == null) {
			imageCache = new ImageCache();
		}
		return imageCache;
	}

	private Map<ImageDescriptor, Image> map = new HashMap<ImageDescriptor, Image>();

	public Image getImage(ImageDescriptor imageDescriptor) {
		if (imageDescriptor == null) {
			return null;
		}
		Image image = map.get(imageDescriptor);
		if (image == null) {
			image = imageDescriptor.createImage();
			map.put(imageDescriptor, image);
		}
		return image;
	}

	public void dipose() {
		map.forEach((k,v)->{
			v.dispose();
		});
		map.clear();
	}
	
}
