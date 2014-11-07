package com.shopping.dao;

import java.util.ArrayList;

import com.shopping.to.ScreensUrlTo;

public interface ScreenUrlDao {
	public ArrayList<String>  getAll();
	public ScreensUrlTo insert(ScreensUrlTo screensUrlTo);
}
