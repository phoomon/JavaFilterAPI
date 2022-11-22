package com.survey.jobdata.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class PagedResult<T> {

	private List<T> respData = new ArrayList<>();

	private int count = 0;
		
	private String retMsg;

	public PagedResult(List<T> result, int count,String retMsg) {

		super();
		this.respData = result;
		this.count = count;
		this.retMsg = retMsg;
		

	}
}