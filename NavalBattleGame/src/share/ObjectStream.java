package share;

import java.io.Serializable;

public class ObjectStream implements Serializable{
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}