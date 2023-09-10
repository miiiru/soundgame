package soundgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main extends MainFrame{

  public static void main(String[] args) {

    // MainFrameのインスタンス化
    MainFrame m = new MainFrame();


    //(1)ウインドウの表示領域の取得
    Container c = m.getContentPane();
    //上中下パネルのインスタンスの生成
    JPanel pNorth = new JPanel();
    JPanel pCenter = new JPanel();
    JPanel pSouth = new JPanel();

    //(2)各パネルをウインドウの表示領域に配置
    c.add(pNorth, BorderLayout.NORTH);
    c.add(pCenter, BorderLayout.CENTER);
    c.add(pSouth, BorderLayout.SOUTH);


    // 問題文ラベルの作成
    JLabel l = new JLabel("聞こえた音は…？");
    l.setFont(new Font("SanSelf", Font.PLAIN, 40));//テキストのフォントと色の設定
    l.setForeground(Color.BLACK);
    // 問題文ラベルを上パネルに配置(問題文パネルの追加)
    pNorth.add(l);


    // ボタンの作成
    JButton answerDo = new JButton();
    JButton answerRe = new JButton();
    JButton answerMi = new JButton();
    JButton answerFa = new JButton();
    JButton answerSo = new JButton();
    JButton answerLa = new JButton();
    JButton answerSi = new JButton();
    JButton play = new JButton();

    // ボタンを真ん中パネルと下パネルに配置(ボタンの追加)
    pCenter.add(answerDo = new JButton("ド"));
    pCenter.add(answerRe = new JButton("レ"));
    pCenter.add(answerMi = new JButton("ミ"));
    pCenter.add(answerFa = new JButton("ファ"));
    pCenter.add(answerSo = new JButton("ソ"));
    pCenter.add(answerLa = new JButton("ラ"));
    pCenter.add(answerSi = new JButton("シ"));
    pSouth.add(play = new JButton("♪"), BorderLayout.CENTER);

    // 各ボタンが押下された時に実行される処理
    answerDo.addActionListener(e -> {
        System.out.println("ボタン1が押された");
        //String ans = CheckAnswer.Check("Do");//正解か不正解か判定するメソッドを呼び出す

      });
    answerRe.addActionListener(e -> {
      System.out.println("ボタン2が押された");
    });
    answerMi.addActionListener(e -> {
        System.out.println("ボタン3が押された");
      });
    answerFa.addActionListener(e -> {
        System.out.println("ボタン4が押された");
      });
    answerSo.addActionListener(e -> {
        System.out.println("ボタン5が押された");
      });
    answerLa.addActionListener(e -> {
        System.out.println("ボタン6が押された");
      });
    answerSi.addActionListener(e -> {
        System.out.println("ボタン7が押された");
      });

    play.setPreferredSize(new Dimension(150, 150));// ボタンの大きさ
    play.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 50));// フォントと♪の大きさ
    //♪ボタンが押下された時に実行される処理
    play.addActionListener(e -> {
      Sound s = new Sound(); // 問題の音を再生する(Sound.javaのインスタンス化)
      try {
        s.startClip();
    } catch (InterruptedException e1) {
        e1.printStackTrace();
    }
    });





  // ウインドウを表示
    m.setVisible(true);





  }



}