package edu.song.elasticsearch.test.thread;

import java.util.List;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.internal.Nullable;

import edu.song.elasticsearch.client.ConnectES;
import edu.song.elasticsearch.related.data.BillDataMock;
import edu.song.elasticsearch.related.data.bean.Bill;

public class BulkTestThread extends Thread {
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

	public BulkTestThread(String name) {
		this.name = name;
	}
	public BulkTestThread(String name,String indexName){
		this.name = name;
		this.indexName = indexName;
	}

	/**
	 * 设置路由值
	 * @param router
	 * @return
	 */
	public BulkTestThread router(String router) {
		this.router = router;
		return this;
	}

	/**
	 * 设置批量大小
	 * @param size
	 * @return
	 */
	public BulkTestThread size(int size) {
		this.size = size;
		return this;
	}

	/**
	 * 设置总插入的doc数
	 * @param count
	 * @return
	 */
	public BulkTestThread count(int count){
		this.count = count;
		return this;
	}
	
	/**
	 * bill account_num起始值
	 * @param from
	 * @return
	 */
	public BulkTestThread from(int from) {
		this.from = from;
		return this;
	}

	/**
	 * 使用启用account_num作为doc id
	 * @param disable
	 * @return
	 */
	public BulkTestThread idEnable(boolean disable) {
		this.idEnable = false;
		return this;
	}

	/**
	 * 执行批量处理的主体
	 */
	private void bulk() {
		long totalMock = 0l;
		long totalAll = 0l;
		long totalTook = 0l;
		for (;from<count; from += size) {

			long mock = System.currentTimeMillis();
			System.out.println(name + "-" + from + "##Mock: " + mock);
			BulkRequestBuilder bulkRequest = client.prepareBulk();
			List<Bill> billList = BillDataMock.Mock(size, from);
			long start = System.currentTimeMillis();
			System.out.println(name + "-" + from + "##Start: " + start);
			for (Bill bill : billList) {
				Integer id = bill.getAccount_number();
				IndexRequest indexRequest;

				if (idEnable)
					indexRequest = new IndexRequest(indexName, typeName, id.toString()).source(bill.toJson())
							.routing(router);
				else
					indexRequest = new IndexRequest(indexName, typeName).source(bill.toJson()).routing(router);

				bulkRequest.add(indexRequest);
			}
			BulkResponse bulkResponse = bulkRequest.execute().actionGet();
			if (bulkResponse.hasFailures()) {
				System.out.println("bulk error");
			}
			long end = System.currentTimeMillis();
			System.out.println(name + "-" + from + "##End: " + end);
			System.out.println(name + "-" + from + "##Took: " + bulkResponse.getTookInMillis());
			long mockTime = start - mock;
			long allTime = end - start;
			totalMock += mockTime;
			totalAll += allTime;
			totalTook += bulkResponse.getTookInMillis();
			int number = from+size;
			double avgMock = (from+size)/totalMock;
			double avgTook = 1.0 * totalTook/number;
			double avgAll = 1.0 * totalAll/number;

			System.out.println(number);
			System.out.println(name + "-" + from + "####mock: " + mockTime + " ####all: " + allTime + " ####took: "
					+ bulkResponse.getTookInMillis());
			System.out.println(name + "-" + from + "####avgM: " + avgMock + " ####avgA: " + avgAll + " ####avgT: "
					+ avgTook);
			System.out.println("**totalMock: " + totalMock + "**totalAll: " + totalAll + "**totalTook: "  + totalTook);
		}
		System.out.println("**totalMock: " + totalMock + "**totalAll: " + totalAll + "**totalTook: "  + totalTook);
	}

	public void bulk2() {
		long totalMock = 0l;
		long totalAll = 0l;
		long totalTook = 0l;
		for (;from<50000000;from += size) {

			long mock = System.currentTimeMillis();
			System.out.println(name + "-" + from + "##Mock: " + mock);
			BulkRequestBuilder bulkRequest = client.prepareBulk();
			List<Bill> billList = BillDataMock.Mock(size, from);
			System.out.println(billList.size() + "    " + from);
			long start = System.currentTimeMillis();
			System.out.println(name + "-" + from + "##Start: " + start);
			for (Bill bill : billList) {
				Integer id = bill.getAccount_number();
				IndexRequest indexRequest = new IndexRequest("bill_doc", "sbc", id.toString()).source(bill.toJson())
						.routing(router);
				IndexRequest indexRequest2 = new IndexRequest("bil_not", "sbc", id.toString()).source(bill.toJson())
						.routing(router);
				bulkRequest.add(indexRequest);
				bulkRequest.add(indexRequest2);
			}
			BulkResponse bulkResponse = bulkRequest.execute().actionGet();
			if (bulkResponse.hasFailures()) {
				System.out.println("bulk error");
			}
			long end = System.currentTimeMillis();
			System.out.println(name + "-" + from + "##End: " + end);
			System.out.println(name + "-" + from + "##Took: " + bulkResponse.getTookInMillis());
			long mockTime = start - mock;
			long allTime = end - start;
			totalMock += mockTime;
			totalAll += allTime;
			totalTook += bulkResponse.getTookInMillis();
			double avgMock = (from+100000)/totalMock;
			double avgTook = 0.5 * totalTook / (from + 100000);
			double avgAll = 0.5 * totalAll / (from + 100000);
			System.out.println(name + "-" + from + "####mock: " + mockTime + " ####all: " + allTime + " ####took: "
					+ bulkResponse.getTookInMillis());
			System.out.println(name + "-" + from + "####avgM: " + avgMock + " ####avgA: " + avgAll + " ####avgT: "
					+ avgTook);
		}
	}

	@Override
	public void run() {
		bulk();
	}

	public static void main(String[] args) {
		BulkTestThread esBulk = new BulkTestThread("test","bill_test52").size(500000).count(100000000);
		esBulk.start();
	}
}
