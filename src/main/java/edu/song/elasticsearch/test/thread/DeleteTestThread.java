package edu.song.elasticsearch.test.thread;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.Client;

import edu.song.elasticsearch.client.ConnectES;

public class DeleteTestThread extends Thread{
	private static Client client = ConnectES.instance().getClient();
	private String name; 
	private int num;
	public DeleteTestThread(String name){
		this.name = name;
	}
	public DeleteTestThread(String name,int num){
		this.name = name;
		this.num = num;
	}
	
	public void delete(int num){
		//QueryBuilder match_all = QueryBuilders.matchAllQuery();
		Integer id = num;
		DeleteResponse delete = client.prepareDelete("billtest", "sbc", id.toString())
		        .execute()
		        .actionGet();
		
		System.out.println(name + "No." + num + "  ##Took: " + delete.getId());
	}
	
	@Override
	public void run() {
		
		for(int i = 800; ;i++)
		{
			delete(i);
		}
	}
	public static void main(String[] args) {
		DeleteTestThread esDelete = new DeleteTestThread("Delete");
		esDelete.start();
	}
}
