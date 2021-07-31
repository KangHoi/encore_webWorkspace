package servlet.controller;

public class ControllerFactory {
	
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory() {}
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	// command에 따라서 Component를 생성하는 기능...factory 본연의 역할
	public Controller createController(String command) {
		Controller controller = null;
		
		if (command.equals("login")) {
			controller = new LoginController();
			System.out.println("LoginController...Create");
		} else if (command.equals("addBook")) {
			controller = new AddBookController();
			System.out.println("AddBookController...Create");
		} else if (command.equals("bookList")) {
			controller = new BookListController();
		} else if (command.equals("logout")) {
			controller = new LogoutController();
		}
		
		return controller;
	}
	
}
