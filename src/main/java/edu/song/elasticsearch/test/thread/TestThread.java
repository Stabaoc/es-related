package edu.song.elasticsearch.test.thread;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.internal.Nullable;

import edu.song.elasticsearch.client.ConnectES;

public class TestThread<T extends TestThread<T>> extends Thread{
	private static Client client = ConnectES.instance().getClient();
	private String name;
	private String indexName = "bill";
	private String typeName = "sbc";
	private int size = 100000;
	private int from = 0;
	private int count = 10000000;
	private boolean idEnable = true;

	@Nullable
	private String router;

	public TestThread(String name) {
		this.name = name;
	}
	public TestThread(String name,String indexName){
		this.name = name;
		this.indexName = indexName;
	}

	/**
	 * 设置路由值
	 * @param router
	 * @return
	 */
	public T router(String router) {
		this.router = router;
		return (T) this;
	}

	/**
	 * 设置批量大小
	 * @param size
	 * @return
	 */
	public T size(int size) {
		this.size = size;
		return (T) this;
	}

	/**
	 * 设置总插入的doc数
	 * @param count
	 * @return
	 */
	public T count(int count){
		this.count = count;
		return (T) this;
	}
	
	/**
	 * bill account_num起始值
	 * @param from
	 * @return
	 */
	public T from(int from) {
		this.from = from;
		return (T) this;
	}

	/**
	 * 使用启用account_num作为doc id
	 * @param disable
	 * @return
	 */
	public T idEnable(boolean disable) {
		this.idEnable = false;
		return (T) this;
	}
}
