package com.rockets.app.utilities;


public interface ISubject {
	
	public void addObserver(IObserver observer) throws InvalidParamException;
	
	public void notifyallObservers(String str);

}
