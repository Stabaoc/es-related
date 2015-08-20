package edu.song.elasticsearch.test.thread;

public class IndexTestThread extends Thread{
	private TestThreadConfig config = new TestThreadConfig();
	
	public IndexTestThread(TestThreadConfig config){
		this.config = config;
	}
}
