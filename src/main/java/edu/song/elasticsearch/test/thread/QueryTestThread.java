package edu.song.elasticsearch.test.thread;

import javax.management.Query;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;

import edu.song.elasticsearch.client.ConnectES;

public class QueryTestThread extends Thread {
	private static Client client = ConnectES.instance().getClient();
	private String name;
	private String indexName = "billdoc";
	private String typeName = "sbc";
	private int num = 0;
	private int size = 50;
	private int sleepTime = 1000;

	public QueryTestThread(String name) {
		this.name = name;
	}

	public QueryTestThread(String name, String indexName) {
		this.name = name;
		this.indexName = indexName;
	}

	/**
	 * 设置休眠时间
	 * 
	 * @param sleepTime
	 * @return
	 */
	public QueryTestThread sleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
		return this;
	}

	/**
	 * 设置查询显示hit的数量
	 * 
	 * @param size
	 * @return
	 */
	public QueryTestThread size(int size) {
		this.size = size;
		return this;
	}

	/**
	 * 执行查询主体
	 */
	public long query() {
		
		QueryBuilder match_all = QueryBuilders.matchAllQuery();

		SearchResponse search = client.prepareSearch(indexName).setTypes(typeName).setQuery(match_all).setSize(50)
				.execute().actionGet();

		System.out.println(name + "No." + num + "  ##Took: " + search.getTookInMillis());
		num++;
		
		return search.getTookInMillis();
	}

	/**
	 * 执行聚合主体
	 */
	public void agg() {
		long totalTook = 0l;
		for (int i = 1; i < 10000; i++) {
			AggregationBuilder<?> aggs = AggregationBuilders.terms("states").field("state");

			SearchResponse search = client.prepareSearch(indexName).setTypes(typeName).addAggregation(aggs).setSize(0)
					.execute().actionGet();
			totalTook += search.getTookInMillis();
			long avgTook = totalTook/i;
			System.out.println(search);
			System.out.println(indexName);
			System.out.println(name + "No." + i + "  ##Took: " + search.getTookInMillis() + "  ##Avg: " + avgTook);
			
		}
	}

	@Override
	public void run() {
		long totalTook = 0l;
		for(int i=1;i<10000;i++)
		{	
			totalTook += query();
			long avgTook = totalTook/i;
			System.out.println("##avg: " + avgTook );
			try {
				sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		QueryTestThread esDoc = new QueryTestThread("doc").sleepTime(1000);
		esDoc.start();
		//QueryTestThread esNotDoc = new QueryTestThread("notDoc","bilnot");
		//esNotDoc.start();
		//esDoc.agg();
		//esNotDoc.agg();
	}
}
