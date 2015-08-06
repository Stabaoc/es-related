package edu.song.elasticsearch.test.thread;

import java.util.List;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Client;

import edu.song.elasticsearch.client.ConnectES;
import edu.song.elasticsearch.related.data.BillDataMock;
import edu.song.elasticsearch.related.data.bean.Bill;

public class BulkDeleteTestThread extends Thread{
	private static Client client = ConnectES.instance().getClient();
	private String name; 
	private int num;
	public BulkDeleteTestThread(String name){
		this.name = name;
	}
	public BulkDeleteTestThread(String name,int num){
		this.name = name;
		this.num = num;
	}
	
	public void bulk(int num){
		BulkRequestBuilder bulkRequest = client.prepareBulk();
		long start = System.currentTimeMillis();
		System.out.println(name +"-" + num + "##Start: " + start);
		for(int i=0;i<100000;i++)
		{
			Integer id = num;
			DeleteRequest deleteRequest = new DeleteRequest("billtest", "sbc", id.toString());
			bulkRequest.add(deleteRequest);
			num++;
		}
		BulkResponse bulkResponse = bulkRequest.execute().actionGet();
		if (bulkResponse.hasFailures()) {
		    System.out.println("bulk error");
		}
		long end = System.currentTimeMillis();
		System.out.println(name +"-" + num + "##End: " + end);
		System.out.println(name +"-" + num + "##Took: " + bulkResponse.getTookInMillis());
		long allTime = end - start;
		System.out.println(name +"-" + num + " ####all: " + allTime + " ####took: " + bulkResponse.getTookInMillis());
	}
	
	
	@Override
	public void run() {
		for(int i=0;;i++)
		{
			bulk(i * 100000);
		}
	}
	public static void main(String[] args) {
		BulkDeleteTestThread esBulkDelete = new BulkDeleteTestThread("BulkDelete");
		esBulkDelete.start();
	}
}
