package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ProductBean;
import dao.ProductDAO;

public class InsertAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		String image = request.getParameter("image");
		String name = request.getParameter("name");
		String pricestr = request.getParameter("price");
		String stockstr = request.getParameter("stock");
		String text = request.getParameter("text");


		//入力チェック
		int error = 0;
		if (image.isEmpty()) {
			request.setAttribute("imgmsg", "商品画像は必須です。");
			error = 1;
		}

		if (name.isEmpty()) {
			request.setAttribute("namemsg1", "商品名は必須です。");
			error = 1;
		}else if(name.length() > 100){
			request.setAttribute("namemsg2", "商品名は100文字以内で入力してください。");
			error = 1;
		}else {
			request.setAttribute("name", name);
		}

		if (pricestr.isEmpty()) {
			request.setAttribute("pricemsg", "価格は必須です。");
			error = 1;
		}else {
			request.setAttribute("price", pricestr);
		}

		if (stockstr.isEmpty()) {
			request.setAttribute("stockmsg", "在庫数は必須です。");
			error = 1;
		}else {
			request.setAttribute("stock", stockstr);
		}

		if(text.length() > 100) {
			request.setAttribute("textmsg", "商品説明は100文字以内で入力してください。");
			error = 1;
		}else {
			request.setAttribute("text", text);
		}

		if(error == 1) {
			return "insert.jsp";
		}else {

		Integer price = Integer.parseInt(pricestr);
		Integer stock = Integer.parseInt(stockstr);

		ProductBean p = new ProductBean();
		p.setName(name);
		p.setPrice(price);
		p.setStock(stock);
		p.setText(text);
		p.setImage("img/" + image);


		ProductDAO dao = new ProductDAO();
		dao.insert(p);


		session.setAttribute("msg", "商品を登録しました。");

		response.sendRedirect("ProductListPage.action");
		return null;
		}

	}

}
