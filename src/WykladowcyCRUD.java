import java.sql.*;

public class WykladowcyCRUD {

    public void addWyklad(String imie, String nazwisko, String login, String haslo, String email){
        String sql = "INSERT INTO wykladowcy(imie, nazwisko, login, haslo, email) VALUES (?, ?, ?, ?, ?)";
        try(Connection con = DBpolaczenie.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, imie);
            pstmt.setString(2, nazwisko);
            pstmt.setString(3, login);
            pstmt.setString(4, haslo);
            pstmt.setString(5, email);
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ResultSet infoWyklad(){
        String sql = "SELECT * FROM wykladowcy";
        try{
            Connection con = DBpolaczenie.getConnection();
            Statement stmt = con.createStatement();
            return stmt.executeQuery(sql);}
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void updateWyklad(String imie, String nazwisko, String login, String haslo, String email, int wykladowca_id){
        String sql = "UPDATE wykladowcy SET imie = ?, nazwisko = ?, login = ?, haslo = ?, email= ? WHERE wykladowca_id = ?";
        try(Connection con = DBpolaczenie.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, imie);
            pstmt.setString(2, nazwisko);
            pstmt.setString(3, login);
            pstmt.setString(4, haslo);
            pstmt.setString(5, email);
            pstmt.setInt(6, wykladowca_id);
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteWyklad(int wykladowca_id){
        String sql = "DELETE FROM wykladowcy WHERE wykladowca_id = ?";
        try (Connection con = DBpolaczenie.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, wykladowca_id);
            pstmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public ResultSet searchWyklad(int wykladowca_id) {
        String sql = "SELECT * FROM wykladowcy WHERE wykladowca_id = ?";
        try {
            Connection con = DBpolaczenie.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, wykladowca_id);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
