package com.merong.home.vo;

import com.google.appengine.api.datastore.Query.SortDirection;



public class SortVo {
	
	private SortDirection sortDirection;
	
	public SortVo() {
			
	}
	
	public SortVo(SortDirection sortDirection) {
		this.sortDirection = sortDirection;
		
	}

	public SortDirection getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(SortDirection sortDirection) {
		this.sortDirection = sortDirection;
	}
	
}
