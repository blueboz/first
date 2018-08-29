package cn.boz.plugin.learn.actions;

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ui.internal.misc.StringMatcher;

import cn.boz.plugin.learn.model.AddressItem;

public class AddressViewFilter extends ViewerFilter {

	private StructuredViewer viewer;

	public AddressViewFilter(StructuredViewer viewer) {
		this.viewer = viewer;
	}

	@SuppressWarnings("restriction")
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof AddressItem) {
			AddressItem ai = (AddressItem) element;
			String name = ai.getName();
			return matcher.match(name);
		}
		return false;
	}

	public String getPattern() {
		// TODO Auto-generated method stubJ
		return "";
	}

	private StringMatcher matcher;
	String pattern;

	@SuppressWarnings("restriction")
	public void setFilter(String newPattern) {
		boolean filtering = matcher != null;
		if (newPattern != null && newPattern.trim().length() > 0) {
			pattern = newPattern;
			matcher = new StringMatcher(pattern, true, false);
			if (filtering) {
				viewer.addFilter(this);
			} else {
				viewer.refresh();
			}
		} else {
			pattern = "";
			matcher = null;
			if (filtering) {
				viewer.removeFilter(this);
			}
		}

	}

}
