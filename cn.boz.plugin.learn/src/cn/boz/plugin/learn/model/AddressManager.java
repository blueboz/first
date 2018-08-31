package cn.boz.plugin.learn.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.XMLMemento;

import cn.boz.plugin.learn.Activator;

public class AddressManager implements IPropertyChangeListener {

	private List<AddressItem> addresses = new ArrayList<AddressItem>();
	private List<AddressViewContentProvider> listeners = new ArrayList<AddressViewContentProvider>();
	private static AddressManager manager;

	private AddressManager() {
		loadAddresses();
		if(addresses.isEmpty()) {
			Random random = new Random();
			IntStream.range(0, 20).forEach(i -> {
				AddressItem ai = new AddressItem();
				int nextInt = random.nextInt(90);
				ai.setName("周杰伦" + nextInt + 9);
				ai.setCategory(random.nextInt(AddressItem.CATEGORYS.length));
				nextInt = random.nextInt(90);
				ai.setAge(nextInt + 9 + "岁");
				nextInt = random.nextInt(90);
				ai.setMessageInfo(nextInt + 9 + "From the world that is far away");
				addresses.add(ai);
			});
		}
	}

	public void setAddresses(List<AddressItem> addresses) {
		this.addresses = addresses;
	}

	public void fireAddressChanged(AddressManagerEvent evt) {
		listeners.forEach(it -> {
			it.addressesChanged(evt);
		});
		return;
	}

	public void removeAddressManagerListener() {

	}

	public void removeAddresses() {

	}

	// 可以采用单例的模式进行开发
	public static AddressManager getManager() {
		if (manager == null) {
			manager = new AddressManager();
		}
		return manager;
	}

	public void addAddressManagerListener(AddressViewContentProvider listener) {
		listeners.add(listener);
	}

	public List<AddressItem> loadAddressses() {
		return addresses;

	}

	public List<AddressItem> getAddresses() {
		return addresses;
	}

	public void removeAddresses(AddressItem[] selectedAddress) {
		AddressManagerEvent evt = new AddressManagerEvent();
		evt.setItemRemoved(Arrays.asList(selectedAddress));
		fireAddressChanged(evt);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		fireAddressItemChanged(event);
	}

	private void fireAddressItemChanged(PropertyChangeEvent event) {

		listeners.forEach(it -> {
			it.addressItemChange(event);
		});
	}

	public static final String TAG_ADDRESSES = "Addresses";
	public static final String TAG_ADDRESS = "Address";

	public void saveAddresses() {
		if (addresses == null)
			return;
		XMLMemento xmlMemento = XMLMemento.createWriteRoot(TAG_ADDRESSES);
		addresses.forEach(it -> {
			IMemento addr = xmlMemento.createChild(TAG_ADDRESS);
			addr.putString("name", it.getName());
			addr.putString("age", it.getAge());
			addr.putString("messageInfo", it.getMessageInfo());
			addr.putInteger("category", it.getCategory());
		});
		FileWriter writer;
		try {
			writer = new FileWriter(getAddressesFile());
			xmlMemento.save(writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public File getAddressesFile()  {
		IPath loc = Activator.getDefault().getStateLocation();
		IPath append = loc.append("Addresses.xml");
		return append.toFile();
	}

	public void loadAddresses() {
		FileReader reader = null;
		try {
			reader = new FileReader(getAddressesFile());
			XMLMemento xml = XMLMemento.createReadRoot(reader);
			loadAddresses(xml);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (WorkbenchException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void loadAddresses(XMLMemento memento) {
		IMemento[] chs = memento.getChildren(TAG_ADDRESS);
		for (int i = 0; i < chs.length; i++) {
			IMemento iMemento = chs[i];
			AddressItem addressItem = new AddressItem();
			addressItem.setName(iMemento.getString("name"));
			addressItem.setAge(iMemento.getString("age"));
			addressItem.setMessageInfo(iMemento.getString("messageInfo"));
			addressItem.setCategory(iMemento.getInteger("category"));
			addresses.add(addressItem);
		}
	}

}
