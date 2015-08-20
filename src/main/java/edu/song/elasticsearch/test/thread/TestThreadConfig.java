package edu.song.elasticsearch.test.thread;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.internal.Nullable;

import edu.song.elasticsearch.client.ConnectES;

public class TestThreadConfig {
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

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getIndexName() {return indexName;}
	public void setIndexName(String indexName) {this.indexName = indexName;}

	public String getTypeName() {return typeName;}
	public void setTypeName(String typeName) {this.typeName = typeName;}

	public int getSize() {return size;}
	public void setSize(int size) {this.size = size;}

	public int getFrom() {return from;}
	public void setFrom(int from) {this.from = from;}

	public int getCount() {return count;}
	public void setCount(int count) {this.count = count;}

	public boolean isIdEnable() {return idEnable;}
	public void setIdEnable(boolean idEnable) {this.idEnable = idEnable;}

	public String getRouter() {return router;}
	public void setRouter(String router) {this.router = router;}
	
	@Override
	public String toString() {
		return "{" + "\"name\":" + "\"" + name + "\"" + "," +
					 "\"indexName\":" + "\"" + indexName + "\"" + "," +
					 "\"typeName\":" + "\"" + typeName + "\"" + "," +
					 "\"size\":"  + size + "," +
					 "\"from\":"  + from + "," +
					 "\"count\":"  + count + "," +
					 "\"idEnable\":" + idEnable + "," +
					 "\"router\":" + "\"" + indexName + "\"" + "}";
	}
}
