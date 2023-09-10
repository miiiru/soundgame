package soundgame;

import java.util.Random;

public class RandomQuestion{

    public String soundQuestion(){
        String[] sound = { "Do", "Re", "Mi", "Fa", "So", "La", "Si" };
        String question = sound[new Random().nextInt(7)];
        return question;
    }
}
