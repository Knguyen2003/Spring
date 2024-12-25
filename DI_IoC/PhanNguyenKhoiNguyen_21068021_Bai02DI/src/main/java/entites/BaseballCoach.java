package entites;

import dao.Coach;
import dao.FortuneService;

public class BaseballCoach implements Coach {
	private FortuneService fortuneService;

	//Define a constructor for dependency injection
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "BaseballCoach getDailyWorkout";
//		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
//		return "BaseballCoach getDailyFortune";
		return fortuneService.getFortune();
	}

}
