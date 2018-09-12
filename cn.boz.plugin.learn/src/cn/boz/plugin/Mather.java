package cn.boz.plugin;

import java.math.BigDecimal;

import org.junit.Test;

public class Mather {

	public static void main(String[] args) {
		BigDecimal initVal = new BigDecimal("-10");
		BigDecimal step = new BigDecimal("0.2");
		BigDecimal end = new BigDecimal("10");
		for (; initVal.compareTo(end) < 0; initVal = initVal.add(step)) {

			double exp = Math.exp(initVal.doubleValue());
			BigDecimal expv = new BigDecimal(exp);
			BigDecimal addv = expv.add(new BigDecimal("1"));
			BigDecimal dividev = new BigDecimal("1").divide(addv, 100, BigDecimal.ROUND_HALF_UP);
			System.out.println(initVal.toPlainString() + "\t\t" + dividev.toPlainString());
		}
	}

	@Test
	public void testName() throws Exception {

		BigDecimal a = new BigDecimal("0.45");

		String result = BigDecimal.valueOf(Math.cos(a.doubleValue())).toPlainString();

		System.out.println(result);
	}

	@Test
	public void testName2() throws Exception {
		double acos = Math.asin(1 / 2) * 3;
		System.out.println(Math.PI);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testZhentTai() {
		BigDecimal initVal = new BigDecimal("-10");
		BigDecimal step = new BigDecimal("0.2");
		BigDecimal end = new BigDecimal("10");
		BigDecimal duta = new BigDecimal("0.2");
		for (; initVal.compareTo(end) < 0; initVal = initVal.add(step)) {
			BigDecimal divide = new BigDecimal(1).divide(new BigDecimal(Math.pow(new BigDecimal("2").multiply(duta).multiply(new BigDecimal(Math.PI)).doubleValue(),
					(new BigDecimal("1").divide(new BigDecimal("2"),10,BigDecimal.ROUND_HALF_UP)).doubleValue())),10,BigDecimal.ROUND_HALF_UP);
			System.out.println(divide);
		}
	}
}
