package com.uk.pattern.eventdriven.impl;

import com.uk.pattern.eventdriven.Message;

public class Event implements Message {

	@Override
	public Class<? extends Message> getType() {
		return getClass();
	}
}
