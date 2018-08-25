package cn.boz.swtjface.provider;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;

public class AnimalContentProvider implements IStructuredContentProvider {

	@Override
	public Object[] getElements(Object element) {
		return ((List)element).toArray();
	}

}
