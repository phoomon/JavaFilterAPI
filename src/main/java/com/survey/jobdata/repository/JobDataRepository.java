package com.survey.jobdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import com.survey.jobdata.entity.JobData;

@Repository
public interface JobDataRepository extends JpaRepository<JobData, Long>, QuerydslPredicateExecutor<JobData> {

}
