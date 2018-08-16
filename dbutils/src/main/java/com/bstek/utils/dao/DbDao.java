package com.bstek.utils.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

public class DbDao {

	private DruidDataSource dataSource;
	private QueryRunner queryRunner;

	@SuppressWarnings("resource")
	private void connect(Map<String, Object> map) throws SQLException {
		// 初始化基础信息
		dataSource = new DruidDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@192.168.187.132:1521:orcl");
		dataSource.setUsername("sdbf");
		dataSource.setPassword("sdbf");
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setMaxActive(303);
		dataSource.setMinIdle(100);
		queryRunner = new QueryRunner(dataSource);
		List<DruidPooledConnection> conns = new ArrayList<DruidPooledConnection>();

		for (int i = 0; i < 83; i++) {
			String sb=getDataSourceInfoStr(dataSource);
			System.out.println(sb);
			DruidPooledConnection conn = dataSource.getConnection();
			conns.add(conn);
		}
		for (DruidPooledConnection conn : conns) {
			//conn.commit();
			conn.close();
			String sb=getDataSourceInfoStr(dataSource);
			System.out.println(sb);
		}
		
		while(true) {
			try {
				Thread.sleep(2000);
				System.out.println(getDataSourceInfoStr(dataSource));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	public String getDataSourceInfoStr(DruidDataSource dataSource) {
		StringBuilder sb = new StringBuilder();
		sb.append(dataSource.getActiveCount());
		sb.append(":"+dataSource.getConnectCount());
		sb.append(":"+dataSource.getMaxActive());
		sb.append(":"+dataSource.getActivePeak());
		sb.append(":"+dataSource.getInitialSize());
		sb.append(":"+dataSource.getQueryTimeout()+"ms");
		sb.append(":"+dataSource.getMinIdle());
		sb.append(":"+dataSource.getMaxIdle());
		sb.append(":"+dataSource.getCommitCount());
		sb.append(":"+dataSource.getCreateCount());
		sb.append(":"+dataSource.getPoolingCount());
		sb.append(":"+dataSource.getRecycleCount());

		return sb.toString();
	}

	public Map<String, Object> getDataSourceInfo(DruidDataSource dataSource) {
		Map<String, Object> map = new HashMap<String, Object>();

		int activeCount = dataSource.getActiveCount();

		int activePeak = dataSource.getActivePeak();

		long connectCount = dataSource.getConnectCount();

		long executeCount = dataSource.getExecuteCount();

		long cachedPreparedStatementCount = dataSource.getCachedPreparedStatementCount();
		long commitCount = dataSource.getCommitCount();
		long destroyCount = dataSource.getDestroyCount();
		long createCount = dataSource.getCreateCount();
		long discardCount = dataSource.getDiscardCount();
		long errorCount = dataSource.getErrorCount();

		int initialSize = dataSource.getInitialSize();
		int maxPoolPreparedStatementPerConnectionSize = dataSource.getMaxPoolPreparedStatementPerConnectionSize();
		int maxActive = dataSource.getMaxActive();
		int maxCreateTaskCount = dataSource.getMaxCreateTaskCount();
		int maxIdle = dataSource.getMaxIdle();
		int minIdle = dataSource.getMinIdle();
		int maxOpenPreparedStatements = dataSource.getMaxOpenPreparedStatements();
		long maxWait = dataSource.getMaxWait();
		int maxWaitThreadCount = dataSource.getMaxWaitThreadCount();
		int poolingCount = dataSource.getPoolingCount();
		int poolingPeak = dataSource.getPoolingPeak();
		int queryTimeout = dataSource.getQueryTimeout();
		int validationQueryTimeout = dataSource.getValidationQueryTimeout();

		return null;
	}

	@Test
	public void test() {
		DbDao dbDao = new DbDao();
		try {
			dbDao.connect(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
