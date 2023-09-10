package soundgame;

import javax.swing.JFrame;



public class MainFrame extends JFrame{
    // コンストラクタの用意（ウインドウの初期設定）
    public MainFrame(){
        this.setTitle("音当てゲーム");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //×ボタンを押した時終了させる
        this.setSize(400, 350);                                //ウインドウの大きさを設定
        this.setResizable(false);                             //大きさの変更を不可にする
        this.setLocationRelativeTo(null);                     //ウインドウを画面の中央に配置する場合、引数に「null」を指定する

    }
}
