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
	private boolean idEnable = true;

	@Nullable
	private String router;

	public BulkTestThread(String name) {
		this.name = name;
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
		for (;; from += size) {

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
			System.out.println(name + "-" + from + "####mock: " + mockTime + " ####all: " + allTime + " ####took: "
					+ bulkResponse.getTookInMillis());
		}
	}

	public void bulk2() {
		for (;; from += size) {

			long mock = System.currentTimeMillis();
			System.out.println(name + "-" + from + "##Mock: " + mock);
			BulkRequestBuilder bulkRequest = client.prepareBulk();
			List<Bill> billList = BillDataMock.Mock(size, from);
			System.out.println(billList.size() + "    " + from);
			long start = System.currentTimeMillis();
			System.out.println(name + "-" + from + "##Start: " + start);
			for (Bill bill : billList) {
				Integer id = bill.getAccount_number();
				IndexRequest indexRequest = new IndexRequest("billdoc", "sbc", id.toString()).source(bill.toJson())
						.routing(router);
				IndexRequest indexRequest2 = new IndexRequest("bilnot", "sbc", id.toString()).source(bill.toJson())
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
			System.out.println(name + "-" + from + "####mock: " + mockTime + " ####all: " + allTime + " ####took: "
					+ bulkResponse.getTookInMillis());
		}
	}

	@Override
	public void run() {
		bulk2();
	}

	public static void main(String[] args) {
		BulkTestThread esBulk = new BulkTestThread("test");
		esBulk.start();
	}
}
