package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

    public void closeCon(Connection con){
        try{
            if(con != null && !con.isClosed()){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void closePst(PreparedStatement pst){
        try{
            if(pst != null && !pst.isClosed()){
                pst.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void closeRs(ResultSet rs){
        try{
            if(rs != null && !rs.isClosed()){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
