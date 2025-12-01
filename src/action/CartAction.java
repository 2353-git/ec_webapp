package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartBean;

public class CartAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		int count = 0;

		String referer = request.getHeader("Referer");

		List<CartBean> cart = (List<CartBean>)session.getAttribute("cart");

		if(cart == null) {
			cart = new ArrayList<CartBean>();
		}

		int flag = 0;
		for (CartBean i : cart) {
            if (i.getId() == id) {
            	flag = 1;
                i.setQuantity(i.getQuantity() + quantity);
            }
        }
		if(flag == 0) {
			cart.add(new CartBean(id, quantity));
		}

		for(CartBean i : cart) {
			count += i.getQuantity();
		}

		session.setAttribute("cart", cart);
		session.setAttribute("count", count);

		response.sendRedirect(referer);
		return null;

	}
}
