package cn.boz.nettystd.word;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
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
			XWPFDocument createDoc = new XWPFDocument();
			is = new FileInputStream(sourcePath);
			doc = new XWPFDocument(is);
			// 获取段落
			//CTDocument1 document = doc.getDocument();
			//System.out.println(document);
			List<XWPFParagraph> paras = doc.getParagraphs();
			for (XWPFParagraph para : paras) {
				System.out.println(para.getCTP());// 得到xml格式
				CTP ctp = para.getCTP();
				System.out.println();
			}
			List<XWPFTable> tables = doc.getTables();
			for (XWPFTable tab : tables) {
				CTTbl ctTbl = tab.getCTTbl();
				System.out.println(ctTbl);
				System.out.println();
			}
		} catch (Exception e) {
		}

	}
}
