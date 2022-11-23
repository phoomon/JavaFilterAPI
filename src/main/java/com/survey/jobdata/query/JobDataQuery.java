package com.survey.jobdata.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JobDataQuery {

	private static final Logger LOG = LoggerFactory.getLogger(JobDataQuery.class);

	@Autowired
	private JdbcTemplate readOnlyJdbcTemplate;
	String[] fnameList = new String[1];

	@Transactional(readOnly = true)
	public List<Map<String, String>> filterBySparseData(String fieldName) {
		LOG.info("JobDataQuery >> fieldName : [{}] ", fieldName);
		List<Map<String, String>> sDataList = null;

		if (fieldName.contains(",")) {
			fnameList = fieldName.split(",");
		} else {
			fnameList[0] = fieldName;
		}
		sDataList = this.readOnlyJdbcTemplate.query("select " + fieldName + " from sv_salary",
				(rs, rowNum) -> mapSparseField(rs, fnameList));

		return sDataList;

	}

	private Map<String, String> mapSparseField(ResultSet rs, String[] fieldNameList) throws SQLException {
		Map<String, String> retData = new HashMap<>();
		for (int i = 0; i < fieldNameList.length; i++) {
			retData.put(fieldNameList[i], rs.getString(fieldNameList[i]));
		}
		return retData;

	}

}
