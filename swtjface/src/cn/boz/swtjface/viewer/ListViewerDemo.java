package cn.boz.swtjface.viewer;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import cn.boz.swtjface.base.BaseAppWindow;
import cn.boz.swtjface.domain.Animals;
import cn.boz.swtjface.provider.AnimalContentProvider;
import cn.boz.swtjface.provider.AnimalLabelProvider;

public class ListViewerDemo extends BaseAppWindow {
	private ArrayList animalList;

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());
		ListViewer listViewer = new ListViewer(composite);
		animalList = createAnimalList();
		listViewer.setContentProvider(new AnimalContentProvider());
		listViewer.setLabelProvider(new AnimalLabelProvider());
		listViewer.setInput(animalList);
		return composite;
	}

	public static void main(String[] args) {
		new ListViewerDemo().run();
	}

	private ArrayList createAnimalList() {
		animalList = new ArrayList();
		{
			Animals elephant = new Animals();
			elephant.setAnimal("大象");
			animalList.add(elephant);
		}
		{
			Animals cetacean = new Animals();
			cetacean.setAnimal("鲸鱼");
			animalList.add(cetacean);
		}
		{
			Animals leopard = new Animals();
			leopard.setAnimal("猎豹");
			animalList.add(leopard);
		}
		{
			Animals tiger = new Animals();
			tiger.setAnimal("老虎");
			animalList.add(tiger);
		}
		{
			Animals shark = new Animals();
			shark.setAnimal("鲨鱼");
			animalList.add(shark);
		}
		{
			Animals turtle = new Animals();
			turtle.setAnimal("海龟");
			animalList.add(turtle);
		}

		{
			Animals lion = new Animals();
			lion.setAnimal("狮子");
			animalList.add(lion);
		}
		return animalList;

	}
}
