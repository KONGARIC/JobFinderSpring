package com.luv2code.springboot.AssignmentDemo.dao;


import com.luv2code.springboot.AssignmentDemo.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {


	
}
