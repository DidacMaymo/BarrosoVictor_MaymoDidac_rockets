package persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utilities.InvalidParamException;
import utilities.NotFoundException;

public class RocketsRepository {
	public static void storePicture(Picture picture) throws Exception {

		ConnectionBBDD connection = ConnectionRepository.getConnection();
		try {
			String sql = "Insert into PICTURES (ID,IMAGE_URL,NAME) values (?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, picture.getId());
			pst.setString(2, picture.getImageURL());
			pst.setString(3, picture.getName());

			if (pst.executeUpdate() != 1)
				throw new InvalidParamException();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidParamException();

		}

	}

	public static Picture getPicture(String id) throws Exception {
		ConnectionBBDD connection = ConnectionRepository.getConnection();

		try {
			String sql = "SELECT * FROM PICTURES WHERE ID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.clearParameters();
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				String imageId = rs.getString("ID");
				String imageUrl = rs.getString("IMAGE_URL");
				String imageName = rs.getString("NAME");

				return new Picture(imageId, imageUrl, imageName);
			}
			throw new NotFoundException();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidParamException();

		}

	}

	public static void updatePicture(String id, PictureDTO pictureDTO) throws Exception {
		ConnectionBBDD connection = ConnectionRepository.getConnection();

		try {
			String sql = "UPDATE PICTURES SET IMAGE_URL=?, NAME=? WHERE ID=?";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setString(1, pictureDTO.getImageURL());
			pst.setString(2, pictureDTO.getName());
			pst.setString(3, id);

			if (pst.executeUpdate() != 1)
				throw new NotFoundException();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidParamException();

		}
	}
}
