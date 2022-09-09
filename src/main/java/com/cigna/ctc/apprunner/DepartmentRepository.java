package com.cigna.ctc.apprunner;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, String> {
}
