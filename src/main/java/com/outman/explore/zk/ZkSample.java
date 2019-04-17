package com.outman.explore.zk;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

public class ZkSample {

	public static void main(String[] args) {
		ZkClient zkClient = new ZkClient("127.0.0.1:2181", 5000);
		zkClient.setZkSerializer(new MyZkSerializer());
		zkClient.subscribeDataChanges("/", new IZkDataListener() {
			@Override
			public void handleDataChange(String dataPath, Object data) throws Exception {
				System.out.println("Node:" + dataPath + " changed, new data:" + data);
			}

			@Override
			public void handleDataDeleted(String dataPath) throws Exception {
				System.out.println("Node:" + dataPath + "deleted");
			}
		});
		
		try {
			Thread.currentThread().sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
