package edu.song.elasticsearch.search;

import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.xml.FilterBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolFilterBuilder;
import org.elasticsearch.index.query.ExistsFilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeFilterBuilder;
import org.elasticsearch.index.query.TermFilterBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket;
import org.elasticsearch.search.aggregations.metrics.cardinality.Cardinality;
import org.elasticsearch.search.aggregations.metrics.cardinality.CardinalityBuilder;
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
	
	public static void termAgg(){
		QueryBuilder query = QueryBuilders.termQuery("serverUrl", "/jeeshopclient/user/editAddress.html");
		AggregationBuilder<?> termAgg = AggregationBuilders.terms("serviceIds").field("messageType");
		
		SearchResponse searchResponse = client.prepareSearch("apm_121.40.159.7")
				.setTypes("JavaAppData")
				.setQuery(query)
				.addAggregation(termAgg)
				.execute().actionGet();
		
		System.out.println(searchResponse);
	}
	
	public static void getMessageId() {
		TermFilterBuilder messageIdFilter = FilterBuilders.termFilter("messageId", 0);
		RangeFilterBuilder tiemFilter = FilterBuilders.rangeFilter("startTime").from("2015-09-06 10:00:00");
		BoolFilterBuilder boolFilter = FilterBuilders.boolFilter().mustNot(messageIdFilter).must(tiemFilter);
		QueryBuilder query = QueryBuilders.filteredQuery(null, boolFilter);
		AggregationBuilder<?> termAgg = AggregationBuilders.terms("transactionIds").field("transactionId").size(0)
				.subAggregation(AggregationBuilders.terms("spanIds").field("spanId")
						.subAggregation(AggregationBuilders.terms("messageIds").field("messageId")));
		
		SearchResponse searchResponse = client.prepareSearch("apm_121.40.159.7")
				.setTypes("JavaAppData")
				.setQuery(query)
				.addAggregation(termAgg)
				.execute().actionGet();
		
		Terms transactionIds = searchResponse.getAggregations().get("transactionIds");
		for(Bucket transactionIdBucket:transactionIds.getBuckets()){
			Terms spanIds = transactionIdBucket.getAggregations().get("spanIds");
			for(Bucket spanIdBucket:spanIds.getBuckets()){
				Terms messageIds = spanIdBucket.getAggregations().get("messageIds");
				for(Bucket messageIdBucket:messageIds.getBuckets()){
					if(messageIdBucket.getDocCount() > 1)
						System.out.println("Error:" + "transactionId: " + transactionIdBucket.getKey() + 
								",spanId: " + spanIdBucket.getKey() + "  " + spanIdBucket.getDocCount() + "  " +
								messageIdBucket.getDocCount());
//					else
//						System.out.println("  " + "transactionId: " + transactionIdBucket.getKey() + 
//								",spanId: " + spanIdBucket.getKey() + "  " + spanIdBucket.getDocCount() + "  " +
//								messageIdBucket.getDocCount());
				}
			}
		}
	}
	
	public static void searchDbGtTotal() {
		ExistsFilterBuilder exist = FilterBuilders.existsFilter("timestamp");
		QueryBuilder matchAll = QueryBuilders.matchAllQuery();
		
		QueryBuilder query = QueryBuilders.filteredQuery(matchAll, exist);
		
		SearchResponse searchResponse = client.prepareSearch("apm_121.40.159.7")
				.setTypes("Response")
				.setQuery(query)
				.setSize(1000000)
				.execute().actionGet();
		
		for(SearchHit hit:searchResponse.getHits()){
			Number db = (Number) hit.getSource().get("dbTime");
			Number total = (Number) hit.getSource().get("totalTime");
			if(db.longValue() > total.longValue())
				System.out.println(hit.getSource());
		}
	}
	
	public static void main(String[] args) {
        //Bootstrap.main(args);
		//termAgg();
		//getMessageId();
		searchDbGtTotal();
	}
}
