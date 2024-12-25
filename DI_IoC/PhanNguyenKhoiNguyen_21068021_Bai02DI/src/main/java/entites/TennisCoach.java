package entites;

import dao.Coach;
import dao.FortuneService;

public class TennisCoach implements Coach{
	
	private FortuneService theFortune;
	
	
    //Dependency injection using constructor
	public TennisCoach(FortuneService theFortune) {
		this.theFortune = theFortune;
	}

	@Override
	public String getDailyWorkout() {
//		return "TennisCoach: Run a hard 5k";
		return "TennisCoach: getDailyWorkout";
	}

	@Override
	public String getDailyFortune() {
		return theFortune.getFortune();
	}
	

}
