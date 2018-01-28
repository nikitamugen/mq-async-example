# about

This app is an example of client-server message exchange above mq-queue.
Client part is the console app. That receives commands from the user and sends them to the queue on the server.
The commands is simple:

1. `add [key] [value 1] ... [value n]` - create add messages for each value and specified key.
2. `get [key]` - create get message for show all values for the key.
2. `delete [key] [value 1] ... [value n]` - create delete messages.

# server

To build just make

```sh
$ cd server
$ gradle build 
```

Then find artifact at `build/lib` and run it with:

```sh
$ java -jar server.jar --port=61616
```
There `61616` is the port wich listening this example-app.

# client

To build just make

```sh
$ cd client
$ gradle build 
```
Then find artifact at `build/lib` and run it with:

```sh
$ java -jar client.jar localhost 61616
```

The fitst argument (`localhost`) is the host to connect to the server, and the second (`61616`) is the port.
