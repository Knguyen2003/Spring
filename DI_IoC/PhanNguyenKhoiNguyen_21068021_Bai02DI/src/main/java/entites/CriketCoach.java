package entites;

import dao.Coach;
import dao.FortuneService;

public class CriketCoach implements Coach{
	//Use DI setter injection
	private String email;
	private String team;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	private FortuneService fortuneService;
	
    //Dependency injection using setter method
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	
	public CriketCoach() {
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "CriketCoach getDailyWorkout";
//		return "CriketCoach : practice fast bowling for 15 minutes";	
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
//		return "CriketCoach getDailyFortune";
		return fortuneService.getFortune();
	}

}
