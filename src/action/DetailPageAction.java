package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ProductBean;
import dao.ProductDAO;

public class DetailPageAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

		int id = Integer.parseInt(request.getParameter("id"));
		ProductDAO dao = new ProductDAO();
		ProductBean product = dao.search(id);

		if(product == null) {
			request.setAttribute("emsg", "ページにアクセスできません");
			return "ProductListPage.action";
		}

		request.setAttribute("product", product);

		request.setAttribute("msg", (String)session.getAttribute("msg"));
		session.removeAttribute("msg");


		return "detail.jsp";

	}
}