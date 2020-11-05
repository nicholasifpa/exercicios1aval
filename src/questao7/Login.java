package questao7;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import questao2.Usuario;

@WebServlet("/Login")
public class Login extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		if(!nome.isEmpty()) {
			request.getSession().setAttribute("USUARIO", new Usuario(nome));
			request.getRequestDispatcher("blog.jsp").forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/blog.jsp?erroLogin=Nome não informado");
		}
	}
	
}
