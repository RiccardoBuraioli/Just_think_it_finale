package controller;

import bean.UserHomeBoundary;
import dao.UserDao;
import dao.VolunteerRepository;
import entity.User;
import entity.VolunteerUser;



public  class UserHomeController{
	

	private User currentUser;
	private UserDao userd;

	public UserHomeController() {
		//default
	}
	public UserHomeController(User user) {
		this.currentUser = user;
	}
	
	public User getCurrentUser() {
		return this.currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public void helpButtonPressed() {
		//  da fare
		
		
	}

	public void deleteAccount(int id) {
		userd.deleteVolunteer(id);
		
	}
	
	
	public void initDataCont(int id, UserHomeBoundary userin) {
		VolunteerRepository userD = new VolunteerRepository();
		VolunteerUser user = userD.getVolunteerByID(id);
		userin.initData(user.getNome(), user.getCognome(), user.getId());
		
    
    }


}
