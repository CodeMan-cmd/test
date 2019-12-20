package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.ProfileMapper;

import pojo.Profile;
@Service
public class ProfileServiceImp implements ProfileService {
	@Resource
	private ProfileMapper profileMapper;
	
	public List<Profile> selectProfile() {
		return profileMapper.selectProfile();
	}

	public int updateProfile(Profile up) {
		return profileMapper.updateProfile(up);
	}
		
}
