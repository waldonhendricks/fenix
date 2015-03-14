package com.uk.pattern.eventdriven;

public interface Channel<E extends Message> {
	public void dispatch(E message);
}
