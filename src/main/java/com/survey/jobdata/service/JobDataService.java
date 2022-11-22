package com.survey.jobdata.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.survey.jobdata.entity.JobData;
import com.survey.jobdata.entity.PagedResult;
import com.survey.jobdata.query.JobDataQuery;
import com.survey.jobdata.repository.JobDataRepository;
import com.survey.jobdata.repository.filter.JobDataFilter;

@Service
public class JobDataService {

	private static final Logger LOG = LoggerFactory.getLogger(JobDataService.class);

	@Autowired
	private JobDataRepository jobDataRepo;

	@Autowired
	private JobDataQuery queryRepo;

	public PagedResult<JobData> getJobDataList(String jobtitle, String salary, String gender) {

		BooleanExpression where = null;
		String conditionalOp = null;
		List<JobData> jobDataList = new ArrayList<JobData>();
		try {
			if (salary != null) {

				if (salary.contains(":")) {

					conditionalOp = salary.substring(0, salary.indexOf(":"));
					salary = salary.substring(salary.indexOf(":") + 1, salary.length());
					switch (conditionalOp) {

					case "gt":
						where = JobDataFilter.greaterThanSalary(Double.parseDouble(salary));
						break;
					case "gte":
						where = JobDataFilter.checkGreaterThanEqualSalary(Double.parseDouble(salary));
						break;
					case "lt":
						where = JobDataFilter.lessThanSalary(Double.parseDouble(salary));
						break;
					case "lte":
						where = JobDataFilter.checkLessThanEqualSalary(Double.parseDouble(salary));
						break;
					case "ne":
						where = JobDataFilter.notEqualEqualSalary(Double.parseDouble(salary));
						break;
					}
				} else {
					where = JobDataFilter.checkEqualSalary(Double.parseDouble(salary));
				}

			}
			if (jobtitle != null) {

				if (where != null) {
					where = where.and(JobDataFilter.getEqualJobtitle(jobtitle));
				}

			}
			if (gender != null) {
				if (where != null) {
					where = where.and(JobDataFilter.getEqualGender(gender));
				}
			}

			if (where != null) {

				jobDataList = (List<JobData>) this.jobDataRepo.findAll(where, Sort.by("sid").ascending());

			} else {
				jobDataList = (List<JobData>) this.jobDataRepo.findAll(Sort.by("sid").ascending());

			}
			return new PagedResult<JobData>(jobDataList, jobDataList.size(), "Success");
		} catch (Exception ex) {

			LOG.error("getJobDataList::" + ex.getMessage());
			return new PagedResult<JobData>(jobDataList, jobDataList.size(), "Failed.Cannot get data");

		}

	}

	public PagedResult<JobData> sortDataList(String sort_by, String sort_type) {

		List<JobData> jobDataList = new ArrayList<JobData>();

		try {//
			jobDataList = (List<JobData>) this.jobDataRepo
					.findAll(Sort.by(sort_type.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sort_by));
			return new PagedResult<JobData>(jobDataList, jobDataList.size(), "Success");
		} catch (Exception ex) {
			return new PagedResult<JobData>(jobDataList, jobDataList.size(), "Failed.Cannot get data");
		}

	}

	public PagedResult<Object[]> filterBySparseData(String fieldName) {
		List<Object[]> jobDataList = new ArrayList<Object[]>();
		try {
			jobDataList = queryRepo.filterBySparseData(fieldName);
			return new PagedResult<Object[]>(jobDataList, jobDataList.size(), "Success");
		} catch (Exception ex) {
			return new PagedResult<Object[]>(jobDataList, jobDataList.size(), "Failed.Cannot get data");
		}

	}
}
