# Music-Advisor
It was developed a simple application “Music Advisor” that offers music using Spotify.  It was implemented the ability to register users using third-party services. 
To implement the functionality Spotify’s API is used, REST (Representational State Transfer) was used to provide the ability to interact with the service.	

Developed application allows reading user input and providing information at the user's request. OAuth protocol used for user’s authorization.  
Local http server created to listen for incoming TCP connections from clients on 8080 port to get a response code from the URL in the user's browser. 

 GET and POST requests were used to get the Spotify access token and to send requests to Spotify API. To parse responses in JSON format GSON library was used. 
MVC pattern was used to separate data and presentation. 
•	Client.java – represents Model ;
•	Pagination.java – represents View;
•	MusicAdvisor.java – represents Controller; 

Paginated output that will display 5 entries per page was created. Using the commands next (see the next page) and prev (see the previous page). 
