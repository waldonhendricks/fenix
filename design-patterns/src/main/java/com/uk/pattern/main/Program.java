package com.uk.pattern.main;

import com.uk.pattern.eventdriven.impl.Event;
import com.uk.pattern.eventdriven.impl.EventDispatcher;
import com.uk.pattern.eventdriven.impl.Handler;

public class Program {
	public static void main(String[] args) {
		EventDispatcher dispatcher = new EventDispatcher();
		dispatcher.registerChannel(Event.class, new Handler());
		dispatcher.dispatch(new Event());
	}
}
