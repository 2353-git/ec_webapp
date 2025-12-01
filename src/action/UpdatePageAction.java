package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProductBean;
import dao.ProductDAO;

public class UpdatePageAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int id = Integer.parseInt(request.getParameter("id"));
		ProductDAO dao = new ProductDAO();
		ProductBean product = dao.search(id);

		request.setAttribute("product", product);

		return "update.jsp";

	}
}
