package com.survey.jobdata.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QJobData is a Querydsl query type for JobData
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QJobData extends EntityPathBase<JobData> {

    private static final long serialVersionUID = -877332694L;

    public static final QJobData jobData = new QJobData("jobData");

    public final StringPath additionalComments = createString("additionalComments");

    public final NumberPath<Double> annualBonus = createNumber("annualBonus", Double.class);

    public final NumberPath<Double> annualStockValue = createNumber("annualStockValue", Double.class);

    public final StringPath employer = createString("employer");

    public final NumberPath<Double> empYears = createNumber("empYears", Double.class);

    public final NumberPath<Double> expYears = createNumber("expYears", Double.class);

    public final StringPath gender = createString("gender");

    public final StringPath jobTitle = createString("jobTitle");

    public final StringPath location = createString("location");

    public final NumberPath<Double> salary = createNumber("salary", Double.class);

    public final NumberPath<Long> sid = createNumber("sid", Long.class);

    public final NumberPath<Double> signingBonus = createNumber("signingBonus", Double.class);

    public final StringPath timestamp = createString("timestamp");

    public QJobData(String variable) {
        super(JobData.class, forVariable(variable));
    }

    public QJobData(Path<? extends JobData> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJobData(PathMetadata metadata) {
        super(JobData.class, metadata);
    }

}

