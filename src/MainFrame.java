
//フレームを作成するためのJFrameのインポート



import javax.swing.JFrame;
import javax.swing.WindowConstants;

//mainFrameは親クラスのJFrameを継承する
public class MainFrame extends JFrame {
    public MainPanel panel;



    //mainFrameメソッド
    public MainFrame(){
        //MainPanelをインスタンス化することでimageをpanel変数に格納する
        panel = new MainPanel();



        //panelを追加する
        this.add(panel);


        //×ボタンを押した時終了させる
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //ゲームタイトル
        this.setTitle("ゲーム");
        //フレームのサイズを縦横500にする(タイトルバー含む)
        this.setSize(500, 500);
        //フレームを中央に出現させる
        this.setLocationRelativeTo(null);
        //大きさの変更を不可にする
        this.setResizable(false);
        //ウインドウの表示
        this.setVisible(true);
    }

}
