import java.math.BigDecimal;
import java.sql.*;

public class OcenyCRUD {
    public void addOcena(int student_id, int przedmiot_id, double ocena){
        String sql = "INSERT INTO oceny(student_id, przedmiot_id, ocena) VALUES (?, ?, ?)";
        try(Connection con = DBpolaczenie.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, student_id);
            pstmt.setInt(2, przedmiot_id);
            pstmt.setBigDecimal(3, BigDecimal.valueOf(ocena));
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ResultSet infoOcena(){
        String sql = "SELECT ocena_id, student_id, przedmiot_id, FORMAT(ocena, 1) AS ocena FROM oceny";
        try{
            Connection con = DBpolaczenie.getConnection();
            Statement stmt = con.createStatement();
            return stmt.executeQuery(sql);}
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void updateOcena(int student_id, int przedmiot_id, double ocena, int ocena_id){
        String sql = "UPDATE oceny SET student_id = ?, przedmiot_id = ?, ocena = ? WHERE ocena_id = ?";
        try(Connection con = DBpolaczenie.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, student_id);
            pstmt.setInt(2, przedmiot_id);
            pstmt.setBigDecimal(3, BigDecimal.valueOf(ocena));
            pstmt.setInt(4, ocena_id);
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteOcena(int ocena_id){
        String sql = "DELETE FROM oceny WHERE ocena_id = ?";
        try (Connection con = DBpolaczenie.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, ocena_id);
            pstmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public ResultSet searchOcena(int ocena_id) {
        String sql = "SELECT * FROM oceny WHERE ocena_id = ?";
        try {
            Connection con = DBpolaczenie.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, ocena_id);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
