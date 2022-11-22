package com.survey.jobdata.repository.filter;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.survey.jobdata.entity.QJobData;

public class JobDataFilter {

    public static BooleanExpression checkEqualSalary(double salary) {

        return QJobData.jobData.salary.eq(salary);

    }
    public static BooleanExpression greaterThanSalary(double salary) {

        return QJobData.jobData.salary.gt(salary);

    }
    public static BooleanExpression lessThanSalary(double salary) {

        return QJobData.jobData.salary.lt(salary);

    }
    public static BooleanExpression checkGreaterThanEqualSalary(double salary) {

        return QJobData.jobData.salary.goe(salary);

    }
    public static BooleanExpression checkLessThanEqualSalary(double salary) {

        return QJobData.jobData.salary.loe(salary);

    }
    public static BooleanExpression notEqualEqualSalary(double salary) {

        return QJobData.jobData.salary.ne(salary);

    }
    public static BooleanExpression getEqualJobtitle(String jobtitle) {

        return QJobData.jobData.jobTitle.eq(jobtitle);

    }
    public static BooleanExpression getEqualGender(String gender) {

        return QJobData.jobData.gender.eq(gender);

    }
}
