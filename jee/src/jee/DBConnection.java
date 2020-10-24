package jee;
import java.sql.*;
public class DBConnection {

		private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
		private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

		private static final String USERNAME = "system";
		private static final String PASSWORD = "SYSTEM";

		public static Connection connect() {
			Connection con = null;

			try {
				Class.forName(DRIVER); // 1. register the driver class of oracle
				con = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
				System.out.print("Connection Established");//2. establishing the connection with DB

			} catch (ClassNotFoundException e) {

				System.out.println(e);
			} catch (SQLException e) {

				System.out.println(e);
			}
			return con;

		}

		public static void closeStatement(PreparedStatement pst) {

			if (pst != null) {

				try {
					pst.close();
				} catch (SQLException e) {

					System.out.println(e);
				}
			}

		}

		public static void closeConnection(Connection con) {

			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {

					System.out.println(e);
				}
			}

		}

		public static void closeResultset(ResultSet rs) {

			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {

					System.out.println(e);
				}
			}

		}

		public static Connection getConnection() {
			// TODO Auto-generated method stub
			return null;
		}

	}

