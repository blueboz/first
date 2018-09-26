package cn.boz.nettystd.word;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFStyle;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.CsAttribute;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;

public class Reader {

	public static void main(String[] args) {
		new Reader().init("", "C:\\bbb.docx");
	}

	public void init(String targetPath, String sourcePath) {
		InputStream is = null;
		XWPFDocument doc = null;
		OutputStream out = null;
		try {
			is = new FileInputStream(sourcePath);
			doc = new XWPFDocument(is);
			CTStyles style = doc.getStyle();
			List<CTStyle> styleList = style.getStyleList();
			for (CTStyle ctStyle : styleList) {
				System.out.println(ctStyle);
			}
//			XWPFStyles styles = doc.getStyles();
//			int size = styles.getNumberOfStyles();
//			System.out.println("Style Size:"+size);
//			for(int i=1;i<15;i++) {
//				XWPFStyle style = styles.getStyle(""+i);
//				CTStyle ctStyle = style.getCTStyle();
//				System.out.println(ctStyle);
//			}

			// 获取段落
			// CTDocument1 document = doc.getDocument();
			// System.out.println(document);

			List<XWPFParagraph> paras = doc.getParagraphs();
			for (XWPFParagraph para : paras) {
				//CTP ctp = para.getCTP();
				//System.out.println(para.getStyleID());
				//System.out.println(para.getText());
				//System.out.println(para.getCTP());// 得到xml格式
			}
			List<XWPFTable> tables = doc.getTables();
			for (XWPFTable tab : tables) {
				CTTbl ctTbl = tab.getCTTbl();
				//System.out.println(ctTbl);
				//System.out.println();
			}
		} catch (Exception e) {
		}

	}
}
