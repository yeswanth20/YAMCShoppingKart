package com.shopping.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ScreensUrl")
public class ScreensUrlOrm {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String screenName;
	private String screenUrl;
	//Generate getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getScreenUrl() {
		return screenUrl;
	}
	public void setScreenUrl(String screenUrl) {
		this.screenUrl = screenUrl;
	}
}
