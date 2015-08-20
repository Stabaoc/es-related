package edu.song.elasticsearch.search;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.bootstrap.Bootstrap;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.histogram.Histogram.Order;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;

import edu.song.elasticsearch.client.ConnectES;

public class SearchTest {
	private static Client client= ConnectES.instance().getClient();
	
	public static void sort(){
		//QueryBuilder bool = QueryBuilders.boolQuery()
				//.must(QueryBuilders.rangeQuery("account_number").to(172361133))
				//.must(QueryBuilders.termQuery("firstName", "Bernice"))
				;
		SortBuilder sort = SortBuilders.fieldSort("account_number").order(SortOrder.ASC);
		SearchResponse searchResponse = client.prepareSearch("billtest")
				//.setQuery(bool)
				//.addSort(sort)
				.setSize(10000000)
				.execute().actionGet();
		
		System.out.println(searchResponse.getTookInMillis());
	}
	
	
	public static void query() {
		
		SearchResponse searchResponse = client.prepareSearch("accounts")
				.addAggregation(AggregationBuilders.terms("employer").field("employer").size(1000))
				.addAggregation(AggregationBuilders.terms("address").field("address").size(1000))
				.execute().actionGet();
		
		System.out.println(searchResponse);
		
		Terms terms = searchResponse.getAggregations().get("employer");
		/*for(Bucket term:terms.getBuckets())
		{
			System.out.print(term.getKey()+",");
		}*/
		terms = searchResponse.getAggregations().get("address");
		for(Bucket term:terms.getBuckets())
		{
			System.out.print(term.getKey()+",");
		}
	}
	
	public static void main(String[] args) {
        Bootstrap.main(args);
    }
}
