package entites;

import dao.FortuneService;

public class HappyFortuneService implements FortuneService{
    
	@Override
	public String getFortune() {
		
//		return "Today is your lucky day! Happy Fortune";
		return "HappyFortuneService getFortune";
	}
	

}
