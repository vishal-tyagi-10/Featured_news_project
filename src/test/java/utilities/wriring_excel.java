package utilities;


	import java.io.IOException;



public class wriring_excel {
		static String file_path = System.getProperty("user.dir") + ".\\test-data\\Excel.xlsx";

		public static void News_title(String[] names) {

			for (int i = 1; i <= 5; i++) {
				try {
					new_excel.setCellData(file_path, "Sheet1", i, 1, names[i - 1]);
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			System.out.println("Writing of First Five Projects in Excel Done");
		}

		public static void totalnews(int count) {
			
			String value = String.valueOf(count);
			try {
				new_excel.setCellData(file_path, "Sheet1", 1, 0, value);
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			System.out.println("Writing of Total number of projects in Excel Done");
		}
		
//		public static void writeEmail(String email) {
//			
//			try {
//				new_excel.setCellData(file_path, "Sheet1", 1, 2, email);
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//			}
//			System.out.println("Writing of Email Address in Excel Done");
//		}

	}



