package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectSenderServer {


	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("Servidor inicializado.");
		ServerSocket server = new ServerSocket(10999);
		System.out.println("Aguardando conexão...");
		Socket socket = server.accept();
		InputStream in = socket.getInputStream();
		//leitura do stream
		ObjectInputStream oin = new  ObjectInputStream(in);
		//
		System.out.println("Recebendo o objeto.");
		System.out.println(oin.readObject());
		//ObjectStream o = (ObjectStream) oin.readObject();
		//System.out.println("Conteúdo do objeto: " + o.getName());
		//
		System.out.println("Servidor encerrado.");
	}

}
