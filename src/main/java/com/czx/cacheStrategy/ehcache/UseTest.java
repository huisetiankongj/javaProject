package com.czx.cacheStrategy.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.junit.Before;
import org.junit.Test;

public class UseTest {

	public static CacheManager cacheManager ;
	
	@Before
	public void preGen(){
		cacheManager = CacheManager.create(this.getClass().getResource("/ehcache-listener.xml"));  
	}
	
	@Test
	public void getEhcache(){
		cacheManager.addCache("USER");
		Cache cache = cacheManager.getCache("USER");
		Element element = new Element("kk", "czx");
		cache.put(element);
		System.out.println(cacheManager.getCache("USER").get("kk").getObjectValue());
	}
	
	@Test
	public void listener(){
	   cacheManager.addCache("test1");  
	   cacheManager.removeCache("test1");  
	}
	
	
	
}
