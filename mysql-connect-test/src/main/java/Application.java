import config.DataSource;
import dao.DataDao;
import dao.DataDaoImpl;
import model.StudentInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        DataDao dao = new DataDaoImpl();

        List<StudentInfo> lsNames = dao.getAllStudent();
        for (StudentInfo st : lsNames) {
            System.out.println(st.getName() + "\t" + st.getAge() + "\t" + st.getGpa());
        }

    }
}
