package com.uk.pattern.eventdriven.impl;

import com.uk.pattern.eventdriven.Channel;

public class Handler implements Channel<Event> {

	@Override
	public void dispatch(Event message) {
		System.out.println(message.getClass());
	}
}
