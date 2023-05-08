import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Main {
    //クラス内で使用できるクラス変数(staticとして宣言しているため)を用意する
    public static MainFrame mainFrame;
    public static boolean loop;

    public static void main(String[] args) throws Exception{
        //メインフレームを生成
        mainFrame = new MainFrame();
        loop = true;

        Graphics gra = mainFrame.panel.image.getGraphics();


        //FPS(フレームレート（fps）とは、1秒間の動画が何枚の画像で構成されているかを示すの単位のこと)
        long startTime;
        int fps = 30;//大体人は30が限界らしい
        while(loop){
            //UNIX時間を取得(処置開始前の時刻)
            startTime = System.currentTimeMillis();
            //背景色とその範囲
            gra.setColor(Color.WHITE);
            gra.fillRect(0,0,500,500);

            //問題文
            gra.setColor(Color.BLACK);//色
            Font font = new Font("SansSerif", Font.PLAIN, 25);//字体、プレーン(斜線太字なし)、字の大きさ
            gra.setFont(font);//gra変数にfontをセットする
            FontMetrics metrics = gra.getFontMetrics(font);//getFontMetricsで必要なピクセル数を取得する
            gra.drawString("この音はドレミの何の音？", 250 - (metrics.stringWidth("この音はドレミの何の音？") / 2), 100);//中央に表示させる

            //音が流れる再生ボタン
        //    Sound s = new Sound();
        //    File file = new File("file/sound1.wav");
        //    Clip clip = s.createClip(file);
        //    clip.start();
        //    clip.loop(Clip.LOOP_CONTINUOUSLY);
        //    Thread.sleep(9000);
        //    clip.close();
          //  gra.setColor(Color.BLACK);
          //  gra.fillRect(100, 100, 100, 100);

            //答え選択ボタン(左)
            gra.setColor(Color.BLUE);//色
            gra.fillRect(70, 250, 120, 120);

            gra.setColor(Color.WHITE);
            gra.drawString("ファ", 105, 315);

            //答え選択ボタン(右)
            gra.setColor(Color.BLUE);//色
            gra.fillRect(310, 250, 120, 120);

            gra.setColor(Color.WHITE);
            gra.drawString("ラ", 355, 315);

            //バッファした結果を表示する関数を呼ぶ
            mainFrame.panel.draw();

            //画面のちらつきをなくしてくれる,待機時間を計算する
            //33msから処理時間を引いた時間待機する
            try{
                long runTime = System.currentTimeMillis() - startTime;
                if(runTime<(1000 / fps)){
                    Thread.sleep((1000 / fps) -(runTime)); //1000ミリ秒は1秒
                }
            }catch (InterruptedException e) {// Threadクラスのsleep()メソッド等、一時的にスレッドを停止するメソッドが投げる
                e.printStackTrace();//例外が投げられた理由を取得する
            }

        }






  /*      EnumGameScreen screen = EnumGameScreen.START;

        switch (screen){
        case START:
            gra.setColor(Color.BLACK);
            Font font = new Font ("SansSerif",Font.PLAIN,40);
            gra.setFont(font);
            FontMetrics metrics = gra.getFontMetrics(font);
            gra.drawString("Shooting", 30, 80);

            break;
        case GAME:
            break;
        case GAME_OVER:
            break;
        }


*/


    }

}
