package service;
import java.util.List;
import pojo.Profile;

public interface ProfileService {
	public List<Profile> selectProfile();
	public int updateProfile(Profile  up);
	
}
