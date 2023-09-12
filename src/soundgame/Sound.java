package soundgame;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    public static String question;

    public void startClip() throws InterruptedException{
        RandomQuestion r = new RandomQuestion();
        question = r.soundQuestion();
        // ランダムに選択された音源
        Clip clip = createClip(new File("./SoundSouse/"+ question +".wav"));
        // 音を再生する
        clip.start();
        Thread.sleep(3000);
    }



    public static Clip createClip(File path) {
        //指定されたURLのオーディオ入力ストリームを取得
        try (AudioInputStream ais = AudioSystem.getAudioInputStream(path)){

            //ファイルの形式取得
            AudioFormat af = ais.getFormat();

            //単一のオーディオ形式を含む指定した情報からデータラインの情報オブジェクトを構築
            DataLine.Info dataLine = new DataLine.Info(Clip.class,af);

            //指定された Line.Info オブジェクトの記述に一致するラインを取得
            Clip c = (Clip)AudioSystem.getLine(dataLine);

            //再生準備完了
            c.open(ais);

            return c;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static boolean Check(String ans){
        boolean result;
        //問題の音を聞く前に解答ボタンを押された場合の対処(NullPointerException対策)
        if(null == Sound.question){
            result = false;
        }else{
            // 問題と答えが正しいかcheckするequalメソッドを呼び出す
            result = question.equals(ans);
        }
        return result;
    }



    // equalメソッドのオーバーライド
    //同じならtrue、異なる場合はfalse
    public boolean equals(String str){
        if (Sound.question == str){
            return true;
        }else{
            return false;
        }
    }

}
