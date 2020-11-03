package com.springbootfirst.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootfirst.dao.InstagramDAOInterface;
import com.springbootfirst.entity.InstagramUser;

@Service
public class InstagramService implements InstagramServiceInterface {

	@Autowired
	public InstagramDAOInterface fd;
	
	@Override
	public int createProfile(InstagramUser Ig) {
		return fd.createProfile(Ig);
		
	}

	@Override
	public InstagramUser viewProfile(InstagramUser Ig) {
		return fd.viewProfile(Ig);
	}

	@Override
	public ArrayList<InstagramUser> viewAllProfile() {
		return fd.viewAllProfile();
	}

	@Override
	public ArrayList<InstagramUser> searchProfile(InstagramUser Ig) {
		return fd.searchProfile(Ig);
	}

	@Override
	public int deleteProfile(InstagramUser Ig) {
		return fd.deleteProfile(Ig);
	}

	@Override
	public int updateProfile(InstagramUser Ig, InstagramUser up_I) {
		return fd.updateProfile(Ig,up_I);
	}

}
