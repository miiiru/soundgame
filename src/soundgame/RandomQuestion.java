package soundgame;

import java.util.Random;

public class RandomQuestion{

    public String soundQuestion(){
        String[] sound = { "ド", "レ", "ミ", "ファ", "ソ", "ラ", "シ" };
        String question = sound[new Random().nextInt(7)];
        return question;
    }
}
