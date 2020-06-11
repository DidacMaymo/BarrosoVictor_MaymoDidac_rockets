package com.rockets.app.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rockets.app.application.dto.ScoreDTO;
import com.rockets.app.domain.Score;
import com.rockets.app.utilities.InvalidParamException;

public class ScoreRepository {
	public static void storeScore(Score score) throws Exception {
		try{
			ConnectionBBDD connection = ConnectionRepository.getConection();    
			String sql = "Insert into SCORES (CIRCUIT_ID,ROCKET_ID,TIME_TAKEN,METERS_TRAVELLED) values (?,?,?,?)";
			
			PreparedStatement pst = connection.prepareStatement(sql); 
			pst.clearParameters();
			pst.setString(1, score.getCircuitId());
			pst.setString(2, score.getRocketId());
			pst.setString(3, String.valueOf(score.getTimeTaken()));
			pst.setString(4, String.valueOf(score.getMetersTravelled()));
			
			if (pst.executeUpdate() != 1) { 
				throw new InvalidParamException(); 
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidParamException();
		}
	}

	public static Score getScore(String id) throws Exception { 
		ConnectionBBDD connection = ConnectionRepository.getConection(); 
		try {
			String sql = "SELECT* FROM SCORES WHERE ID = ?";	
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.clearParameters(); 
			preparedStatement.setString(1, id);
			ResultSet rs =  preparedStatement.executeQuery(); 
			
			if(rs.next()) { 
				String circuitId = rs.getString("CIRCUIT_ID");
				String rocketId = rs.getString("ROCKET_ID");
				String timeTaken = rs.getString("TIME_TAKEN");
				String metersTravelled = rs.getString("METERS_TRAVELLED");
				return new Score(circuitId, rocketId, Double.parseDouble(timeTaken),
						Double.parseDouble(metersTravelled)); 
			}
			throw new Exception();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		}		
	}

	public static void updateScore(String id, ScoreDTO scoreDTO) throws Exception {
		ConnectionBBDD connection = ConnectionRepository.getConection();
		try {
			String sql =  "UPDATE SCORES SET ROCKET_ID=?, TIME_TAKEN=?, METERS_TRAVELLED=? WHERE CIRCUIT_ID=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.clearParameters();
			pst.setString(1, id);
			pst.setString(2, scoreDTO.getRocketId());
			pst.setString(3, String.valueOf(scoreDTO.getTimeTaken()));
			pst.setString(4, String.valueOf(scoreDTO.getMetersTravelled()));
			
			if (pst.executeUpdate() != 1) { 
				throw new Exception(); 
			}
		}catch (Exception e) {
			throw new InvalidParamException();
		}
		
	}
}
