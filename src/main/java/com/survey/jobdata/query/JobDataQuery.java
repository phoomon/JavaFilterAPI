package com.survey.jobdata.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class JobDataQuery {

	private static final Logger LOG = LoggerFactory.getLogger(JobDataQuery.class);

	@Autowired
	private JdbcTemplate readOnlyJdbcTemplate;
	String[] fnameList = new String[1];

	public List<Object[]> filterBySparseData(String fieldName) {
		LOG.info("JobDataQuery >> fieldName : [{}] ", fieldName);
		List<Object[]> sDataList = null;

		if (fieldName.contains(",")) {
			fnameList = fieldName.split(",");
		} else {
			fnameList[0] = fieldName;
		}
		sDataList = this.readOnlyJdbcTemplate.query("select " + fieldName + " from sv_salary",
				(rs, rowNum) -> mapSparseField(rs, fnameList));

		return sDataList;

	}

	private String[] mapSparseField(ResultSet rs, String[] fieldNameList) throws SQLException {
		String[] obj = new String[fieldNameList.length];
		for( int i =0;i< fieldNameList.length;i++) {
			
			obj[i] = rs.getString(fieldNameList[i]);
		}
		return obj;

	}
}
