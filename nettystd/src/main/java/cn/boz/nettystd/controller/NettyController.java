package cn.boz.nettystd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyController {

	public static NettyController nettyController;

	public static NettyController getInst() {
		if (nettyController == null) {
			nettyController = new NettyController();
		}
		return nettyController;
	}

	private Logger logger = LoggerFactory.getLogger(NettyController.class);

	public void sayLog() {
		logger.trace("---TRACE---");
		logger.info("---INFO---");
		logger.debug("---DEBUG---");
		logger.warn("---WARN---");
		logger.error("---ERROR---");
	}
}
