
//フレームを作成するためのJFrameのインポート
import javax.swing.JFrame;
import javax.swing.WindowConstants;


//mainFrameは親クラスのJFrameを継承する
public class MainFrame extends JFrame {

    //mainFrameメソッド
    public MainFrame(){
        //×ボタンを押した時終了させる
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //ゲームタイトル
        this.setTitle("ゲーム");
        //フレームのサイズを縦横800にする(タイトルバー含む)
        this.setSize(800, 800);
        //フレームを中央に出現させる
        this.setLocationRelativeTo(null);
        //ウインドウの表示
        this.setVisible(true);
    }

}
