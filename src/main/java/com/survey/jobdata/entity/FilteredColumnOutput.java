package com.survey.jobdata.entity;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FilteredColumnOutput {

	 PagedResult<Map<String, String>> pagedResult;

}
