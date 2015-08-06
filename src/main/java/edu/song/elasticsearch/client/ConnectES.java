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

public class ConnectES{
	private static final Logger logger = LoggerFactory.getLogger(ConnectES.class);
	private static ConnectES connectES = null;
	private Client client = null;
	private List<String> list = Collections.emptyList();
	
	private ConnectES(){
	    list = Arrays.asList(ESConfig.host1, ESConfig.host2, ESConfig.host3);
        
		if(client==null){
			if("NODE".equals(ESConfig.clientModel)){
				client = NodeBuilder.nodeBuilder().clusterName(ESConfig.clusterName).client(true).node().client();
			} else if("TRANSPORT".equals(ESConfig.clientModel)){
				client= new TransportClient(ImmutableSettings.settingsBuilder().put("cluster.name", ESConfig.clusterName).build())
					.addTransportAddress(new InetSocketTransportAddress(ESConfig.host1, ESConfig.port))
					.addTransportAddress(new InetSocketTransportAddress(ESConfig.host2, ESConfig.port))
					.addTransportAddress(new InetSocketTransportAddress(ESConfig.host3, ESConfig.port));
			} else {
				logger.warn("clientModel doesn't exist !");
			}
			logger.debug("client establish !");
		}
	}
	
	public static ConnectES instance(){
		if(connectES == null) {
			connectES = new ConnectES();
		}
		return connectES;
	}
	
	public Client getClient(){
		return this.client;
	}

    public List<String> getList() {
        return list;
    }
}
