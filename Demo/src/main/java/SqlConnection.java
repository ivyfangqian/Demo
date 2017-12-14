import java.sql.*;

public class SqlConnection {

    //数据库URL，用户名，密码
    private static final String URL = "jdbc:mysql://192.168.152.129:3308/sales?";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123456";


    private static final String URL_NOPASSWORD = "jdbc:mysql://127.0.0.1:3308/zentao";

    //数据库连接
    private Connection conn = null;

    //结果集
    private ResultSet rs = null;

    /*有密码时，连接数据库,并且使用Statement*/
    public void connectMysqlWithPassword() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "select * from student;";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("sid") + "\t" + rs.getString("sname"));
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*没有密码时，连接数据库,并且使用Statement*/
    public void connectMysqlWithoutPassword() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL_NOPASSWORD, "root", "");
            Statement stmt = conn.createStatement();
            String sql = "select * from zt_bug where openedBy='fangqian';";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("title") + "\t" + rs.getString("openedBy"));
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*没有密码时，连接数据库,并且使用PreparedStatement*/
    public void connectMysqlPreparedStat() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL_NOPASSWORD, "root", "");
            PreparedStatement preStat = conn.prepareStatement("select * from zt_bug where openedBy=?");
            preStat.setString(1, "fangqian");
            rs = preStat.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("title") + "\t" + rs.getString("openedBy") + "\t" + rs.getString("openedDate"));
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) {
//        SqlConnection sqlconn = new SqlConnection();
//        sqlconn.connectMysqlPreparedStat();
//    }
}
