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

    // ***クラス変数の用意***
    // 上中下パネルのインスタンスの生成
    JPanel pNorth = new JPanel();
    JPanel pCenter = new JPanel();
    JPanel pSouth = new JPanel();

    JPanel pCenterTop = new JPanel();
    JPanel pCenterBottom = new JPanel();

    // 問題文ラベルの作成
    JLabel labelPro = new JLabel("聞こえた音は…？");

    // 正解・不正解出力部分の作成
    JLabel labelAns = new JLabel("どれでしょう？");

    // ボタンの作成
    JButton answerDo = new JButton("ド");
    JButton answerRe = new JButton("レ");
    JButton answerMi = new JButton("ミ");
    JButton answerFa = new JButton("ファ");
    JButton answerSo = new JButton("ソ");
    JButton answerLa = new JButton("ラ");
    JButton answerSi = new JButton("シ");
    JButton[] answer = {answerDo, answerRe, answerMi, answerFa, answerSo, answerLa, answerSi};
    JButton play = new JButton();



    // ***コンストラクタの用意***
    public Main(){
        // ウィンドウの表示領域の取得
        Container c = getContentPane();

        // 各パネルをウインドウの表示領域に配置(4段作成(上、中の上、中の下、下))
        c.add(pNorth, BorderLayout.NORTH);
        c.add(pCenter, BorderLayout.CENTER);
        c.add(pSouth, BorderLayout.SOUTH);

        pCenter.add(pCenterTop, BorderLayout.NORTH);
        pCenter.add(pCenterBottom, BorderLayout.SOUTH);

        // 問題文ラベルの設定
        pNorth.add(labelPro); // 上パネルに配置(問題文ラベルの追加)
        labelPro.setFont(new Font("SanSelf", Font.PLAIN, 40)); // テキストのフォントと色の設定
        labelPro.setForeground(Color.BLACK);

        // 正解・不正解出力部分の設定
        pCenterBottom.add(labelAns, BorderLayout.CENTER); // 中の下パネルに配置(正解・不正解ラベルの追加)
        labelAns.setFont(new Font("SanSelf", Font.PLAIN, 20)); // テキストのフォントと色の設定

        // 各ボタンの設定
        // ドレミのボタン
        for(int i =0; i < answer.length; i++){
            pCenterTop.add(answer[i], BorderLayout.NORTH); // 中パネルに配置(ドレミボタンの追加)
        }

        // 音再生ボタン
        pSouth.add(play = new JButton("♪"), BorderLayout.CENTER); // 下パネルに配置(音再生ボタンの追加)
        play.setPreferredSize(new Dimension(150, 150)); // ボタンの大きさ
        play.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 50)); // フォントと♪の大きさ



        // ウインドウを表示
        setVisible(true);
    }



    // 各ボタンが押下されたときの処理
    public void click(){
        //♪ボタンが押下された時に実行される処理
        play.addActionListener(e -> {
          Sound s = new Sound(); // 問題の音を再生する(Sound.javaのインスタンス化)
          try {
            s.startClip();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        });


        // 「ド」ボタンを押下された時に実行される処理
        answer[0].addActionListener(e -> {
            // 正解か不正解か判定するメソッドを呼び出す
            boolean result = Sound.Check("ド");
            output(result);
        });

        // 「レ」ボタンを押下された時に実行される処理
        answer[1].addActionListener(e -> {
            // 正解か不正解か判定するメソッドを呼び出す
            boolean result = Sound.Check("レ");
            output(result);
        });

        // 「ミ」ボタンを押下された時に実行される処理
        answer[2].addActionListener(e -> {
            // 正解か不正解か判定するメソッドを呼び出す
            boolean result = Sound.Check("ミ");
            output(result);
        });

        // 「ファ」ボタンを押下された時に実行される処理
        answer[3].addActionListener(e -> {
            // 正解か不正解か判定するメソッドを呼び出す
            boolean result = Sound.Check("ファ");
            output(result);
        });

        // 「ソ」ボタンを押下された時に実行される処理
        answer[4].addActionListener(e -> {
            // 正解か不正解か判定するメソッドを呼び出す
            boolean result = Sound.Check("ソ");
            output(result);
        });

        // 「ラ」ボタンを押下された時に実行される処理
        answer[5].addActionListener(e -> {
            // 正解か不正解か判定するメソッドを呼び出す
            boolean result = Sound.Check("ラ");
            output(result);
        });

        // 「シ」ボタンを押下された時に実行される処理
        answer[6].addActionListener(e -> {
            // 正解か不正解か判定するメソッドを呼び出す
            boolean result = Sound.Check("シ");
            output(result);
        });


    }






    public void output(boolean result){
        if(result == true){
            labelAns.setText("正解");
            labelAns.setForeground(Color.BLUE);
        }else if(result == false && Sound.question != null){
            labelAns.setText("不正解（正解は" + Sound.question + "でした）");
            labelAns.setForeground(Color.RED);
        }else{
            labelAns.setText("音を鳴らしてみましょう！");
        }
    }






  public static void main(String[] args) {
      Main a = new Main();
      a.click();
  }







}