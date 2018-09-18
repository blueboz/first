package cn.boz.nettystd.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyService {

	public static NettyService nettyService;

	public static NettyService getInst() {
		if (nettyService == null) {
			nettyService = new NettyService();
		}
		return nettyService;
	}

	private Logger logger = LoggerFactory.getLogger(NettyService.class);

	public void sayLog() {
		logger.trace("---TRACE---");
		logger.info("---INFO---");
		logger.debug("---DEBUG---");
		logger.warn("---WARN---");
		logger.error("---ERROR---");
	}
}
