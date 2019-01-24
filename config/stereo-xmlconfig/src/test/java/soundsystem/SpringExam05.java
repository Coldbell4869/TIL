package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam05 {
    public static void main(String[] args) throws Exception{
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(DiceConfig.class);

//        Dice dice1 = applicationContext.getBean(Dice.class);
//        Dice dice2 = applicationContext.getBean(Dice.class);
//        if(dice1 == dice2)
//            System.out.println("dice1 == dice2");
//        Dice dice3 = applicationContext.getBean("dice", Dice.class);
//        System.out.println(dice3.getNumber());
//
//        Player kim = applicationContext.getBean("kim", Player.class);
//        kim.play();
//
//        Game game = applicationContext.getBean(Game.class);
//        game.play();
    }
}
