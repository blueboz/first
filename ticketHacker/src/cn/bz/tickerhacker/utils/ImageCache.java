package cn.bz.tickerhacker.utils;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.UUID;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.junit.Test;

public class ImageCache {
	private final HashMap<ImageDescriptor, Image> imageMap = new HashMap<ImageDescriptor, Image>();
	private final HashMap<String, Image> mapis = new HashMap<String, Image>();
	private static ImageCache instance;

	public static ImageCache getInstance() {
		if (instance == null)
			instance = new ImageCache();
		return instance;
	}

	public Image getImage(ImageDescriptor descriptor) {
		if (descriptor == null)
			return null;
		Image image = (Image) imageMap.get(descriptor);
		if (image == null) {
			image = descriptor.createImage();
			imageMap.put(descriptor, image);
		}
		return image;
	}

	public Image getImage(String imgKey) {
		if (imgKey == null)
			return null;
		Image image = (Image) mapis.get(imgKey);
		if (image == null) {
			InputStream inputStream = this.getClass().getResourceAsStream(imgKey);
			ImageData imageData = new ImageData(inputStream);
			image = new Image(Display.getCurrent(), imageData);
			mapis.put(imgKey, image);
		}
		return image;
	}

	public Image getImage(String imgKey, int x, int y, int w, int h) {
		if (imgKey == null)
			return null;
		Image image = (Image) mapis.get(imgKey);
		if (image == null) {
			InputStream inputStream = this.getClass().getResourceAsStream(imgKey);
			ImageData imageData = new ImageData(inputStream);
			byte[] bs = new byte[(w) * (h)];
			int counter = 0;
			for (int i = x; i < w; i++) {
				for (int j = y; j < h; j++) {
					int tmp = (y + j) * imageData.bytesPerLine + x + i;
					bs[counter++] = imageData.data[tmp];
				}
			}
			int bytesPerPixel = imageData.bytesPerLine / imageData.width;
			ImageData bu = new ImageData(imageData.width, imageData.height, imageData.depth, imageData.palette, imageData.bytesPerLine, imageData.data);
			image = new Image(Display.getCurrent(), bu);
			mapis.put(imgKey + x + y + w + h, image);
		}
		return image;
	}

	public Image getImage(InputStream inputStream) {
		if (inputStream != null) {
			ImageData imageData = new ImageData(inputStream);
			Image image = new Image(Display.getCurrent(), imageData);
			mapis.put(UUID.randomUUID().toString(), image);
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return image;
		}
		return null;
	}

	public void dispose() {
		Iterator iter = imageMap.values().iterator();
		while (iter.hasNext())
			((Image) iter.next()).dispose();

		mapis.forEach((k, v) -> {
			v.dispose();
		});
		imageMap.clear();
	}
}
