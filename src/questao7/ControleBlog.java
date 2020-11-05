package questao7;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import questao2.Usuario;

@WebServlet("/ControleBlog")
public class ControleBlog extends HttpServlet {
	protected void service (HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
	// Recuperar a mensagem do formulário
		String msg = request.getParameter("mensagem");
		if(request.getSession().getAttribute("USUARIO") == null) {
			request.getRequestDispatcher("blog.jsp?erroLogin=Nome não informado").forward(request, response);
		}
		if(!msg.isEmpty()) {
			// definir/criar o objeto de dados (BlogMensagem)
			BlogMensagem blogMsg = new BlogMensagem();
			LocalTime horaAtual = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
			Usuario user = (Usuario) request.getSession().getAttribute("USUARIO");
			blogMsg.setMensagem(msg);
			blogMsg.setDataMensagem(new Date());
			blogMsg.setHoraMensagem(horaAtual);
			blogMsg.setId(UUID.randomUUID().toString());
			blogMsg.setUsuario(user.getNome());
		// carrega a lista de “mensagens”, cria a lista se necessário.
			List<BlogMensagem> listaMsg = (ArrayList<BlogMensagem>) request.getSession().getAttribute("BEAN_LISTA");
			if (listaMsg==null)
			listaMsg = new ArrayList<BlogMensagem>();
			// adiciona o objeto "blogMsg" na lista
			listaMsg.add(blogMsg);
			// salvar a lista em tempo de sessao (como bean)
			request.getSession().setAttribute("BEAN_LISTA", listaMsg);
			System.out.println("abrindo...");
			// despacho para a página de blog
			request.getRequestDispatcher("blog.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("blog.jsp?erro=Mensagem em branco").forward(request, response);
		}
	} // fim do método
}
