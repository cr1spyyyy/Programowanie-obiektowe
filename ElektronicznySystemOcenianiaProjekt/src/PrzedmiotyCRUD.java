import java.sql.*;

public class PrzedmiotyCRUD {

    public void addPrzed(String nazwa, int wykladowca_id){
        String sql = "INSERT INTO przedmioty(nazwa, wykladowca_id) VALUES (?, ?)";
        try(Connection con = DBpolaczenie.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, nazwa);
            pstmt.setInt(2, wykladowca_id);
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ResultSet infoPrzed(){
        String sql = "SELECT * FROM przedmioty";
        try{
            Connection con = DBpolaczenie.getConnection();
            Statement stmt = con.createStatement();
            return stmt.executeQuery(sql);}
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void updatePrzed( String nazwa, int wykladowca_id, int przedmiot_id){
        String sql = "UPDATE przedmioty SET  nazwa = ?, wykladowca_id = ? WHERE przedmiot_id = ?";
        try(Connection con = DBpolaczenie.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, nazwa);
            pstmt.setInt(2, wykladowca_id);
            pstmt.setInt(3, przedmiot_id);
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletePrzed(int przedmiot_id){
        String sql = "DELETE FROM przedmioty WHERE przedmiot_id = ?";
        try (Connection con = DBpolaczenie.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, przedmiot_id);
            pstmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public ResultSet searchPrzed(int przedmiot_id) {
        String sql = "SELECT * FROM przedmioty WHERE przedmiot_id = ?";
        try {
            Connection con = DBpolaczenie.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, przedmiot_id);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
