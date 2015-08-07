package edu.song.elasticsearch.client;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.NodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectESAnother {
	private static final Logger logger = LoggerFactory.getLogger(ConnectES.class);
	private static ConnectESAnother connectESAnother = null;
	private Client client = null;
	private List<String> list = Collections.emptyList();
	
	private ConnectESAnother(){
	    list = Arrays.asList(ESConfig.hostAnother);
        
		if(client==null){
			if("NODE".equals(ESConfig.clientModel)){
				client = NodeBuilder.nodeBuilder().clusterName(ESConfig.clusterNameAnother).client(true).node().client();
			} else if("TRANSPORT".equals(ESConfig.clientModel)){
				client= new TransportClient(ImmutableSettings.settingsBuilder().put("cluster.name", ESConfig.clusterNameAnother).build())
					.addTransportAddress(new InetSocketTransportAddress(ESConfig.hostAnother, ESConfig.port));
			} else {
				logger.warn("clientModel doesn't exist !");
			}
			logger.debug("client establish !");
		}
	}
	
	public static ConnectESAnother instance(){
		if(connectESAnother == null) {
			connectESAnother = new ConnectESAnother();
		}
		return connectESAnother;
	}
	
	public Client getClient(){
		return this.client;
	}
}
