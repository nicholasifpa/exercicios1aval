<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>É preciso informar seu nome!</p>
	<form action="Login">
        <label>Entre com seu nome:
            <input type="text" name="nome">
        </label>
        <button type="submit">Entrar</button>
    </form>
    <% 
      	String nome = request.getParameter("erroLogin");
      	if(nome != null)
      		out.println("Um nome precisa ser informado!");
     %>
	<h2>Mensagem:</h2>
	
	<form action="ControleBlog">
		<textarea rows="3" cols="40" value="" name="mensagem"></textarea>

		<br> <input type="submit" value="ENVIAR" />
	</form>
	
	<% 
      	String erro = request.getParameter("erro");
      	if(erro != null)
      		out.println("A mensagem não pode estar em branco!");
     %>

	<jsp:include page="mensagens.jsp" flush="true" />
</body>
</html>