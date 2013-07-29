package system;

public class App {

	public static void main(String[] args) {

		GameBoard GB1 = new GameBoard(10, 10);
		GameBoard GB2 = new GameBoard(10, 10);

		Build P1 = new Build(GB1);
		Build P2 = new Build(GB2);
		
		GB1.buildBoard();

		GB1.printBoard();
		System.out.println();
		P1.addBattleship(2, 2);
		GB1.printBoard();
		System.out.println();
		P1.addFrigate(9, 8);
		GB1.printBoard();
		System.out.println();
		P1.addSubmarine(2, 5);
		GB1.printBoard();
		System.out.println();
		GB1.printBoard();
		System.out.println();
		//P1.shoot(2, 2);
		GB1.printBoard();
		System.out.println();
		System.out.println(GB1.checkShoot(2, 2).toString());
		GB1.printBoard();
		
		
	}
}
