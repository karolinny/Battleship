import java.io.InputStream;

public class RequestValidator {

	public static void valid(InputStream in) throws Exception{
		byte[] b = new byte[5];
		in.read(b);
		String r  = new String(b);
		if(r.contains(",")){
			if(r.indexOf(",") == 2){
				String[] a = r.split(",");
				try{

					int row = Integer.valueOf(a[0]);
					int col = Integer.valueOf(a[1]);
					boolean v = row > 0 && col > 0 && row < 11 && col < 11;
					if(!v){
						throw new Exception();
					}
				}
				catch(NumberFormatException e){
					throw new Exception();
				}
			}else {
				throw new Exception();
			}
		}
		else{
			throw new Exception();
		}
	}
}
