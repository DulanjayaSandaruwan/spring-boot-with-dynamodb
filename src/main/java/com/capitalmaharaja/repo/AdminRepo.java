package com.capitalmaharaja.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capitalmaharaja.entity.Admin;

@Repository
@EnableScan
public interface AdminRepo extends CrudRepository<Admin, String> {

}
