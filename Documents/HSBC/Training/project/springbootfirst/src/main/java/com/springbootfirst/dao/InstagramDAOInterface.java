package com.springbootfirst.dao;

import java.util.ArrayList;

import com.springbootfirst.entity.InstagramUser;

public interface InstagramDAOInterface {

	public int createProfile(InstagramUser Ig);

	public InstagramUser viewProfile(InstagramUser Ig);

	public ArrayList<InstagramUser> viewAllProfile();

	public ArrayList<InstagramUser> searchProfile(InstagramUser Ig);

	public int deleteProfile(InstagramUser Ig);

	public int updateProfile(InstagramUser Ig, InstagramUser up_I);

}
