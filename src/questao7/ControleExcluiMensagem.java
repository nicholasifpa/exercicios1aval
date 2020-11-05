package questao7;

import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControleExcluiMensagem")
public class ControleExcluiMensagem extends HttpServlet{
	protected void service (HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		String id = request.getParameter("id");
		// carrega a lista de “mensagens”, cria a lista se necessário.
		List<BlogMensagem> listaMsg = (ArrayList<BlogMensagem>) request.getSession().getAttribute("BEAN_LISTA");
		listaMsg.removeIf(item -> item.getId().equals(id));
		request.getSession().setAttribute("BEAN_LISTA", listaMsg);
		request.getRequestDispatcher("blog.jsp").forward(request, response);
	} 

}
