
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

class UDPClient {
    public static void main(String args[]) throws Exception
    {

      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.i$

      DatagramSocket clientSocket = new DatagramSocket();

      InetAddress IPAddress = InetAddress.getByName("10.49.139.147");//this is what$

      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];
      int state = 0;

      String message = "This is Red, Test";
      String response = "";

      DatagramPacket sendPacket = null;
      DatagramPacket recievePacket = null;


     // String sentence = inFromUser.readLine();



        sendData = message.getBytes();

      //Main loop
        while( state < 3){
                //sendData = new byte[1024];
                //recieveData = new byte[1024];

                switch(state){

                        case 0:
                        //Here send initial message


                sendPack = new DatagramPacket(sendData, sendData.length, IPAddress,$
                clientSocket.send(sendPack);
                recievePacket = new DatagramPacket(recieveData, receiveData.length);




                clientSocket.recieve(recievePacket);

                String response = new String(recievePacket.getData());
	
                if(response.substring(0,3).equals("100")) {
                  state = 1; //You are the first clent.  wait for second client
                }
                else if(response.substring(0,3).equals("200")){
                 state = 2; //You are second client. Wait for message from first
                }
                System.out.println("Server Message: " + response);
                break;
          case 1: // Wait for notification that the second client is ready
                clientSocket.recieve(receivePacket);
                response = new String(receievePacket.getData());

                if(response.substring(0,3).equals("200")){
                        state = 2; //transition to state 2: chat mode
                }
                break;

          case 2:
                //Chat mode
                //Recieve message from other client
       //Check for Goodbye message

                clientSocket.recieve(receivePacket);
                response = new String(receievePacket.getData());

                if(response.length()>=7 && response.substring(0,7).equals("Goodbye"$
                   state = 3; // prepare to exit the while loop
                 break;
                }

                System.out.println("From Other user: " + response);
                message = inFromUser.readLine();
                sendData = message.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
                clientSocket.send(sendPacket);
                //if not Goodbye, get next message from user and send it;

                //stay in state 2
                break;
                }//end switch
        }// end while
}

}

}
}}}
        //Close the socke



      sendData = sentence.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

      clientSocket.send(sendPacket);

      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	clientSocket.receive(receivePacket);

      String modifiedSentence = new String(receivePacket.getData());

      System.out.println("FROM SERVER:" + modifiedSentence);

      clientSocket.close();
      }
}
	
