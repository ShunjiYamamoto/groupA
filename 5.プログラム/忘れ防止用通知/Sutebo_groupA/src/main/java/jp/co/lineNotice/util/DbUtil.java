package jp.co.lineNotice.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DB接続用Utilityクラス
 */
public class DbUtil {
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/sutebo", "axizuser", "axiz");
        } catch (Exception e) {
            // 本来は専用の例外クラスを作成したほうがよい
            throw new RuntimeException(e);
        }
    }
}
