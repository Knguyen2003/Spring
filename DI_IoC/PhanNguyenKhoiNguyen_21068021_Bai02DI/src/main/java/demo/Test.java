package demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Coach;
import entites.BaseballCoach;
import entites.CriketCoach;
import entites.TennisCoach;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        
        Coach baseball = context.getBean("baseball", Coach.class);
        System.out.println("===========BaseBall=================");
        System.out.println(baseball.getDailyWorkout());
        System.out.println(baseball.getDailyFortune());
        
        
        Coach criket = context.getBean("criket", Coach.class);
        System.out.println("===========CriketBall=================");
        System.out.println(criket.getDailyWorkout());
        System.out.println(criket.getDailyFortune());
        System.out.println(((CriketCoach)criket).getEmail());
        
        
        Coach tenis = context.getBean("tenis", Coach.class);
        System.out.println("===========TenisBall=================");
        System.out.println(tenis.getDailyWorkout());
        System.out.println(tenis.getDailyFortune());
        
        
        context.close();

	}

}
