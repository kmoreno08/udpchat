/**
*	UDP Server Program
*	Listens on a UDP port
*	Receives a line of input from a UDP client
*	Returns an upper case version of the line to the client
*
*	@author: Michael Fahy
*	ID:	14508
*	Email:	fahy@chapman.edu
*	Date:	9/12/2017
@	version: 2.0
*/

import java.io.*;
import java.net.*;

class UDPServer {
  public static void main(String args[]) throws Exception
    {

    DatagramSocket serverSocket = null;
	  
	try
		{
			serverSocket = new DatagramSocket(9876);
		}
	
	catch(Exception e)
		{
			System.out.println("Failed to open UDP socket");
			System.exit(0);
		}

      byte[] receiveData = new byte[1024];
      byte[] sendData  = new byte[1024];

      while(state < 3)
        {
	recieveData = new byte[1024];
	sendData = new byte[1024];
	
	switch (state) {
	case 0:
		receivePacket = new DatagramPacket(recieveData, receiveData.length);
		serverSocket.receive(receivePacket);
		String recPacket = new String(receivePacket.getData());

		IPAdressGetAddress = receivedString.getAddress());
		port1 = receivePacket.getPort();

		send = "100".getBytes();
		sendP = new DatagramPacket(send, send.length, IPAdressGetAddress, port1);
		
		serverSocket.send(sendP);
		state = 1;
}
}

	

        /*  DatagramPacket receivePacket =
             new DatagramPacket(receiveData, receiveData.length);
           serverSocket.receive(receivePacket);
          String sentence = new String(receivePacket.getData());

          InetAddress IPAddress = receivePacket.getAddress();

          int port = receivePacket.getPort();

          String capitalizedSentence = sentence.toUpperCase();

          sendData = capitalizedSentence.getBytes();

          DatagramPacket sendPacket =
             new DatagramPacket(sendData, sendData.length, IPAddress,
                               port);

          serverSocket.send(sendPacket);
        }
    }
}*/
