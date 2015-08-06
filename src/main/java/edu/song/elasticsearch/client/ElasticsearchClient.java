package edu.song.elasticsearch.client;

import java.util.Map;

import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Client;

/**
 * @author stab  2015年 04月 22日 星期三
 */
public class ElasticsearchClient {
    private static Client client = ConnectES.instance().getClient();
    private static BulkProcessor esBulkProcessor = new ESBulkProcessor().getEsBulkProcessor();
    private static BulkRequestBuilder bulkRequest = client.prepareBulk();
    
    public static final String TYPE_JAVA = "JavaAppData";
    public static final String TYPE_RELATIONSHIP = "RelationShip";
    public static final String TYPE_RELATIONSHIPMONIT = "RelationShipMonit";
    public static final String TYPE_RELATIONSHIPMONITOLD = "RelationShipMonitOld";
    public static final String TYPE_DB = "DBType";
    
    /**
     * 新增记录
     * 
     * @param jsonLog log in json
     */
    /*public static void uploadApmData(String ip, String type, Map<String, Object> jsonLog){
        //设置读取标识位为未读
        if(TYPE_JAVA.equals(type)) {
            jsonLog.put("readFlag", 0);
        } else if(TYPE_RELATIONSHIPMONIT.equals(type)) {
            //原始数据备份一份
            uploadESData(jsonLog, TYPE_RELATIONSHIPMONITOLD, ESConfig.apmindex + ip);
            
            //src和dst的podIp转serviceIp
            if(jsonLog.containsKey("dst")) {
                String dst = (String)jsonLog.get("dst");
                String dstServiceIp = DockUtil.getServiceIpFromCache(dst, ip);
                if(dstServiceIp != null) {
                    jsonLog.put("dst", dstServiceIp);
                }
            }
            if(jsonLog.containsKey("agentId")) {
                String src = (String)jsonLog.get("agentId");
                String srcServiceIp = DockUtil.getServiceIpFromCache(src, ip);
                if(srcServiceIp != null) {
                    jsonLog.put("agentId", srcServiceIp);
                }
            }
            uploadESData(jsonLog, type, ESConfig.apmindex + ip);
        }
        uploadESData(jsonLog, type, ESConfig.apmindex + ip);
    }*/
    
    /**
     * 新增RelationShip记录
     * 
     * @param jsonLog
     */
    public static void uploadRelationShip(Map<String, Object> jsonLog, String ip) {
        uploadESData(jsonLog, TYPE_RELATIONSHIP, ESConfig.apmindex + ip);
    }
    
    /**
     * 新增DBType记录
     * 
     * @param jsonLog
     */
    public static void uploadDBType(Map<String, Object> jsonLog, String ip) {
        uploadESData(jsonLog, TYPE_DB, ESConfig.apmindex + ip);
    }
    
    /**
     * @param jsonLog log in json
     * @param type elasticsearch type
     * @param index elasticsearch index
     */
    public static void uploadESData(Map<String, Object> jsonLog, String type, String indexName) {
        client.prepareIndex(indexName, type)
              .setSource(jsonLog)
              .execute()
              .actionGet();
    }
    
    public static SearchRequestBuilder prepareJavaSearch(String index) {
        return ConnectES.instance().getClient().prepareSearch(index).setTypes(TYPE_JAVA);
    }
    
    /**
     * 缓冲一定数据后，再自动插入
     *
     * @param jsonLog log in json
     */
    public static void bulkApmLog(Map<String, Object> jsonLog, String type, String indexName){
        IndexRequest indexRequest = new IndexRequest(indexName, type).source(jsonLog);
        esBulkProcessor.add(indexRequest); 
    }
    
    /**
     * 缓冲一定数据
     */
    public static void bulkManually(Map<String, Object> jsonLog, String type, String indexName){

    	bulkRequest.add(client.prepareIndex(indexName, type).setSource(jsonLog));

    	
    }
    
    /**
     * 手动插入缓冲数据
     */
    public static void bulkManuallyExecute(){
    	BulkResponse bulkResponse = bulkRequest.execute().actionGet();
    	if (bulkResponse.hasFailures()) {
    	    // process failures by iterating through each bulk response item
    	}
    }
    
    /**
     * 更新JavaAppData 读取状态
     * 
     * @param id
     * @param flag
     */
    public static void updateJavaAppFlag(String ip, String id, int flag) {
        client.prepareUpdate(ESConfig.apmindex + ip, TYPE_JAVA, id)
            .setDoc("readFlag", flag)
            .get();
    }
}
