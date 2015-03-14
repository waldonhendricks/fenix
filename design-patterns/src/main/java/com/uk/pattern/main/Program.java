package com.uk.pattern.main;

import java.io.IOException;

import com.uk.pattern.eventdriven.impl.Event;
import com.uk.pattern.eventdriven.impl.EventDispatcher;
import com.uk.pattern.eventdriven.impl.Handler;
import com.uk.pattern.reactor.Reactor;

public class Program {
	public static void main(String[] args) {
		EventDispatcher dispatcher = new EventDispatcher();
		dispatcher.registerChannel(Event.class, new Handler());
		dispatcher.dispatch(new Event());
		
		
		Reactor reactor;
		try {
			reactor = new Reactor(9900, false);
			new Thread(reactor).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
