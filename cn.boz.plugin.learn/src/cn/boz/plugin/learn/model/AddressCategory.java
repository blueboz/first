package cn.boz.plugin.learn.model;

import org.eclipse.swt.graphics.Image;

public class AddressCategory {

	private String categoryName;
	private int priority;

	public AddressCategory(String categoryName, int priority) {
		super();
		this.categoryName = categoryName;
		this.priority = priority;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Image getImage() {
		return null;
	}
	
	public int compareTo(Object obj){
		return this.priority-((AddressCategory)obj).priority;
	}
	
	public int getTypes(){
		return 0;
	}
	
}
