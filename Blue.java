

/**
*       UDP Client/**
*       UDP Client Program
*       Connects to a UDP Server
*       Receives a line of input from the keyboard and sends it to the server
*       Receives a response from the server and displays it.
*
*       @author: Kevin Moreno and Mohammad Alsoheem
*       ID:     14508
*       Email:  Moren162@mail.chapman.edu and Alsoh102@mail.chapman.edu
*       Date:   9/27/2017
@       version: 2.1
*/

import java.io.*;
import java.net.*;

class Blue {
    public static void main(String args[]) throws Exception
    {

      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

      DatagramSocket clientSocket = new DatagramSocket();

      InetAddress IPAddress = InetAddress.getByName("localhost");//this is where the address go

      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];
      int state = 0;

      String message = "Hello Blue";
      String response = "";

      DatagramPacket sendPacket = null;
      DatagramPacket receivePacket = null;


     // String sentence = inFromUser.readLine();



        

      //Main loop
        while( state < 3){
                sendData = new byte[1024];
                receiveData = new byte[1024];

                switch(state){

                        case 0:
                        //Here send initial message
		sendData = message.getBytes();

                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9874);
                clientSocket.send(sendPacket);
		receiveData = response.getBytes();
                receivePacket = new DatagramPacket(receiveData, receiveData.length);



	
                clientSocket.receive(receivePacket);

                //String response = new String(recievePacket.getData());
	
                if(response.substring(0,3).equals("100")) {
                  state = 1; //You are the first clent.  wait for second client
                }
                else if(response.substring(0,3).equals("200")){
                 state = 2; //You are second client. Wait for message from first
                }
                System.out.println("Server Message: " + response);
                break;
          case 1: // Wait for notification that the second client is ready
                clientSocket.receive(receivePacket);
                response = new String(receivePacket.getData());

                if(response.substring(0,3).equals("200")){
                        state = 2; //transition to state 2: chat mode
                }
                break;

          case 2:
                //Chat mode
                //Recieve message from other client
       //Check for Goodbye message

                clientSocket.receive(receivePacket);
                response = new String(receivePacket.getData());

                if(response.length()>=7 && response.substring(0,7).equals("Goodbye")) {
                   state = 3; // prepare to exit the while loop
                 break;
                }

                System.out.println("From Other user: " + response);
                message = inFromUser.readLine();
                sendData = message.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9874);
                clientSocket.send(sendPacket);
                //if not Goodbye, get next message from user and send it;

                //stay in state 2
                break;
                }//end switch
        }// end while
    }
}
