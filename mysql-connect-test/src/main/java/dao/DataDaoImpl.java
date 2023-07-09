package dao;

import config.DataSource;
import config.DataSourceHP;
import model.StudentInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataDaoImpl extends BaseDao implements DataDao {

    @Override
    public List<StudentInfo> getAllStudent() {
        List<StudentInfo> data = new ArrayList<>();


        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String query = "SELECT * FROM `test`.`hoangpn_sinhvien`";
            con = DataSourceHP.getConnection();
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                StudentInfo student = new StudentInfo();

                student.setName(rs.getString("ten"));
                student.setAge(rs.getInt("tuoi"));
                student.setGpa(rs.getDouble("gpa"));

                data.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
            closePst(pst);
            closeRs(rs);
        }
        return data;
    }



}
