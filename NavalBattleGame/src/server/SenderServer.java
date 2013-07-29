package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import protocol.RequestValidator;
import system.GameBoard;
import system.Build;

public class SenderServer {


	public static void main(String[] args) throws IOException {
		
		GameBoard board = new GameBoard(10, 10);
		Build build = new Build(board);
		
		Scanner input = new Scanner(System.in);
		System.out.println("----BEM - VINDO -------");
		System.out.println();
		System.out.println("Adicione os barcos");
		System.out.println("SUBMARINO:");
		System.out.println("Informe a primeira linha: ");
		int rowSub = input.nextInt(); input.nextLine();
		System.out.println("Informe a primeira coluna: ");
		int colSub = input.nextInt(); input.nextLine();
		
		build.addSubmarine(rowSub, colSub);
		board.printBoard();
		
		
		System.out.println("Servidor inicializado.");
		ServerSocket server = new ServerSocket(10999);
		System.out.println("Aguardando conexão...");
//		Socket socket = server.accept();
//		System.out.println(socket);
		
		Socket socket;
		while ((socket = server.accept()) != null){
			InputStream in = socket.getInputStream();
			//leitura do stream
			byte[] b = new byte[5];
			System.out.println("Tamanho do stream: " + b.length);
			System.out.println(in.read(b));
			//
			String command = new String(b);
			String c = command.trim();
			System.out.println(command);
			
			RequestValidator rs = new RequestValidator();
			
			try {
				rs.valid(command);
				
				String [] com = command.split(",");
				int row = Integer.parseInt(com[0]);
				int col = Integer.parseInt(com[1]);
				
				String shot = board.checkShoot(row, col);
				OutputStream out = socket.getOutputStream();
				out.write(shot.getBytes());
				out.flush();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			if (board.getQuantityOfBoat() == 3){
				socket.close();
				break;
			}			
		}
		//
		System.out.println("Servidor encerrado.");
	}

}
