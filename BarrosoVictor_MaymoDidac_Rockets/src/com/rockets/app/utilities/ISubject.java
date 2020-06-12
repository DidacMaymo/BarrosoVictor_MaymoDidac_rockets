package com.rockets.app.utilities;

public interface ISubject {

	public void addObserver(IObserver observer) throws InvalidParamException;

	void notifyallObservers(String s);

}
