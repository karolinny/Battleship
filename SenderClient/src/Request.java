
public class Request {

	private String row, col;
	
	public Request(String row, String col){
		this.row = row;
		this.col = col;
	}
	
	private String format(String v){
		if(v.length() != 2 ){
			return "0" + v;
		}
		return v;
	}
	
	public String getValue(){
		return format(row) + "," + format(col);
	}
}
