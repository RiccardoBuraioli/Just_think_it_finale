package controller;

import bean.UserHomeBoundary;
import dao.UserDao;
import dao.VolunteerRepository;
import entity.User;
import entity.VolunteerUser;



public  class UserHomeController{
	

	
	
	public UserHomeController() {
		//default
	}
	
	
	public void helpButtonPressed() {
		//  da fare
		
		
	}

	public void deleteAccount(int id) {
		UserDao userd = new UserDao();
		userd.deleteVolunteer(id);
		
	}
	
	
	public void initDataCont(int id, UserHomeBoundary userin) {
		VolunteerRepository userD = new VolunteerRepository();
		VolunteerUser user = userD.getVolunteerByID(id);
		userin.initData(user.getNome(), user.getCognome(), user.getId());
		
    
    }


}
