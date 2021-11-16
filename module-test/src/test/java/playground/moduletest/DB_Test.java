package playground.moduletest;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Test {
    @Test
    public void test() throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/user_db","root","qkqh12");
        System.out.println(con);
    }
}