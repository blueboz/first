package cn.boz.nettystd.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyDao {

	public static NettyDao nettyDao;

	public static NettyDao getInst() {
		if (nettyDao == null) {
			nettyDao = new NettyDao();
		}
		return nettyDao;
	}

	private Logger logger = LoggerFactory.getLogger(NettyDao.class);

	public void sayLog() {
		logger.trace("---TRACE---");
		logger.info("---INFO---");
		logger.debug("---DEBUG---");
		logger.warn("---WARN---");
		logger.error("---ERROR---");;
	}
}
