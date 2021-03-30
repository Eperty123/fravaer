package DAL.DB;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Author: Jonas Buus Nielsen
 * Version: 1.0
 */

public class UserDAL {
    private DbConnectionHandler dbCon = DbConnectionHandler.getInstance();

    public UserDAL() throws IOException {
    }


    public void addUser(String firstName, String lastName, String userName, String password, int role) {

        try (Connection con = dbCon.getConnection()) {

            PreparedStatement pSql = con.prepareStatement("INSERT INTO [User] VALUES(?,?,?,?)");
            pSql.setString(1, firstName);
            pSql.setString(2, lastName);
            pSql.setString(3, password);
            pSql.setInt(4, role);

            pSql.execute();

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    /**
     * By default, all lectures are added to a student, with the attendance set to 0 (false).
     * This method sets the attendance value to 1 (true), and uses userId and lectureId as identifiers.
     * @param userId
     * @param lectureId
     */
    public void addAttendanceRegistration(int userId, int lectureId) {

        try(Connection con = dbCon.getConnection()){

            PreparedStatement pSql = con.prepareStatement("UPDATE Attendance SET Attended=? WHERE UserId=? AND LectureId=?");
            pSql.setInt(1,1);
            pSql.setInt(2,userId);
            pSql.setInt(3, lectureId);
            pSql.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
