package edu.song.elasticsearch.client;

import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ESConfig {
    private static final Logger LOG = LoggerFactory.getLogger(ESConfig.class);
    
    private final static String ESCONNECT_PROPERTIES = "esconnect.properties";
    
    public static String clusterName = "Song";
    public static String clientModel = "TRANSPORT";
    public static String host1 = "10.10.103.106";
    public static String host2 = "10.10.103.106";
    public static String host3 = "10.10.103.106";
    public static int port = 9300;
    public static String apmindex = "apm_";
    public static String zeromqAddress = "tcp://127.0.0.1:6669";
    public static int timeInterval = 60;
    public static boolean useCache = true;
    
    public static String clusterNameAnother = "CFLog";
    public static String hostAnother = "10.10.102.82";
    
    public static void init() throws Exception {
        LOG.info("Reading configuration:" + ESCONNECT_PROPERTIES);
        InputStream in = ESConfig.class.getClassLoader().getResourceAsStream(ESCONNECT_PROPERTIES);
        Properties props = new Properties();
        try {
            props.load(in);
        } finally {
            in.close();
        }
        clusterName = props.getProperty("clustername");
        clientModel = props.getProperty("clientModel");
        host1 = props.getProperty("host1");
        host2 = props.getProperty("host2");
        host3 = props.getProperty("host3");
        port = Integer.parseInt(props.getProperty("port"));
        apmindex = props.getProperty("apmindex");
        zeromqAddress = props.getProperty("zeromqAddress");
        timeInterval = Integer.parseInt(props.getProperty("timeInterval"));
        useCache = Boolean.parseBoolean(props.getProperty("useCache"));
        
        hostAnother = props.getProperty("hostAnother");
        clusterNameAnother = props.getProperty("clusterNameAnother");
    }
}