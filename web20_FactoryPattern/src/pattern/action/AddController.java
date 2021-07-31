package pattern.action;

public class AddController implements Controller{
	
	@Override
	public String requestHandle() {
		System.out.println("AddController ... add logic...");
		return "add_result.jsp";
	}
}
