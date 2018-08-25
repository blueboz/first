package cn.boz.swtjface.viewer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColorCellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import cn.boz.swtjface.base.BaseCode;
import cn.boz.swtjface.domain.People;
import cn.boz.swtjface.modifier.TableViewerCellModifier;
import cn.boz.swtjface.provider.PeopleContentProvider;
import cn.boz.swtjface.provider.PeopleLabelProvider;
import cn.boz.swtjface.sort.Ranker;
import cn.boz.swtjface.sort.Sort;

public class TableViewerDemo extends BaseCode {

	private List<People> peopleList = new ArrayList<People>();
	public static final String ID = "学号";
	public static final String NAME = "姓名";
	public static final String MALE = "性别";
	public static final String AGE = "年龄";
	public static final String POSITION = "职位";
	public static final String COLOR = "喜欢的颜色";
	private TableViewer tableViewer;
	private Label label;
	private Table table;
	private Boolean a=false;
	@Override
	protected void render() {
		shell.setLayout(new RowLayout(SWT.VERTICAL));
		ToolBar toolBar = new ToolBar(shell, SWT.BAR | SWT.HORIZONTAL);
		tableViewer = new TableViewer(shell, SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		TableColumn Col1 = new TableColumn(table, SWT.LEFT);
		Col1.setText("员工号");
		// 设置列宽度
		Col1.setWidth(80);
		Col1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				a=!a;
				((Ranker)tableViewer.getComparator()).doSort(a?1:-1);
				tableViewer.refresh();
				super.widgetSelected(e);
			}
		});
		tableViewer.setComparator(new Ranker());
		//tableViewer.setSorter(new Sort());
		TableColumn Col2 = new TableColumn(table, SWT.LEFT);
		Col2.setText("姓名");
		Col2.setWidth(80);
		Col2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				a=!a;
				((Ranker)tableViewer.getComparator()).doSort(a?2:-2);
				tableViewer.refresh();
				super.widgetSelected(e);
			}
		});
		
		TableColumn Col3 = new TableColumn(table, SWT.LEFT);
		Col3.setText("性别");
		Col3.setWidth(80);
		Col3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				a=!a;
				((Ranker)tableViewer.getComparator()).doSort(a?3:-3);
				tableViewer.refresh();
				super.widgetSelected(e);
			}
		});
		
		TableColumn Col4 = new TableColumn(table, SWT.LEFT);
		Col4.setText("年龄");
		Col4.setWidth(80);
		Col4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				a=!a;
				((Ranker)tableViewer.getComparator()).doSort(a?4:-4);
				tableViewer.refresh();
				super.widgetSelected(e);
			}
		});
		TableColumn Col5 = new TableColumn(table, SWT.LEFT);
		Col5.setText("职位");
		Col5.setWidth(70);
		Col5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				a=!a;
				((Ranker)tableViewer.getComparator()).doSort(a?5:-5);
				tableViewer.refresh();
				super.widgetSelected(e);
			}
		});	
		
		TableColumn Col6 = new TableColumn(table, SWT.LEFT);
		Col6.setText("喜欢的颜色");
		Col6.setWidth(128);
		Col6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				a=!a;
				((Ranker)tableViewer.getComparator()).doSort(a?6:-6);
				tableViewer.refresh();
				super.widgetSelected(e);
			}
		});	

		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		createPeopleList();
		CellEditor[] editors = new CellEditor[6];
		editors[0] = null;
		editors[1] = new TextCellEditor(table);
		editors[2] = new CheckboxCellEditor(table);
		editors[3] = null;
		editors[4] = new ComboBoxCellEditor(table, new String[] { "项目经理", "部门经理", "总监", "总经理" }, SWT.READ_ONLY);
		editors[5] = new ColorCellEditor(table);
		// 每一栏目的属性
		tableViewer.setColumnProperties(new String[] { ID, NAME, MALE, AGE, POSITION, COLOR });
		// 编辑器数据来源--输出
		tableViewer.setCellModifier(new TableViewerCellModifier(tableViewer));
		// 编辑器
		tableViewer.setCellEditors(editors);

		tableViewer.setContentProvider(new PeopleContentProvider());
		tableViewer.setLabelProvider(new PeopleLabelProvider());
		tableViewer.setInput(peopleList);

		label = new Label(shell, SWT.NONE);
		createToolBarManager(toolBar);
		
	}

	private AgeFilter ageFilter;
	/**
	 * 创建工具栏
	 * @param toolBar
	 */
	public void createToolBarManager(ToolBar toolBar) {
		//通过这个filter 实现排序的功能
		ageFilter = new AgeFilter();
		ToolItem toolItem = new ToolItem(toolBar, SWT.NONE);
		toolItem.setText("过滤");
		toolItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tableViewer.setFilters(ageFilter);
				super.widgetSelected(e);
			}
		});
		ToolItem toolItem2 = new ToolItem(toolBar, SWT.NONE);
		toolItem2.setText("恢复");
		toolItem2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tableViewer.removeFilter(ageFilter);
			}
		});
		ToolItem toolItem3 = new ToolItem(toolBar, SWT.NONE);
		toolItem3.setText("刷新记录");
		toolItem3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tableViewer.refresh();
				super.widgetSelected(e);
			}
		});
		ToolItem toolItem4 = new ToolItem(toolBar, SWT.NONE);
		toolItem4.setText("删除所选记录");
		toolItem4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.remove(table.getSelectionIndices());
				super.widgetSelected(e);
			}
		});
	}
	
	class AgeFilter extends ViewerFilter{

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			People p=(People) element;
			return p.getAge() >=30;
		}
		
	}


	public static void main(String[] args) {
		new TableViewerDemo().start();
	}

	/**
	 * ArrayList 数组表功能类似Vector，用于缩放数组维护组合， 经常在表的插入、删除时使用。
	 */
	private ArrayList createPeopleList() {
		peopleList = new ArrayList();
		{
			People p1 = new People();
			p1.setID(20020001);
			p1.setName("王志辉");
			p1.setMale(true);
			p1.setAge(34);
			p1.setPosition("总经理");
			p1.setColor(new RGB(255, 0, 0));
			peopleList.add(p1);
		}
		{
			People p2 = new People();
			p2.setID(20020002);
			p2.setName("李晓娟");
			p2.setMale(false);
			p2.setAge(27);
			p2.setPosition("商务总监");
			p2.setColor(new RGB(255, 255, 0));
			peopleList.add(p2);
		}
		{
			People p3 = new People();
			p3.setID(20020003);
			p3.setName("李志强");
			p3.setMale(true);
			p3.setAge(29);
			p3.setPosition("行政总监");
			p3.setColor(new RGB(255, 255, 255));
			peopleList.add(p3);
		}
		{
			People p4 = new People();
			p4.setID(20020004);
			p4.setName("任鸿霞");
			p4.setMale(false);
			p4.setAge(31);
			p4.setPosition("财务部经理");
			p4.setColor(new RGB(0, 255, 255));
			peopleList.add(p4);
		}
		return (ArrayList) peopleList;
	}
}
