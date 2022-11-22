package com.survey.jobdata.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.survey.jobdata.entity.FilteredColumnOutput;
import com.survey.jobdata.entity.Output;
import com.survey.jobdata.service.JobDataService;

@Controller
public class JobDataRest {

	private static final Logger LOG = LoggerFactory.getLogger(JobDataRest.class);

	@Autowired
	private JobDataService jobDataService;

	@RequestMapping(value = "/getJobData", method = { RequestMethod.GET })
	public ResponseEntity<Output> getJobDataList(@RequestParam(required = false) String jobtitle,
			@RequestParam(required = false) String gender, @RequestParam(required = false) String salary) {

		LOG.info("Initializing getJobDataList :: jobTitle : [{}],gender : [{}], salary : [{}] ", jobtitle, gender,
				salary);

		return new ResponseEntity<Output>(new Output(jobDataService.getJobDataList(jobtitle, salary, gender)),
				HttpStatus.OK);

	}

	@RequestMapping(value = "/getSortData", method = { RequestMethod.GET })
	public ResponseEntity<Output> sortDataList(@RequestParam String sort_by, @RequestParam String sort_type) {

		LOG.info("Initializing getJobDataList :: sort_by : [{}],sort_type : [{}] ", sort_by, sort_type);

		return new ResponseEntity<Output>(new Output(jobDataService.sortDataList(sort_by, sort_type)), HttpStatus.OK);

	}

	@RequestMapping(value = "/getSparseData", method = { RequestMethod.GET })
	public ResponseEntity<FilteredColumnOutput> filterBySparseData(@RequestParam String filterName) {

		LOG.info("Initializing getJobDataList :: filterName : [{}] ", filterName);
		return new ResponseEntity<FilteredColumnOutput>(
				new FilteredColumnOutput(jobDataService.filterBySparseData(filterName)), HttpStatus.OK);

	}
}
