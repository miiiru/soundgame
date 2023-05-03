import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

//ゲーム画面を表示するパネルの用意
//描画部分は自作するのでクラスを作り継承する
public class MainPanel extends JPanel{
    //ちらちら画面に表示させないように一気に結果を表示させる（ちらちらしない→バッファリング　ダミーの画面を用意）
    //メモリ上に領域を作って、そこに画像を読み込んだり、物体を描画したりといったことを行う為のもの
    public BufferedImage image;


    public MainPanel(){
        super();
        //TYPE_INT_RGB→整数型ピクセルにパックさ れた 8 ビット RGB 色成分によるイメージを表す
        this.image = new BufferedImage(500,500,BufferedImage.TYPE_INT_RGB);
        }

    //コンポーネントが描画されるときに呼び出される
    @Override
    public void paint(Graphics g){
        super.paint(g);


        //thisがついていないimageなのでローカル変数
        g.drawImage(image, 0, 0, this);
    }

    public void draw(){
        this.repaint();
    }

}
