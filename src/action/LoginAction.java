package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.UserDAO;

public class LoginAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		UserDAO dao = new UserDAO();
		UserBean user = dao.search(name, password);


		//入力チェック
		int error = 0;

		if(name.isEmpty()) {
			request.setAttribute("umsg", "ユーザー名は必須です。");
			error = 1;
		}else if(!name.matches("^[a-zA-Z0-9]{8,30}$")) {
			//request.setAttribute("umsg", "ユーザー名は英数字8文字以上30文字以下で入力してください。");
			request.setAttribute("message", "ユーザー名またはパスワードが正しくありません。");
			error = 1;
		}

		if(password.isEmpty()) {
			request.setAttribute("pmsg", "パスワードは必須です。");
			error = 1;
		}else if(!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z0-9]{8,30}$")) {
			//request.setAttribute("pmsg", "パスワードは英数字8～30文字で、大文字・小文字・数字を1文字以上含めて入力してください。");
			request.setAttribute("message", "ユーザー名またはパスワードが正しくありません。");
			error = 1;
		}
		if(error == 1) {
			return "login.jsp";
		}

		if(user != null) {
			session.setAttribute("user", user);

			response.sendRedirect("ProductListPage.action");
		    return null;
		}else {
			request.setAttribute("message", "ユーザー名またはパスワードが正しくありません。");
			return "login.jsp";
		}

	}

}
