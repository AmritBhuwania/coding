package test;

public class Delhivery {


		private static Delhivery _instance;
	
	
		private Delhivery() {
	
		}
	
		public static Delhivery getInstance() {
			if (_instance == null) {
				synchronized (Delhivery.class) {
					if (_instance == null) {
						_instance = new Delhivery();
					}
	
				}
			}
			return _instance;
		}



}
