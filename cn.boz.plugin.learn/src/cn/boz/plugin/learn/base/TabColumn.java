package cn.boz.plugin.learn.base;

public @interface TabColumn {
	String columnName();
	int columnWidth() default 120;
	int prior() default 0;
}
