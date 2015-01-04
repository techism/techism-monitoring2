package org.techism.monitoring.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PageCheck implements Serializable {

	private static final long serialVersionUID = 6561169268733173750L;

	@Id
    @GeneratedValue
    private Long id;
	
	private String checkUrl;
	private String clickUrl;
	private String hash;
	private LocalDateTime lastCheck;
	private PageStatus status;
	
	public String getCheckUrl() {
		return checkUrl;
	}
	
	public void setCheckUrl(String checkUrl) {
		this.checkUrl = checkUrl;
	}
	
	public String getClickUrl() {
		return clickUrl;
	}
	
	public void setClickUrl(String clickUrl) {
		this.clickUrl = clickUrl;
	}
	
	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public LocalDateTime getLastCheck() {
		return lastCheck;
	}

	public void setLastCheck(LocalDateTime lastCheck) {
		this.lastCheck = lastCheck;
	}

	public PageStatus getStatus() {
		return status;
	}

	public void setStatus(PageStatus status) {
		this.status = status;
	}	

}
