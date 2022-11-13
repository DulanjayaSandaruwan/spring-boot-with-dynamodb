package com.capitalmaharaja.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capitalmaharaja.entity.Admin;
import com.capitalmaharaja.repo.AdminRepo;

@Service
@Transactional
public class AdminService {

	@Autowired
	AdminRepo adminRepo;
	
	public Admin addAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
	
	public Iterable<Admin> getAllAdmin() {
		return adminRepo.findAll();
	}
	
	public Optional<Admin> getAdminById(String id) {
		return adminRepo.findById(id);
	}
	
	public Admin updateAdmin(Admin admin) {
		boolean isExist=adminRepo.existsById(admin.getId());
		if (!isExist) {
			throw new RuntimeException("Entity Not Found");
		}else {
			return adminRepo.save(admin);
		}
	}
	
	public String deleteAdmin(String id) {
		boolean isExist=adminRepo.existsById(id);
		if (!isExist) {
			throw new RuntimeException("Entity Not Found");
		}else {
			 adminRepo.deleteById(id);
			 return "Deleted";
		}
	}
}
