import java.util.Random;
public class TortoiseHare {
	private static int counter;
	private static int hPos;
	private static int tPos;
	private int randNum;
	private Random num = new Random();
	
	TortoiseHare(){
		hPos = 0;
		tPos = 0;
		
		System.out.println("ON YOUR MARK, GET SET\nBANG !!!!!\nAND THEY'RE OFF !!!!!");
	}
	
	public void tortoiseMove(){
		randNum = num.nextInt(10) + 1;
		
		if(randNum >= 1 && randNum <= 5){
			tPos = tPos + 3;
		}
		
		else if(randNum >= 6 && randNum <= 7){
			tPos = tPos - 6;
		}
		
		else if(randNum >= 8 && randNum <= 10){
			tPos = tPos + 1;
		}
		
		if(tPos < 0){
			tPos = 0;
		}
	}
	
	public void hareMove(){
		randNum = num.nextInt(10) + 1;
		
		if(randNum >= 1 && randNum <= 2){
			hPos = hPos + 0;
		}
		
		else if(randNum >= 3 && randNum <= 4){
			hPos = hPos + 9;
		}
		
		else if(randNum == 5){
			hPos = hPos - 12;
		}
		
		else if(randNum >= 6 && randNum <= 8){
			hPos = hPos + 1;
		}
		
		else if(randNum >= 9 && randNum <= 10){
			hPos = hPos - 2;
		}
		
		if(hPos < 0){
			hPos = 0;
		}
	}
	
	public void currentPos(){
		System.out.printf("\nTime: %d\n", counter );
		
		for(int i = 0; i < 70; i++){
			if(tPos == hPos && (i == tPos  && i == hPos)){
				System.out.print('B');
				continue;
			}
			else if(i == tPos){
				System.out.print('T');
			}
					
			else if (i ==hPos)
			{
				System.out.print('H');
			}
			System.out.print(' ');
		}
		System.out.print("\n");		
		for(int j = 0; j < 70; j++)
			System.out.print("-");
		counter++;
	}
	
	public void results(){
		if (tPos >= 69 && hPos >= 69)
			System.out.println("\nIt's a tie!");
		else if (tPos >= 69)
			System.out.println("\nTORTOISE WINS!!! YAY!!!");
		else
			System.out.println("\nHare wins. Yuch");
		
		System.out.printf("Time Elapsed = %d seconds", counter-1);
	}
	
	public static void main(String args[]){
		
		TortoiseHare game = new TortoiseHare();
		
		while(!(tPos >= 69 || hPos >= 69)){
			game.currentPos();
			game.tortoiseMove();
			game.hareMove();			
		}
		game.results();
	}
}
