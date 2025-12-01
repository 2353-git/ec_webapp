package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProductBean;
import dao.ProductDAO;

public class ProductTablePageAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ProductDAO dao = new ProductDAO();
		List<ProductBean> list = dao.selectAll();

		request.setAttribute("list", list);
		return "product-table.jsp";

	}
}