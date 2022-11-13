package com.capitalmaharaja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitalmaharaja.entity.Admin;
import com.capitalmaharaja.service.AdminService;
import com.capitalmaharaja.util.ResponseUtil;

@RestController
@RequestMapping("controller/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil addAdmin(@RequestBody Admin admin){
		return new ResponseUtil(200,"Admin Added Successfully",adminService.addAdmin(admin));
	}
	
	@GetMapping(path="allAdmins",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil getAllAdmin(){
		return new ResponseUtil(200,"Done",adminService.getAllAdmin());
	}
	
	
	@GetMapping(path="singleAdmin/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil getAdmin(@PathVariable String id){
		return new ResponseUtil(200,"Done",adminService.getAdminById(id));
	}
	
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil updateAdmin(@RequestBody Admin admin ){
		return new ResponseUtil(200,"Admin Updated Successfully",adminService.updateAdmin(admin));
	}
	
	@DeleteMapping(path="/remove/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil deleteCustomer(@PathVariable String id){
		return new ResponseUtil(200,"Admin Deleted Successfully",adminService.deleteAdmin(id));
	}


}
