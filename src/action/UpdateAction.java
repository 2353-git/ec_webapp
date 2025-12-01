package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ProductBean;
import dao.ProductDAO;

public class UpdateAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		String image = request.getParameter("image");
		String name = request.getParameter("name");
		String pricestr = request.getParameter("price");
		String stockstr = request.getParameter("stock");
		String text = request.getParameter("text");

		Integer id = Integer.parseInt(request.getParameter("id"));

		Integer price = null;
		Integer stock = null;


		//入力チェック
		int error = 0;

		if (name.isEmpty()) {
			request.setAttribute("namemsg1", "商品名は必須です。");
			error = 1;
		}else if(name.length() > 100){
			request.setAttribute("namemsg2", "商品名は100文字以内で入力してください。");
			error = 1;
		}

		if (pricestr.isEmpty()) {
			request.setAttribute("pricemsg", "価格は必須です。");
			error = 1;
		}

		if (stockstr.isEmpty()) {
			request.setAttribute("stockmsg", "在庫数は必須です。");
			error = 1;
		}

		if(text.length() > 100) {
			request.setAttribute("textmsg", "商品説明は100文字以内で入力してください。");
			error = 1;
		}

		if(error == 0) {
			try {
			    price = Integer.parseInt(pricestr);
			} catch (Exception e) {
			    request.setAttribute("pricemsg2", "数値に問題があります。");
			    error = 1;
			}

		try {
		    stock = Integer.parseInt(stockstr);
		} catch (Exception e) {
		    request.setAttribute("stockmsg2", "数値に問題があります。");
		    error = 1;
		}
		}

		if(error == 1) {
			return "UpdatePage.action?id=" + id;
		}else {

		ProductBean p = new ProductBean();
		ProductDAO dao = new ProductDAO();
		if (image.isEmpty()) {
			ProductBean pb = dao.search(id);
			p.setImage(pb.getImage());
		}else {
			p.setImage("img/" + image);
		}
		p.setName(name);
		p.setPrice(price);
		p.setStock(stock);
		p.setText(text);
		p.setId(id);

		dao.update(p);

		session.setAttribute("msg", "商品を更新しました。");
		response.sendRedirect("DetailPage.action?id=" + id);

		return null;
		}

	}
}
