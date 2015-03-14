package com.uk.pattern.eventdriven;

public interface Message {
	public Class<? extends Message> getType();
}
