package system;

public class Build {
	
	private GameBoard board;
	
	public Build(GameBoard board){
		this.board = board;
	}
	
	public void addSubmarine(int rowFirst, int columnFirst) {
		board.checkLimitsCoordinated(Boat.SUBMARINE.getBoatSize(), rowFirst, columnFirst);
		board.checkFieldEmpty(Boat.SUBMARINE.getBoatSize(), rowFirst, columnFirst);
		board.addBoatGeneric(Boat.SUBMARINE.getBoatSize(), rowFirst, columnFirst);

	}

	public void addFrigate(int rowFirst, int columnFirst) {
		board.checkLimitsCoordinated(Boat.FRIGATE.getBoatSize(), rowFirst, columnFirst);
		board.checkFieldEmpty(Boat.FRIGATE.getBoatSize(), rowFirst, columnFirst);
		board.addBoatGeneric(Boat.FRIGATE.getBoatSize(), rowFirst, columnFirst);
	}

	public void addBattleship(int rowFirst, int columnFirst) {
		board.checkLimitsCoordinated(Boat.BATTLESHIP.getBoatSize(), rowFirst, columnFirst);
		board.checkFieldEmpty(Boat.BATTLESHIP.getBoatSize(), rowFirst, columnFirst);
		board.addBoatGeneric(Boat.BATTLESHIP.getBoatSize(), rowFirst, columnFirst);
	}

	public void CreateBoard(int subRow, int subCol, int friRow, int friCol, int batlRow, int batlCol){
		this.addSubmarine(subRow, subCol);
		this.addFrigate(friRow, friCol);
		this.addBattleship(batlRow, batlCol);
	}
	
}
