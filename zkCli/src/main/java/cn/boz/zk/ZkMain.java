package cn.boz.zk;

import java.io.IOException;
import java.util.UUID;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZkMain {

	ZooKeeper zooKeeper;
	Watcher watcher = new Watcher() {
		@Override
		public void process(WatchedEvent event) {
			System.out.println("------events------");
			System.out.println(event.toString());
			EventType type = event.getType();
			if (EventType.NodeChildrenChanged.equals(type)) {
				//getChildren
				// 子改变
			} else if (EventType.NodeDataChanged.equals(type)) {
				//getData
				// 数据变
			} else if (EventType.NodeCreated.equals(type)) {
				//exist
				// 节点创建
			} else if (EventType.NodeDeleted.equals(type)) {
				//exist
				// 节点挂掉
			} else if (EventType.None.equals(type)) {
				// 启动事件
			}
			System.out.println("------events------");
		}
	};

	public void createInstance() throws IOException {
		zooKeeper = new ZooKeeper("0.0.0.0:2181", 30000, watcher);
	}

	public void start() {
		try {
			createInstance();
			UUID uuid = UUID.randomUUID();
			String pnode="true";
			/**
			 * 在exist上注册事件，只有当这个节点不exists了之后，才会被删除
			 */
			Stat stat = zooKeeper.exists("/"+pnode,true);
			if (stat == null) {
				String rst = zooKeeper.create("/"+pnode, "RandomList".getBytes(), Ids.OPEN_ACL_UNSAFE,
						CreateMode.PERSISTENT);
				System.out.println(rst);
			}
			String rst = zooKeeper.create("/"+pnode+"/" + uuid.toString(), "testRootData".getBytes(), Ids.OPEN_ACL_UNSAFE,
					CreateMode.PERSISTENT);
			zooKeeper.create("/"+pnode+"/" + uuid.toString() + "/testChild", "ChildData".getBytes(), Ids.OPEN_ACL_UNSAFE,
					CreateMode.PERSISTENT);

			System.out.println(rst);
			
			//监听pnode 的变化
			byte[] dat = zooKeeper.getData("/"+pnode+"/", true, null);
			System.out.println(new String(dat,"UTF-8"));

			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
//			try {
//				zooKeeper.close();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}

	public void close() throws InterruptedException {
		zooKeeper.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new ZkMain().start();
		Thread.sleep(Long.MAX_VALUE);
	}

};
