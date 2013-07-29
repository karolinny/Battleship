
package system;

import exception.CoordinatesWrongException;
import exception.LocalBusyException;

/* Written by Karol Abreu - 29/05/2013
 * @Class GameBoard - Class responsible for modifications 
 * made to the board's individual player involved 
 * in the game.
 * 
 */
public class GameBoard {

	private int boardSize[][];
	private int row, column, quantityOfBoat;

	public GameBoard(int row, int column) {
		this.row = row;
		this.column = column;
		this.boardSize = new int[row][column];
		this.quantityOfBoat = 0;
	}
	
	public int getQuantityOfBoat(){
		return this.quantityOfBoat;
	}

	public void buildBoard() {
		for (int row = 0; row < this.row; row++) {
			for (int column = 0; column < this.column; column++) {
				this.boardSize[row][column] = 0;
			}
		}
	}

	public void checkLimitsCoordinated(int qtde, int rowFirst, int columnFirst) {
		for (int i = 0; i < qtde; i++) {
			if ((rowFirst > this.row - 1)
					|| (i + columnFirst > this.column - 1))
				throw new CoordinatesWrongException(
						"Your boat exceeds the coordinates");
		}
	}
	
	public void addBoatGeneric(int quantity, int rowFirst, int columnFirst){
		for(int i = 0; i < quantity; i++){
			this.boardSize[rowFirst][i + columnFirst] = quantity;
			this.quantityOfBoat++;
		}
	}

	public void checkFieldEmpty(int quantity, int rowFirst, int columnFirst) {
		for (int i = 0; i < quantity; i++) {
			if ((this.boardSize[rowFirst][i + columnFirst] != 0))
				throw new LocalBusyException(
						"There is already a boat that coordinate");
		}
	}

	
	
	public String checkShoot(int rowShot, int columnShot) {
		String shot = "0";

		for (int row = 0; row < this.row; row++) {
			for (int column = 0; column < this.column; column++) {
				if ((rowShot == row && columnShot == column)&& (this.boardSize[row][column] != 0) &&(this.boardSize[row][column] > 0)) {
					this.eliminatesVessel(rowShot, columnShot);
					shot = "1";
				} else
					shot = "0";
			}
		}
		return shot;
	}

	public void eliminatesVessel(int rowShot, int columnShot) {
		int valueBoat = this.boardSize[rowShot][columnShot];

		for (int row = 0; row < this.row; row++) {
			for (int column = 0; column < this.column; column++) {
				if (this.boardSize[row][column] == valueBoat) {
					this.boardSize[row][column] = -1;
				}
			}
		}
		this.quantityOfBoat++;
	}

	public int[][] viewBoard() {
		int aux[][] = new int[this.row][this.column];

		for (int row = 0; row < this.row; row++) {
			for (int column = 0; column < this.column; column++) {
				aux[row][column] = this.boardSize[row][column];
			}
		}
		return aux;
	}

	public void printBoard() {
		for (int row = 0; row < this.row; row++) {
			for (int column = 0; column < this.column; column++) {
				System.out.printf("%d ", this.boardSize[row][column]);

			}
			System.out.println();
		}
	}

}
