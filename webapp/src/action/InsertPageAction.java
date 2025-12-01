package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertPageAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

			return "insert.jsp";



	}
}
