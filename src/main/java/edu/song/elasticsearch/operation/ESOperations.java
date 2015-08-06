package edu.song.elasticsearch.operation;

import org.elasticsearch.action.admin.indices.optimize.OptimizeRequest;
import org.elasticsearch.action.admin.indices.optimize.OptimizeResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;

import edu.song.elasticsearch.client.ConnectES;

public class ESOperations {
	static Client client = ConnectES.instance().getClient();
	
	public static void optimize(){
		OptimizeRequest optimizeRequest = new OptimizeRequest();
		IndexRequest indexRequest = new IndexRequest(optimizeRequest);
		IndexResponse optimizeResponse = client.index(indexRequest).actionGet();
		
		System.out.println(optimizeResponse.contextSize());
	}
	
	public static void main(String[] args) {
		optimize();
	}
}
