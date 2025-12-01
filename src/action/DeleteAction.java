package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;

public class DeleteAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		Integer id = Integer.parseInt(request.getParameter("id"));
		ProductDAO dao = new ProductDAO();
		dao.delete(id);


		session.setAttribute("msg", "商品を削除しました。");


		response.sendRedirect("ProductListPage.action");
        return null;

	}

}
