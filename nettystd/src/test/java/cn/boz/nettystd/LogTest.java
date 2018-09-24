package cn.boz.nettystd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import cn.boz.nettystd.controller.NettyController;
import cn.boz.nettystd.dao.NettyDao;
import cn.boz.nettystd.service.NettyService;

public class LogTest {

	public void testName() throws Exception {
		NettyDao.getInst().sayLog();
		NettyService.getInst().sayLog();
		NettyController.getInst().sayLog();
		new BufferedReader(new InputStreamReader(System.in)).readLine();
	}
}
