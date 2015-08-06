package edu.song.elasticsearch.test.thread;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import edu.song.elasticsearch.client.ConnectES;

public class QueryTestThread extends Thread{
	private static Client client = ConnectES.instance().getClient();
	private String name; 
	private int num;
	public QueryTestThread(String name){
		this.name = name;
	}
	public QueryTestThread(String name,int num){
		this.name = name;
		this.num = num;
	}
	
	public void query(int num){
		QueryBuilder match_all = QueryBuilders.matchAllQuery();
		
		SearchResponse search = client.prepareSearch("billtest")
				.setTypes("sbc")
				.setQuery(match_all)
				.setSize(10)
				.execute().actionGet();
		
		System.out.println(name + "No." + num + "  ##Took: " + search.getTookInMillis());
		
	}
	
	@Override
	public void run() {
		
		for(int i = 0; ;i++)
		{
			query(i++);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		QueryTestThread esQuery = new QueryTestThread("Query");
		esQuery.start();
	}
}
