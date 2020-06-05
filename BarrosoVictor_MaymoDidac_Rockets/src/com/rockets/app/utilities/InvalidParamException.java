package com.rockets.app.utilities;

public class InvalidParamException extends Exception { 
	//usem per que la informacio que arriba als models sigui valida, es una exception que usa ell que s'ha creat
	//fa la mateixa ufncio que les altres pero es per tu saber quin error es perq tots es dirien igual i per saber de quina classe ve o el que siugi
	public InvalidParamException() {
		super();
	}
}