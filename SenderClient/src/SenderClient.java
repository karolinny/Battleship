import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SenderClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		int contador = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Cliente inicalizado e conectando.");
		do{
		Socket client = new Socket("10.3.2.217", 10999);
		System.out.println("Cliente conectado...");
		
		System.out.println("Escrevendo no stream e enviando....");
		
		System.out.println("Informe a posição do tiro: ");
		String tiro = in.nextLine();
		
		OutputStream out = client.getOutputStream();
		out.write(tiro.getBytes());
		out.flush();
		System.out.println("deu certo");

		InputStream inp = client.getInputStream();
		byte[] entrada = new byte[1];
		inp.read(entrada);
		String qlqr = new String(entrada);
			if(qlqr.equals("1")){
				++contador;
				System.out.println("FIRE !! Congratulations you hit a boat");
			}else{
				System.out.println("WATER !! There was this time");}
	}while(contador < 3);
		
		System.out.println("Congratulations you hit all boat");
	}
}
