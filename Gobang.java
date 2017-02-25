import java.io.*;

public class Gobang{
  static Player p1,p2,pw; //プレイヤー
  static int[][] board = { //盤 9×9
    {0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0}};
  public static void main(String[] args) throws IOException{
    String[] kazu = {"1","2","3","4","5","6","7","8","9"};
    String[] color = {"黒","白"};
    int[] status = new int[81];
    p1 = new Player(1); //プレイヤー１
    p2 = new Player(2); //プレイヤー２
    pw = p1;            //pw=作業用オブジェクト
    while(true){  //ゲーム内容をループさせる
      for(int i = 0 ; i < status.length ; i++){ //配列の初期化
				status[i] = 0;
			}
			for(int i=0 ; i < board.length ; i++){    //置ける位置の初期化
				for(int j = 0 ; j < board[i].length ; j++){
					if(board[i][j] == 3){
						board[i][j] = 0;
					}
				}
			}
			//置ける場所チェック
			for(int i = 0 ; i < board.length ; i++){
				for(int j = 0 ; j < board[i].length ; j++){
					if(board[i][j] == 0){ //コマが置かれていない場所をチェック
						if(check_change(i,j,pw.color,"check")){//置ける時
							board[i][j] = 3;
						}
					}
				}
			}
      //盤面に表示する
      System.out.print("　");
			for(int i = 0 ; i < board.length ; i++){
				System.out.print(kazu[i]);
			}
			System.out.println();
			for(int i = 0 ; i < board.length ; i++){
				System.out.print(kazu[i]);
				for(int j = 0 ; j < board[i].length ; j++){
					switch(board[i][j]){
					case 0://なにも無い
						System.out.print("ー");
						break;
					case 1://黒の時
						System.out.print("●");
						break;
					case 2://白の時
						System.out.print("◯");
						break;
					case 3://置ける時
						System.out.print("？");
						break;
					}
				}
				System.out.println();
			}
    }
  }
  static boolean check_change(int i,int j,int color){
    for(int r=-1; r<2 ;r++){
      //続きはここから。
    }
  }
}
class Player{
  int color;// 1=黒, 2=白
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  Player(int color){
    this.color = color;
  }
  int[] getPoint() throws IOException{
    int[] point = {0,0}; //point[0]=横、point[1]=縦
    String str;
    do{
      System.out.print("横の位置に置く場所を入力してください 1〜9");
      str = br.readLine();
      if(str.isEmpty()){  //何も入力されなかったとき
          point[0] = 1;
      }else{
          point[0] = Integer.parseInt(str);
      }
      point[0]--;
    }while(point[0]<0 || point[0]>8);
    do{
      System.out.print("縦の位置に置く場所を入力してください 1〜9");
      str = br.readLine();
      if(str.isEmpty()){  //何も入力されなかったとき
        point[1] = 1;
      }else{
        point[1] = Integer.parseInt(str);
      }
      point[1]--;
    }while(point[1]<0 || point[1]>8);
  return point;
  }
}
