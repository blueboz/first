package cn.boz.swtjface.provider;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;

public class PeopleContentProvider implements IStructuredContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		return ((List) inputElement).toArray();
	}

}
