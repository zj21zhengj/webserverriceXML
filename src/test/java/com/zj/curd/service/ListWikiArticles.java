package com.zj.curd.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.zj.curd.dao.WikiArticlesDao;
import com.zj.curd.dao.WikiImagesDao;
import com.zj.curd.entity.WkArticles;
import com.zj.curd.entity.WkArticlesauthor;
import com.zj.curd.entity.WkImages;
import com.zj.curd.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration("classpath:spring-context.xml")
public class ListWikiArticles {
	
	private static Logger logger = Logger.getLogger(ListWikiArticles.class); 
	@Autowired
	private WikiArticlesService wikiArticlesService;
	
	@Autowired
	private WikiImagesDao wikiImagesDao;
	
	@Autowired
	private WikiArticlesDao wikiArticlesDao;
	
	@Test
    public void wikiArticles() {
		String artId = "db8282c61e5745c1b94592e0a8cf7166";
		WkArticlesauthor wkArticlesauthor= wikiArticlesService.getWkArticle(artId);
		logger.debug("*************************000");
		logger.debug(wkArticlesauthor);
		logger.debug(wkArticlesauthor.getCreatefullName());
		
	}
	
	@Test
    public void wikiArticles2() {
		List<WkArticles> wkArticlesauthor= wikiArticlesService.hotWkArticles(0);
		logger.debug("*************************000");
		logger.debug(wkArticlesauthor);
		
	}
	
	@Test
	public void testImage() {
		String imgId = "7c222453a30c4b65710b2796ba59d66b";
		WkImages wkImagea = wikiImagesDao.getImageById(imgId);
		logger.debug(wkImagea);
		logger.debug(wkImagea != null);
	}
	
	@Test
    public void listWikiArticles() {
		Integer status = 0;
		List<String> str_qry = new ArrayList<String>();
		str_qry.add("Web");
		List<WkArticlesauthor> wkArticlesauthor= wikiArticlesDao.ListArticles(status, str_qry);
		logger.debug("*************************000");
		for(WkArticlesauthor wk : wkArticlesauthor) {
			logger.debug(wk);
		}
		
	}
	
	@Test
	public void setArticles() {
		WkArticles article = new WkArticles();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        article.setCreateTime(df.format(new Date()));
		article.setCreateUser("aa");
		System.out.println(article);
		article.setStatus(0);
		String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		article.setArtId(uuid);
		article.setMathchTimes(1);
		article.setArtTitle("abv");
		wikiArticlesService.saveWkArticle(article);
	}
}
