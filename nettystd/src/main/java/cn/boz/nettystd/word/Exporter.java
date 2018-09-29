package cn.boz.nettystd.word;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFStyle;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STStyleType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import cn.boz.domain.ora.pojo.DbaColComments;
import cn.boz.domain.ora.pojo.DbaColCommentsExample;
import cn.boz.domain.ora.pojo.DbaConsColumns;
import cn.boz.domain.ora.pojo.DbaConsColumnsExample;
import cn.boz.domain.ora.pojo.DbaConstraints;
import cn.boz.domain.ora.pojo.DbaConstraintsExample;
import cn.boz.domain.ora.pojo.DbaTabColumnsExample;
import cn.boz.domain.ora.pojo.DbaTabColumnsWithBLOBs;
import cn.boz.domain.ora.pojo.DbaTabComments;
import cn.boz.domain.ora.pojo.DbaTabCommentsExample;
import cn.boz.domain.ora.pojo.DbaTabCommentsExample.Criteria;
import cn.boz.ora.mapper.DbaColCommentsMapper;
import cn.boz.ora.mapper.DbaConsColumnsMapper;
import cn.boz.ora.mapper.DbaConstraintsMapper;
import cn.boz.ora.mapper.DbaTabColumnsMapper;
import cn.boz.ora.mapper.DbaTabCommentsMapper;
import cn.boz.ora.mapper.UserConstraintsMapper;

@Component
public class Exporter {

	@Autowired
	private DbaTabCommentsMapper dbaTabCommentsMapper;

	@Autowired
	private DbaColCommentsMapper dbaColCommentsMapper;

	@Autowired
	private DbaTabColumnsMapper dbaTabColumnsMapper;

	@Autowired
	private UserConstraintsMapper userConstraintsMapper;

	@Autowired
	private DbaConstraintsMapper dbaConstraintsMapper;

	@Autowired
	private DbaConsColumnsMapper dbaConsColumnsMapper;

	private XWPFDocument doc;
	private XWPFDocument doc2;

