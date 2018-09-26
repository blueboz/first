#关于POI
POI对于Word文档的操作可以基本上分为如下大类

```
XWPFParagraph
 	|->XWPFRun
XWPFTable
```

一般情况下，对普通文字的处理都在paragraph类，


#Paragraph

##XML 代码
样式对应的xml源码如下 

```xml
<xml-fragment>
  <w:pPr>
    <w:pStyle w:val="1"/>
  </w:pPr>
  <w:r>
    <w:rPr>
      <w:rFonts w:hint="eastAsia"/>
    </w:rPr>
    <w:t>标题</w:t>
  </w:r>
  <w:r>
    <w:rPr>
      <w:rFonts w:hint="eastAsia"/>
    </w:rPr>
    <w:t>1</w:t>
  </w:r>
</xml-fragment>
```

##Java操作代码

普通直接修改的方法

```java
XWPFParagraph p1 = doc.createParagraph();
XWPFRun r = p1.createRun();
r.setText("标题");
r.setFontSize(28);
p1.setAlignment(ParagraphAlignment.CENTER);
p1.setSpacingBeforeLines(1200);
```

###源码获取法
根据如下的CTP获取方法，请注意举一反三，基本的操作方法，就是对这个对象的属性进行修改，修改方法参照xml格式
因为这个对象是一个xml对象，可以翻译成为xml文档呢，从而使得可以直接附着到Word 文档的指定位置上

```
XWPFParagraph p = doc.createParagraph();
CTP ctp = p.getCTP();
CTPPr pPr = ctp.addNewPPr();
CTR r = ctp.addNewR();
CTRPr rPr = r.getRPr();
CTFonts ctFonts = CTFonts.Factory.newInstance();
rPr.setRFonts(ctFonts);
```


#Style （样式）
样式的XML源代码如下 

```xml
<xml-fragment w:styleId="1" w:type="paragraph">
  <w:name w:val="heading 1"/>
  <w:basedOn w:val="a"/>
  <w:next w:val="a"/>
  <w:link w:val="1Char"/>
  <w:uiPriority w:val="9"/>
  <w:qFormat/>
  <w:rsid w:val="009934BB"/>
  <w:pPr>
    <w:keepNext/>
    <w:keepLines/>
    <w:spacing w:after="330" w:before="340" w:line="578" w:lineRule="auto"/>
    <w:outlineLvl w:val="0"/>
  </w:pPr>
  <w:rPr>
    <w:b/>
    <w:bCs/>
    <w:kern w:val="44"/>
    <w:sz w:val="44"/>
    <w:szCs w:val="44"/>
  </w:rPr>
</xml-fragment>
```


#克隆模板的样式代码

通过读取format.docx,这个文件可以是随意的文件，不过要求，必须含有
设置了标题1 的文字，设置了标题2的文字。。。设置了标题7 的文字
总之，样式要多。在读取了这个文件的CTStyles之后，再将其克隆到当前的这个文档中

```java
InputStream is = new FileInputStream("format.docx");
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
```