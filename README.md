# ServerClientDNS
A Server that receives requests from Clients about DNS entries and replies to them.
This program runs locally (localhost) but it simulates a real server-client communication. 
Every entity (server or clients) is a java thread.
Every client has several options:

-N: Search by Name. Checks every DNSEntry item in list and if there is the domain name returns the IP address

-A: Search by Address (IP). Checks every DNSEntry item in list and if there is the IP returns the domain name

-I: Insert an entry. User types IP and domain name. Program checks if there is a same entry and adds it to directory.

-D: Delete an entry. User types IP or domain name for delete. Program searches for that entry and deletes it. 

-U: Update an entry. User types new IP address and old domain name (or the opposite). Program makes the changes.

Server processes the DNS directory and replies to client. 

***WARNING***
It's crucial to run Server class first and then the Client class. 

