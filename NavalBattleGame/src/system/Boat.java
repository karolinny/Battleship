package system;


public enum Boat {

  SUBMARINE(1), FRIGATE(2), BATTLESHIP(3);
  
  private final int boatSize;
  
  	  Boat(int boatSize){
  		  this.boatSize = boatSize;
      }
  	  
	  public int getBoatSize(){
		  return this.boatSize;
	  }
  };