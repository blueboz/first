package cn.boz.swtjface.sort;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

import cn.boz.swtjface.domain.People;

public class Ranker extends ViewerComparator {

	private int column;

	public void doSort(int column) {
		this.column = column;
	}

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (e1 instanceof People) {
			People p1 = (People) e1;
			People p2 = (People) e2;
			switch (column) {
			case 1: {
				Integer str1 = p1.getID();
				Integer str2 = p2.getID();
				int IDDesc = str2.compareTo(str1);
				return IDDesc;
			}
			case -1: {
				Integer str1 = p1.getID();
				Integer str2 = p2.getID();
				int IDAsc = str1.compareTo(str2);
				return IDAsc;
			}
			case 2: {
				String str1 = p1.getName();
				String str2 = p2.getName();
				int NameDesc = str2.compareTo(str1);
				return NameDesc;
			}
			case -2: {
				String str1 = p1.getName();
				String str2 = p2.getName();
				int NameAsc = str1.compareTo(str2);
				return NameAsc;
			}
			case 3: {
				Boolean str1 = p1.isMale();
				Boolean str2 = p2.isMale();
				int MaleDesc = str2.compareTo(str1);
				return MaleDesc;
			}
			case -3: {
				Boolean str1 = p1.isMale();
				Boolean str2 = p2.isMale();
				int MaleAsc = str1.compareTo(str2);
				return MaleAsc;
			}
			case 4: {
				Integer str1 = p1.getAge();
				Integer str2 = p2.getAge();
				int AgeDesc = str2.compareTo(str1);
				return AgeDesc;
			}
			case -4: {
				Integer str1 = p1.getAge();
				Integer str2 = p2.getAge();
				int AgeAsc = str1.compareTo(str2);
				return AgeAsc;
			}
			case 5: {
				Integer str1 = p1.getAge();
				Integer str2 = p2.getAge();
				int PositionDesc = str2.compareTo(str1);
				return PositionDesc;
			}
			case -5: {
				String str1 = p1.getPosition();
				String str2 = p2.getPosition();
				int PositionAsc = str1.compareTo(str2);
				return PositionAsc;
			}
			case -6: {
				int b1=p1.getColor().blue;
				int g1=p1.getColor().green;
				int r1=p1.getColor().red;
				int b2=p2.getColor().blue;
				int g2=p2.getColor().green;
				int r2=p1.getColor().red;
				return r1-r2==0?(g1-g2==0?(b1-b2):g1-g2):r1-r2;
			}
			case 6:{
				int b1=p1.getColor().blue;
				int g1=p1.getColor().green;
				int r1=p1.getColor().red;
				int b2=p2.getColor().blue;
				int g2=p2.getColor().green;
				int r2=p1.getColor().red;
				return -(r1-r2==0?(g1-g2==0?(b1-b2):g1-g2):r1-r2);
				
			}
			}
		}
		return 0;
	}
}
