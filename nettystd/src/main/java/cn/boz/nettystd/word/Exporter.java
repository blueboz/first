package cn.boz.nettystd.word;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import cn.boz.domain.ora.pojo.DbaTabComments;
import cn.boz.domain.ora.pojo.DbaTabCommentsExample;
import cn.boz.domain.ora.pojo.DbaTabCommentsExample.Criteria;
import cn.boz.ora.mapper.DbaColCommentsMapper;
import cn.boz.ora.mapper.DbaTabCommentsMapper;

@Component
public class Exporter {

	@Autowired
	private DbaTabCommentsMapper dbaTabCommentsMapper;

	@Autowired
	private DbaColCommentsMapper dbaColCommentsMapper;
	
	private XWPFDocument doc;

	public void initDocument(){
		doc = new XWPFDocument();// 创建Word文件
		XWPFParagraph p = doc.createParagraph();
		p.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r = p.createRun();
		r.setText("可恶的标题党");
	}

	public void createABook() throws Exception {
		DbaTabCommentsExample dtce = new DbaTabCommentsExample();
		Criteria criteria = dtce.createCriteria();
		criteria.andOwnerEqualTo("ZHSPDEV");
		criteria.andTableNameLike("ZHSP%");
		List<DbaTabComments> rst = dbaTabCommentsMapper.selectByExample(dtce);
		List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
		
		for (DbaTabComments dbaTabComments : rst) {
			var map = new LinkedHashMap<String, Object>();
			map.put("tableName", dbaTabComments.getTableName());
			map.put("comment", dbaTabComments.getComments());
			list.add(map);
		}
		Map<String,Object> map = new LinkedHashMap<String, Object>();
		map.put("tableName","表名");
		map.put("comment", "注释");
		generateTable(doc, "所有表信息", map, list);

	}
	
	
	
	public void closeBook() {
		try {
			FileOutputStream out = new FileOutputStream("C:/sample2.doc");
			doc.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		var appCtx = new ClassPathXmlApplicationContext("app-ctx.xml");
		Exporter exporter = appCtx.getBean(Exporter.class);
		exporter.initDocument();
		try {
			exporter.createABook();
		}catch(Exception e) {
			exporter.closeBook();
		}
		appCtx.close();

	}

	public void generateTable(XWPFDocument doc, String onlyHeader, Map<String, Object> headerMapper,
			List<Map<String, Object>> datas) {
		XWPFTable table = doc.createTable();// 创建一个表格
		CTTblWidth comTableWidth = table.getCTTbl().addNewTblPr().addNewTblW();
		comTableWidth.setType(STTblWidth.DXA);
		comTableWidth.setW(BigInteger.valueOf(9072));
		int row_index = 0;
		if (onlyHeader != null) {
			XWPFTableRow header = table.getRow(row_index++);
			XWPFTableCell cella = header.getCell(0);
			cella.setColor("EEECE1"); // 设置表格颜色
			CTTcPr tcPr = cella.getCTTc().getTcPr();
			CTDecimalNumber number = CTDecimalNumber.Factory.newInstance();
			number.setVal(new BigInteger(headerMapper.size()+""));
			tcPr.setGridSpan(number);
			cella.setText(onlyHeader);
		}

		XWPFTableRow row = table.getRow(row_index++);
		if (row == null)
			row = table.createRow();
		int index = 0;
		Set<String> keys = headerMapper.keySet();
		for (String k : keys) {
			XWPFTableCell cell = row.getCell(index++);
			if (cell == null)
				cell = row.createCell();
			String val = (String) headerMapper.get(k);
			cell.setColor("CECECE");
			cell.setText(val);
		}
		for (Map<String, Object> dat : datas) {
			XWPFTableRow rowInside = table.getRow(row_index++);
			if (rowInside == null)
				rowInside = table.createRow();
			Set<String> keySet = headerMapper.keySet();
			index = 0;
			for (String key : keySet) {
				String val = (String) dat.get(key);
				XWPFTableCell cell = rowInside.getCell(index++);
				if (cell == null)
					cell = rowInside.createCell();
				cell.setText(val);
			}

		}

	}


}
