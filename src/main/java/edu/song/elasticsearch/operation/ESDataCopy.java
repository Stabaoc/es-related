package edu.song.elasticsearch.operation;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import edu.song.elasticsearch.client.ConnectES;
import edu.song.elasticsearch.client.ConnectESAnother;

public class ESDataCopy {
	static Client client = ConnectES.instance().getClient();
	static Client clientAnother = ConnectESAnother.instance().getClient();
	
	enum Type{
		DBType,JavaAppData,RelationShip,RelationShipMonit,RelationShipMonitOld
	}
	public static void copy(){
		for(int i = 0;i<Type.values().length;i++){
			String type = Type.values()[i].toString();
			
			SearchResponse hitsNumSearch = clientAnother.prepareSearch("apm_121.40.159.7")
					.setTypes(type)
					.execute().actionGet();
			System.out.println(hitsNumSearch);
			int hitsNum =  (int) hitsNumSearch.getHits().getTotalHits();
			System.out.println(hitsNum);
			//Scroll scroll = 
			SearchResponse search = clientAnother.prepareSearch("apm_121.40.159.7")
					.setTypes(type).setSize(hitsNum)//.setScroll(scroll)
					.execute().actionGet();
			
			SearchHits hits = search.getHits();
			BulkRequestBuilder bulk = client.prepareBulk();
			for(SearchHit hit:hits)
			{
				IndexRequest index = new IndexRequest("apm_121.40.159.7", type).source(hit.getSource());
				bulk.add(index);
			}
			BulkResponse bulkResponse = bulk.execute().actionGet();
			if (bulkResponse.hasFailures()) {
				System.out.println("bulk error");
			}
			System.out.println(bulkResponse.getTook());
		}
		
	}
	
	public static void main(String[] args) {
		copy();
	}
}
