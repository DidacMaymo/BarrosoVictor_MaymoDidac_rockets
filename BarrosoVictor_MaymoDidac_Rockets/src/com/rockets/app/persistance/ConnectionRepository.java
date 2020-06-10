package com.rockets.app.persistance;

import com.rockets.app.utilities.ConstantUtilities;

public class ConnectionRepository {
private static ConnectionBBDD connection;
	
	public static ConnectionBBDD getConection() throws Exception{
		if(connection == null) {
			connection = new ConnectionBBDD(ConstantUtilities.USERNAME_BBDD, ConstantUtilities.PASSWORD_BBDD);
		}
		return connection;
	}
}
