package com.springbootfirst.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootfirst.entity.InstagramUser;
import com.springbootfirst.service.InstagramServiceInterface;

@RestController
public class InstagramContoller{

	@Autowired
	public InstagramServiceInterface  fs;

	
	@PostMapping("userCreate")
	public String createProfile(@RequestBody InstagramUser Ig) {
		int i = fs.createProfile(Ig);
		if(i>0) {
			return "Profile Created";
		}
		else {
			return "Could not create Profile";
		}
	}
	
	@GetMapping("userView")
	public String viewProfile(@RequestBody InstagramUser Ig) {
		InstagramUser I = fs.viewProfile(Ig);
		String toRet= null;
		if(I.getName() != null) {
			toRet = "\nName: "+I.getName() +"\nPassword: "+I.getPwd()+"\nEmail Id: "+I.getEmailid() + "\nAddress: "+I.getAddress();
			return toRet;
		}
		else {
			return toRet;
		}
	}
	
	@GetMapping("userViewAll")
	public String viewAllProfile() {
		ArrayList<InstagramUser> IgList = fs.viewAllProfile();
		String toRet = "Profiles: ";
		if(IgList != null) {
			for(InstagramUser I : IgList) {
				toRet = toRet + "\nName: "+I.getName() +"\nPassword: "+I.getPwd()+"\nEmail Id: "+I.getEmailid() + "\nAddress: "+I.getAddress();
			}
			return toRet;
		}
		else {
			return "Empty Database";
		}
	}
	
	@PutMapping("userUpdate")
	public String updateProfile(@RequestBody InstagramUser Ig,@RequestBody InstagramUser up_I) {
		int i = fs.updateProfile(Ig,up_I);
		if(i>0) {
			return "Profile Updated.";
		}
		else {
			return "Could not update profile!";
		}
	}
	
	@GetMapping("userSearch")
	public String searchjProfile(@RequestBody InstagramUser Ig) {
		ArrayList<InstagramUser> IgList = fs.searchProfile(Ig);
		String toRet = "Profile: ";
		if(IgList.size()!=0) {
			for(InstagramUser I : IgList) {
				toRet = toRet + "\nName: "+I.getName() +"\nPassword: "+I.getPwd()+"\nEmail Id: "+I.getEmailid() + "\nAddress: "+I.getAddress();
			}
			return toRet;
		}
		else {
			return "Could not find such profile.";
		}
	}
	
	@DeleteMapping("userDel")
	public String deleteProfile(@RequestBody InstagramUser Ig) {
		int i = fs.deleteProfile(Ig);
		if(i>0) {
			return "Profile Created";
		}
		else {
			return "Could not delete Profile";
		}
	}
	
	/*@GetMapping("hello")
	public String test_print() {
		return "hello **********";
	}*/

	/*@GetMapping("userGet")
	public List<InstagramUser> userList() {
		List<InstagramUser> ee=new ArrayList<InstagramUser>();
		InstagramUser e=new InstagramUser(); 
		e.setName("rajesh"); 
		e.setPwd("abcd"); 
		e.setEmailid("abc@yahoo.com"); 
		e.setAddress("Bangalore"); 
		InstagramUser e1=new InstagramUser(); 
		e1.setName("mahesh"); 
		e1.setPwd("abcde"); 
		e1.setEmailid("abcde@yahoo.com"); 
		e1.setAddress("Chennai"); 
		ee.add(e1); 
		ee.add(e); 
		return ee;
	}*/
}
