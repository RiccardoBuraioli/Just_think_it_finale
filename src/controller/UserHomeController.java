package controller;

import dao.UserDao;
import entity.User;


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
	
	
	


}
