package questao7;

import java.time.LocalTime;
import java.util.Date;

import questao2.Usuario;

public class BlogMensagem {
	private String usuario;
	private String id;
	private String mensagem;
	private Date dataMensagem;
	private LocalTime horaMensagem;
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Date getDataMensagem() {
		return dataMensagem;
	}
	public void setDataMensagem(Date dataMensagem) {
		this.dataMensagem = dataMensagem;
	}
	public LocalTime getHoraMensagem() {
		return horaMensagem;
	}
	public void setHoraMensagem(LocalTime horaMensagem) {
		this.horaMensagem = horaMensagem;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
