package org.techism.monitoring.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techism.monitoring.domain.PageCheck;
import org.techism.monitoring.domain.PageCheckRepository;
import org.techism.monitoring.domain.PageStatus;


@Service
public class PageCheckService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PageCheckService.class);
	
	@Autowired
	PageCheckRepository repository;
	
	@Autowired
	HtmlCleaner htmlCleaner;
	
	public List<PageCheck> getStatus (){
		List<PageCheck> pages = repository.findAll();
		return pages;
	}
	
	public String check(){
		List<PageCheck> pages = repository.findAll();
		pages.parallelStream().forEach(page -> checkSinglePage(page));
		return "done";
	}
	
	
	private void checkSinglePage (PageCheck pagecheck){
		try {
			Connection connection = Jsoup.connect(pagecheck.getCheckUrl());
			connection.timeout(1000);
			Document doc = connection.get();
			String cleanedHtml = htmlCleaner.cleanHtml(doc, pagecheck.getCheckUrl());
			String newHash = calculateHash(cleanedHtml);
			pagecheck.setLastCheck(LocalDateTime.now());
			if (newHash != pagecheck.getHash()){
				pagecheck.setHash(newHash);
				pagecheck.setStatus(PageStatus.CHANGED);
			}
			
			// TODO save pageCheck
		} catch (Exception exception){
			LOGGER.info(pagecheck.getCheckUrl() + "  throws exception: " + exception);
			pagecheck.setStatus(PageStatus.UNAVAILABLE);
		}
	}
	
	private String calculateHash (String htmlBody){
		byte [] hashValue = DigestUtils.md5(htmlBody);
		return new String (hashValue);
	}

}
