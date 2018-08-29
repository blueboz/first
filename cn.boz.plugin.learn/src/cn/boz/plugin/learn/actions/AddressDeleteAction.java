package cn.boz.plugin.learn.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

import cn.boz.plugin.learn.model.AddressManager;
import cn.boz.plugin.learn.views.AddressView;

public class AddressDeleteAction extends Action{

	private AddressView addressView;
	
	public AddressDeleteAction(AddressView addressView,String text,ImageDescriptor id) {
		super(text,id);
		this.addressView=addressView;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		AddressManager.getManager().removeAddresses(addressView.getSelectedAddress());
		super.run();
	}
}
