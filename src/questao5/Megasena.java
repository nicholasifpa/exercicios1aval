package questao5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Megasena")
public class Megasena extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Random gerador = new Random();
		int jogos = Integer.parseInt(req.getParameter("jogos"));
		PrintWriter writter = resp.getWriter();
		for(int i = 0; i < jogos; i++) {
			writter.println(1 + gerador.nextInt(60));
		} 
	}
}
