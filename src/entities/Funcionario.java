package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import agendamento.Evento;

public abstract class  Funcionario {

	private String nome;
	private String id;
	private String email;
	private String senha;
	
	
	private List<Evento> eventos = new ArrayList<>();
	
	

	public Funcionario(String nome, String id, String email, String senha) {
		this.nome = nome;
		this.id = id;
		this.email = email;
		this.senha = senha;
		
	}
	
	//public void login(String email, String senha) {
		//if(email == this.email && senha == this.senha) {
		//	System.out.println("Acesso permitido!");
		//}else {
		//	System.out.println("Senha ou email errado!");
		//}
	//}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void addEvento(Evento ev) {
		eventos.add(ev); 
	}
	public void RemoveEvento(Evento ev ) {
		eventos.remove(ev);

	
	}
	public void convergência(int year, int month,int diaMes,int horaDia) {
		Calendar cal=Calendar.getInstance();
		for(Evento e:eventos) {
			cal.setTime(e.getDataInicial());
			int c_year=cal.get(Calendar.YEAR);
			int c_month=1+cal.get(Calendar.MONTH);
			int c_diaMes=cal.get(Calendar.DAY_OF_MONTH);
			int c_horadia=cal.get(Calendar.HOUR_OF_DAY);
			
				if (year==c_year && month==c_month && diaMes==c_diaMes && horaDia==c_horadia) {
					System.out.println("já existe um agendamento para essa data");
				}
			
		}
	}
	
	}
