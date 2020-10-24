
public class connect2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Class.forName("com.connect2.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
