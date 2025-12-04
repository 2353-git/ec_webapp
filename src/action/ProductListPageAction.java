package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ProductBean;
import dao.ProductDAO;

public class ProductListPageAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

		ProductDAO dao = new ProductDAO();
		List<ProductBean> list = dao.selectAll();

		request.setAttribute("list", list);

		request.setAttribute("msg", (String)session.getAttribute("msg"));
		session.removeAttribute("msg");

		return "product-list.jsp";

	}
}
