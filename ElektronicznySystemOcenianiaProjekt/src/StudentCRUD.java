import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
public class StudentCRUD {
    public void addStud( String imie, String nazwisko, String login, String haslo, String email, int rok){
        String sql = "INSERT INTO studenci( imie, nazwisko, login, haslo, email, rok) VALUES (?, ?, ?, ?, ?, ?)";
        try(Connection con = DBpolaczenie.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, imie);
            pstmt.setString(2, nazwisko);
            pstmt.setString(3, login);
            pstmt.setString(4, haslo);
            pstmt.setString(5, email);
            pstmt.setInt(6, rok);
            pstmt.executeUpdate();
        } catch (SQLException e){
                e.printStackTrace();
        }
    }
    public ResultSet infoStudent(){
        String sql = "SELECT * FROM studenci";
        try{
            Connection con = DBpolaczenie.getConnection();
           Statement stmt = con.createStatement();
           return stmt.executeQuery(sql);}
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void updateStud(String imie, String nazwisko, String login, String haslo, String email, int rok, int student_id){
        String sql = "UPDATE studenci SET  imie = ?, nazwisko = ?, login = ?, haslo = ?, email= ?, rok = ? WHERE student_id = ?";
        try(Connection con = DBpolaczenie.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, imie);
            pstmt.setString(2, nazwisko);
            pstmt.setString(3, login);
            pstmt.setString(4, haslo);
            pstmt.setString(5, email);
            pstmt.setInt(6, rok);
            pstmt.setInt(7, student_id);
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteStud(int student_id){
        String sql = "DELETE FROM studenci WHERE student_id = ?";
        try (Connection con = DBpolaczenie.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, student_id);
            pstmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public ResultSet searchStud(int student_id) {
        String sql = "SELECT * FROM studenci WHERE student_id = ?";
        try {
            Connection con = DBpolaczenie.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, student_id);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
