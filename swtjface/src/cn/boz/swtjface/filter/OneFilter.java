package cn.boz.swtjface.filter;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import cn.boz.swtjface.domain.Animals;
import cn.boz.swtjface.domain.People;

public class OneFilter extends ViewerFilter{

	@Override
	public boolean select(Viewer viewer, Object parent, Object element) {
		Animals p=(Animals) element;
		return !p.getAnimal().equals("大象");
	}

}
