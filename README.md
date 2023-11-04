# PS5 JAR SandBox/App0 Dumper for 5.00-7.61
This project is an adaptation of projects from john-tornblom for an adapted JAR loader for set-top boxes with firmware versions up to 7.61

# How to Use
1. Change local ipv4 adress in source code and compile
 
   String serverAddress = "192.168.0.11";

   where 192.168.0.11 - your local ipv4 adress on computer.
   
   Open cmd and say "ipconfig".
   
   Ethernet Ethernet Adapter:
   
    IPv4 address. . . . . . . . . . . . : 192.168.0.11
   
1. Connect your PS5 to the same network as your computer.
2. Burn the ISO image of the loader JAR to a BD-RE disc. A BD-R disc is also possible, but this disc is a one-time recording only
   
   https://github.com/hammer-83/ps5-jar-loader/releases/download/v20231027/ps5-jar-loader.iso
3. Insert the disc with the recorded image into your PS5 console and press play. You should see a message about waiting for a JAR file on ip:port
4. On your computer, open a BASH console and enter the following command

   sudo java --add-opens java.base/jdk.internal.loader=ALL-UNNAMED -jar xploit.jar 192.168.0.13

   where 192.168.0.13 - your local ipv4 address of your PS5 console. Usually this IP address is output by the JAR loader itself.
   
   On your PS5 console you will see a socket connection wait
5. Open another BASH console on your computer and enter the following command

   nc -l 22052 > app0.zip

   where 22052 - your port from JAR payload

   If you did not change the port in the source code, then leave it the same
6. At the end of data collection, payload will automatically close the connection to the server and display a message about the successful sending of the file on your console

# Prerequisites Compile
JDK 11 (PS5 uses Java 11 runtime)

Apache Maven

IntelliJ IDEA Community Edition (optional, but recommended)

# Credits
https://github.com/hammer-83/ps5-jar-loader - for updated jar loader

https://github.com/john-tornblom/bdj-sdk/tree/master - for payloads
