package com.itheima.solr;

import java.io.IOException;
import java.util.Calendar;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrTest {
	
	@Test
	public void addDoc() throws Exception, IOException{
		SolrServer solrServer =new HttpSolrServer("http://localhost:8080/solr/");
		SolrInputDocument document =new SolrInputDocument();
		document.addField("id", 002);
		//更新修改是在要修改的id的技术上直接增加即可
		document.addField("title", "测试002");
		document.addField("content", "测试内容002");
		solrServer.add(document);
		//提交
		solrServer.commit();
	}
	
	@Test
	public void testDelete() throws Exception, IOException{
		SolrServer solrServer =new HttpSolrServer("http://localhost:8080/solr/");
		//根据id删除
	//	solrServer.deleteById("1");
		//根据query进行查询
		solrServer.deleteByQuery("id:2");
		//提交
		solrServer.commit();
	}
}
