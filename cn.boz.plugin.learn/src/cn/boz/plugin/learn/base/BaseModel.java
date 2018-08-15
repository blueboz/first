package cn.boz.plugin.learn.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class BaseModel {

	Map<String, Object> map = new HashMap<String, Object>();

	boolean isParse = false;

	private List<TabColumn> ts=new ArrayList<TabColumn>();

	/**
	 * 根据注解进行映射
	 * @param table
	 */
	public void init(Table table) {
		if (!isParse) {
			Class<? extends BaseModel> clz = this.getClass();
			var fs = clz.getDeclaredFields();
			for (var f : fs) {
				TabColumn tabColumn = f.getAnnotation(TabColumn.class);
				ts.add(tabColumn);
				ts.sort((TabColumn tc1,TabColumn tc2)->{
					return tc1.prior()-tc2.prior();
				});
			}
			for(var t:ts) {
				var tc=new TableColumn(table, SWT.NONE);
				tc.setText(t.columnName());
				tc.setWidth(t.columnWidth());
			}
		}
	}
}
