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
