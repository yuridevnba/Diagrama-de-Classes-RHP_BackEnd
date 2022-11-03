package agendamento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import entities.Funcionario;
import model.exceptions.DomainExceptions;

public class Evento {

	private static final Object id= Math.random();;
	private Date dataInicial;
	private Date dataFinal;
	private Object sala;
	private String nomeMaterial;
	private Integer qtdMaterial;
	
	private List<String> funcionarios = new ArrayList<>();

	public Evento( Date dataInicial, Date dataFinal, Object sala,String nomeMaterial,Integer qtdMaterial) {
		//super();
		Date now=new Date();
		if(!dataFinal.after(dataInicial)) {
			throw new DomainExceptions("DataFinal precisa ser depois da data inicial ");
		}
		if(dataFinal.before(now)|| dataInicial.before(now)) {
			throw new DomainExceptions(" as datas para os agendamentos precisam ser futuras, não se pode marcar algo que já passou.");
		}
		
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.sala = sala;
		this.nomeMaterial=nomeMaterial;
		this.qtdMaterial=qtdMaterial;
		
	} 
	
	
	public Object getId() {
		return id;
	}


	//public void setId(Object id) {
		//this.id = id;
	//}


	public Date getDataInicial() {
		return dataInicial;
	}


	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}


	public Date getDataFinal() {
		return dataFinal;
	}


	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}


	public Object getSala() {
		return sala;
	}


	public void setSala(Object sala) {
		this.sala = sala;
	}


	public String getNomeMaterial() {
		return nomeMaterial;
	}
	public Integer qtdMaterial() {
		return qtdMaterial;
	}


	public void setNomeMaterial(String nomeMaterial) {
		this.nomeMaterial = nomeMaterial;
	}


	public List<String> getFuncionarios() {
		return funcionarios;
	}


	public void setFuncionarios(List<String> funcionarios) {
		this.funcionarios = funcionarios;
	}


	public void addFuncionarios(String maisUm) {
		funcionarios.add(maisUm);
	}

	public void RemoveFuncionarios(String menosUm) {
		funcionarios.add(menosUm); 
	}
	public  long duration() {
		long diff=dataFinal.getTime()-dataInicial.getTime();
		
		long minutos= TimeUnit.MINUTES.convert(diff,TimeUnit.MILLISECONDS);
		return minutos;
		
		
	}


	@Override
	public String toString() {
		return "Evento [id=" + id + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + ", sala=" + sala
				+ ", nomeMaterial=" + nomeMaterial + ", qtdMaterial=" + qtdMaterial + ", funcionarios=" + funcionarios
				+ "]";
	}
	
	

}