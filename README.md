# Web_Streaming_Media_Player_using_Nodejs

Controller:<br />
The controller resides on a mobile device (android) which provides user interface to the user and receives commands from the user. It redirects to the local server in a laptop where we can select the media (audio or video) which we want to play, pause, stop, forward, or rewind in the renderer (laptop).<br />
<br />
Renderer:<br />
This entity resides in a laptop and receives request from the controller. Renderer requests media (e.g. a song or a video clip) from the Server and render the contents under the control of the Controller.<br />
<br />
Server:<br />
Server manages and provides media (e.g. audio or video) to the Renderer. It also receives requests from the Controller for media management.<br />
<br />
<br />
NETWORK INVOLVED<br />
The network involved is WiFi (Wireless) which is a local area wireless technology that allows devices to exchange data. We designed our server and created a network depending on two protocols HTTP 1.1 and Websocket protocol.<br />
WORKING<br />
We have three entities working together server, controller and renderer in our project. They are all connected to each other through the network, which we have designed. The server and renderer reside in a laptop and we use a mobile device for controller. All of them are interconnected in such a way that there is a continuous link generation between them. Connection between the entities is kept alive by the protocols we are using.<br />
<br />
CHALLENGES FACED AND OVERCOMES:<br />
1.	Deciding on which protocol should be used for the purpose.<br />
	After a lot of research, we concluded that websocket protocol was appropriate when bi directional communication was needed between renderer and controller and also between server and controller.<br />
2.	Deciding on which platform it has to be done. <br />
	Node.js is easy to modify and maintain, high Productivity and high performance.<br />
3.	Fetching data from the database (Media files).<br />
	We created continuous connection between entities using java script based socket programming.<br />
4.	Designing of media player.<br />
	We used HTML based media player and created continuous streaming connection between entities.<br />
5.	The design of the controller.<br />
6.	Designing an android application.<br />
