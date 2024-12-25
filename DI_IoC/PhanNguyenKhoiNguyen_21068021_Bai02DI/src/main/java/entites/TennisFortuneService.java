package entites;

import dao.FortuneService;

public class TennisFortuneService implements FortuneService{

	@Override
	public String getFortune() {
//		return "Tennis fortune : Today is your lucky day !";
		return "Tennis fortune : getFortune";
	}
	

}
