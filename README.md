# fenix



Design Pattern Project

Java provides a standard API (java.nio) which could be used to design non-blocking IO systems. I will explain the Reactor pattern with a simple client server model where the clients will shout out their names to the server while the server will respond to the corresponding client with a Hello message.

There are two important participants in the architecture of Reactor Pattern.

1. Reactor  

A Reactor runs in a separate thread and its job is to react to IO events by dispatching the work to the appropriate handler. Its like a telephone operator in a company who answers the calls from clients and transfers the communication line to the appropriate receiver. Don't go too far with the analogy though :).

2. Handlers

A Handler performs the actual work to be done with an IO event similar to the actual officer in the company the client who called wants to speak to.

Since we are using java.nio package, its important to understand some of the classes used to implement the system. I will simply repeat some of the explanations by Doug Lea in his lecture sides to make the readers lives easy :).

Channels

These are connections to files, sockets etc. that support non blocking reads. Just like many TV channels can be watched from one physical connection to the antena, many java.nio.channels.SocketChannels corresponding to each client can be made from a single java.nio.channels.ServerSocketChannel which is bound to a single port.

Buffers

Array-like objects that can be directly read or written to by Channels.

Selectors

Selectors tell which of a set of Channels has IO events.

Selection Keys

Selection Keys maintain IO event status and bindings. Its a representation of the relationship between a Selector and a Channel. By looking at the Selection Key given by the Selector, the Reactor can decide what to do with the IO event which occurs on the Channel.