	/**
	 * 使用其他文档的样式，来初始化我们 文档的样式。供使用
	 */
	public void initStyle() {
		try {
			InputStream is = new FileInputStream("C:/bbb.docx");
			doc2 = new XWPFDocument(is);
			
			CTStyles style = doc2.getStyle();
			List<CTStyle> styleList = style.getStyleList();
	
			XWPFStyles stylesIn = doc.getStyles();
			if (stylesIn == null) {
				stylesIn = doc.createStyles();
			}	
			
			for (CTStyle ctStyle : styleList) {
				XWPFStyle xwpfStyle = new XWPFStyle(ctStyle);
				System.out.println(xwpfStyle.getName());
				stylesIn.addStyle(xwpfStyle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * 初始化文档
	 */
	public void initDocument() {
		doc = new XWPFDocument();// 创建Word文件
		initStyle();
	}

	/**
	 * 生成首页
	 */
	public void genPreface() {
		XWPFParagraph p1 = doc.createParagraph();
		XWPFRun r = p1.createRun();
		r.setText("三水区财政局");
		r.setFontSize(28);
		p1.setAlignment(ParagraphAlignment.CENTER);
		p1.setSpacingBeforeLines(1200);

		XWPFParagraph p2 = doc.createParagraph();
		XWPFRun r2 = p2.createRun();
		r2.setText("数据字典");
		r2.setFontSize(28);
		p2.setAlignment(ParagraphAlignment.CENTER);

		XWPFParagraph p3 = doc.createParagraph();
		XWPFRun r3 = p3.createRun();
		r2.setFontSize(20);
		r3.setText("上海锐道信息技术有限公司");
		p3.setAlignment(ParagraphAlignment.CENTER);
		p3.setSpacingBeforeLines(3200);

		XWPFParagraph p4 = doc.createParagraph();
		XWPFRun r4 = p4.createRun();
		String fmt = new SimpleDateFormat("yyyy年MM月").format(new Date());
		r4.setText(fmt);
		r4.setFontSize(20);
		p4.setAlignment(ParagraphAlignment.CENTER);
	}

	public void genHeadMaster() {
		XWPFHeader header = doc.createHeader(HeaderFooterType.DEFAULT);
		XWPFParagraph p = header.createParagraph();
		p.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r1 = p.createRun();
		r1.setText("三水区财政局 (数据字典)");
	}

	public void makeHeader(String header, int level, boolean brk) {
		XWPFParagraph p = doc.createParagraph();
		CTP ctp = p.getCTP();

		CTPPr pPr = ctp.addNewPPr();
		if (brk)
			pPr.addNewPageBreakBefore();
		//CTDecimalNumber outline = pPr.addNewOutlineLvl();
		//outline.setVal(new BigInteger(level + ""));
		XWPFRun r = p.createRun();
		//r.setFontFamily("Calibri");
		p.setStyle(level + "");
//		switch (level) {
//		case 1:
//			r.setBold(true);
//			r.setFontSize(22);
//			break;
//		case 2:
//			r.setFontSize(18);
//			break;
//
//		}
		r.setText(header);
	}

	public void createABook() throws Exception {
		DbaTabCommentsExample dtce = new DbaTabCommentsExample();
		Criteria criteria = dtce.createCriteria();

		criteria.andOwnerEqualTo("ZHSPDEV").andTableNameLike("SWLC_%");
		dtce.or().andOwnerEqualTo("ZHSPDEV").andTableNameEqualTo("UFLO_PROXY_DEF_");
		dtce.or().andOwnerEqualTo("ZHSPDEV").andTableNameEqualTo("UFLO_PROXY_TASK_ASSIGNEE_");
		dtce.or().andOwnerEqualTo("ZHSPDEV").andTableNameEqualTo("UFLO_PROXY_USER_RECORD_");
		dtce.or().andOwnerEqualTo("ZHSPDEV").andTableNameEqualTo("UFLO_PROXY_WHAT_");
		dtce.or().andOwnerEqualTo("ZHSPDEV").andTableNameEqualTo("UFLO_PROXY_WHO_");

		List<DbaTabComments> rst = dbaTabCommentsMapper.selectByExample(dtce);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		for (DbaTabComments dbaTabComments : rst) {
			var map = new LinkedHashMap<String, Object>();
			String tableName = dbaTabComments.getTableName();
			map.put("tableName", tableName);
			String comments = dbaTabComments.getComments();
			if(comments==null||comments.trim().isEmpty()) {
				comments=tableName;
			}
			map.put("comment",comments);
			list.add(map);
		}
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("tableName", "表名");
		map.put("comment", "注释");
		makeHeader("基础表索引数据字典", 1, true);
		generateTable("所有表信息", map, list);
		makeHeader("功能模块字典", 1, false);
		for (DbaTabComments dbaTabComments : rst) {
			String owner = dbaTabComments.getOwner();
			String tableName = dbaTabComments.getTableName();

			DbaTabColumnsExample examp = new DbaTabColumnsExample();
			cn.boz.domain.ora.pojo.DbaTabColumnsExample.Criteria crit3 = examp.createCriteria();
			crit3.andOwnerEqualTo(owner);
			crit3.andTableNameEqualTo(tableName);
			List<DbaTabColumnsWithBLOBs> tabCols = dbaTabColumnsMapper.selectByExampleWithBLOBs(examp);

			List<Map<String, Object>> insideDat = new ArrayList<Map<String, Object>>();
			for (DbaTabColumnsWithBLOBs col : tabCols) {
				String columnName = col.getColumnName();
				String dataType = col.getDataType();
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				hashMap.put("pkey", col.getIdentityColumn().equals("YES") ? "是" : "");
				hashMap.put("owner", col.getOwner());
				hashMap.put("cname", columnName);
				BigDecimal dataLength = col.getDataLength();
				hashMap.put("dtype", dataType);
				hashMap.put("dlen", dataLength.longValue());
				hashMap.put("dnull", col.getNullable().equals("Y") ? "是" : "");
				String dataDefault = col.getDataDefault();
				hashMap.put("dataDefault", dataDefault);
				hashMap.put("constraint", "");
				hashMap.put("comments", "");
				insideDat.add(hashMap);
				DbaColCommentsExample dcce = new DbaColCommentsExample();
				cn.boz.domain.ora.pojo.DbaColCommentsExample.Criteria criteria2 = dcce.createCriteria();
				criteria2.andOwnerEqualTo(owner);
				criteria2.andTableNameEqualTo(tableName);
				criteria2.andColumnNameEqualTo(col.getColumnName());
				List<DbaColComments> colCommments = dbaColCommentsMapper.selectByExample(dcce);
				if (colCommments != null && colCommments.size() > 0) {
					DbaColComments comment = colCommments.get(0);
					String comments = comment.getComments();
					if(comments==null||comments.trim().isEmpty()) {
						comments=columnName;
					}
					hashMap.put("comments", comments);
				}

				DbaConsColumnsExample dbaConsColumnsExample = new DbaConsColumnsExample();

				cn.boz.domain.ora.pojo.DbaConsColumnsExample.Criteria createCriteria2 = dbaConsColumnsExample
						.createCriteria();
				createCriteria2.andTableNameEqualTo(tableName);
				createCriteria2.andOwnerEqualTo(owner);
				createCriteria2.andColumnNameEqualTo(col.getColumnName());
				List<DbaConsColumns> selectByExample = dbaConsColumnsMapper.selectByExample(dbaConsColumnsExample);
				if (selectByExample != null && selectByExample.size() > 0) {
					for (DbaConsColumns dcc : selectByExample) {
						String constraintName = dcc.getConstraintName();
						DbaConstraintsExample dbaConstraintsExample = new DbaConstraintsExample();
						cn.boz.domain.ora.pojo.DbaConstraintsExample.Criteria createCriteria = dbaConstraintsExample
								.createCriteria();
						createCriteria.andConstraintNameEqualTo(constraintName);
						createCriteria.andConstraintTypeEqualTo("P");
						List<DbaConstraints> selectByExample2 = dbaConstraintsMapper
								.selectByExample(dbaConstraintsExample);
						if (selectByExample2 != null && selectByExample2.size() > 0) {
							hashMap.put("pkey", selectByExample2.get(0).getConstraintType());
							hashMap.put("pkey", "是");
						}
					}

				}

			}
			Map<String, Object> hmap = new LinkedHashMap<String, Object>();
			hmap.put("pkey", "是否主键");
			hmap.put("cname", "字段名");
			hmap.put("dtype", "字段类型");
			hmap.put("dlen", "长度");
			//hmap.put("owner", "所有者");
			hmap.put("dnull", "可空");
			hmap.put("dataDefault", "缺省值");
			hmap.put("constraint", "约束");
			hmap.put("comments", "备注");

			makeHeader(dbaTabComments.getTableName(), 2, false);
			generateTable(dbaTabComments.getTableName(), hmap, insideDat);

		}
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
		exporter.fullCycle();

		appCtx.close();

	}

	/**
	 * 完整的生态链
	 */
	private void fullCycle() {
		initDocument();
		genHeadMaster();
		genPreface();
		try {
			createABook();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeBook();
	}

	public void generateTable(String onlyHeader, Map<String, Object> headerMapper, List<Map<String, Object>> datas) {
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
			number.setVal(new BigInteger(headerMapper.size() + ""));
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
				Object obj = dat.get(key);
				String val;
				if (obj instanceof Long) {
					val = obj + "";
				} else {
					val = (String) dat.get(key);
				}
				XWPFTableCell cell = rowInside.getCell(index++);
				if (cell == null)
					cell = rowInside.createCell();
				cell.setText(val);
			}

		}

	}

	/**
	 * 增加自定义标题样式。这里用的是stackoverflow的源码
	 * 
	 * @param docxDocument 目标文档
	 * @param strStyleId   样式名称
	 * @param headingLevel 样式级别
	 */
	private static void addCustomHeadingStyle(XWPFDocument docxDocument, String strStyleId, int headingLevel) {
		strStyleId = String.valueOf(Integer.parseInt(strStyleId) + 1);
		CTStyle ctStyle = CTStyle.Factory.newInstance();
		ctStyle.setStyleId(strStyleId);

		CTString styleName = CTString.Factory.newInstance();
		styleName.setVal(strStyleId);
		ctStyle.setName(styleName);

		CTDecimalNumber indentNumber = CTDecimalNumber.Factory.newInstance();
		indentNumber.setVal(BigInteger.valueOf(headingLevel));

		// lower number > style is more prominent in the formats bar
		ctStyle.setUiPriority(indentNumber);

		CTOnOff onoffnull = CTOnOff.Factory.newInstance();
		ctStyle.setUnhideWhenUsed(onoffnull);

		// style shows up in the formats bar
		ctStyle.setQFormat(onoffnull);

		// style defines a heading of the given level
		CTPPr ppr = CTPPr.Factory.newInstance();
		ppr.setOutlineLvl(indentNumber);
		ctStyle.setPPr(ppr);

		XWPFStyle style = new XWPFStyle(ctStyle);

		// is a null op if already defined
		XWPFStyles styles = docxDocument.createStyles();

		style.setType(STStyleType.PARAGRAPH);
		styles.addStyle(style);
	}

	public void createMyStyle() { 
		CTStyle ctStyle = CTStyle.Factory.newInstance();
		CTString ctString = CTString.Factory.newInstance();
		
		ctStyle.setName(ctString);

	}
}
