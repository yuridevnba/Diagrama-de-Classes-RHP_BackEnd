package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import agendamento.Evento;
import entities.Administrador;
import entities.Colaborador;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {///throws ParseException{
		// TODO Auto-generated method stub
		
		
		
		
		/////////////// DADOS Funcionário ////////////
		/////////////////////////////////
		
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			
			System.out.println("----------- Dados do usuário---------------------");
			System.out.println();
	System.out.println("Id");	
	String id=sc.nextLine();
	
   System.out.println("Nome:");
   String  nome=sc.nextLine();
   
   System.out.println("Email");
   String  email=sc.nextLine();
   
   System.out.println("Senha");
   String  Senha=sc.nextLine();
    
   System.out.println("VC é um colaborador ou administrador? ");
   String  cargo=sc.nextLine();
   
   if(cargo=="colaborador") {
	   var Funcionario=new Colaborador(nome, id, email, Senha);
   }
   else if(cargo=="administrador") {
	   var Funcionario=new Administrador(nome, id, email, Senha);
   }
   ////////////// Dados do Evento ///////////////////
/////////////////// exibir a data atual/////////////
   try {	

		System.out.println("----------- Calendário ---------------------");
		System.out.println();
		
System.out.println("Data atual:");
LocalDate myObj = LocalDate.now();
System.out.println(myObj);
System.out.println("Hora Atual");
LocalTime myhr=LocalTime.now();
System.out.println(myhr);
System.out.println();




System.out.println("----------- Dados do evento/data ---------------------");
System.out.println();


System.out.println("Quantas Reuniões vc quer marcar ?");

int n=sc.nextInt();
for(int i=1;i<=n;i++) {
	
	System.out.println();
	System.out.println("Escolha uma data para marcar sua reunião , a partir de  "+ myObj+"  ás "+myhr+"hr .");
	System.out.println();
	System.out.println("----------------Reunião "+i+ "#:--------------------");
	System.out.println("DateInicial (DD/MM/YYYY):");
	//String date1=sc.next();
	//Date DateInicial= sdf.parse(sc.next());
	Date DateInicial= sdf.parse("25/10/2022 10:40:00");
	System.out.println(DateInicial);
	
	System.out.println("DateFinal (DD/MM/YYYY):");
	//String date2=sc.next();
	//Date DateFinal= sdf.parse(sc.next());
	Date DateFinal= sdf.parse("25/10/2022 11:40:00");
	System.out.println(DateFinal);
	
	System.out.println();
	System.out.println("----------- Dados do evento/equipamentos---------------------");
	System.out.println();

	System.out.println("número da sala");
	String sala=sc.next();
	
	System.out.println("nome dos materiais necessários:");
	String nomeMaterial=sc.nextLine();
	
	sc.nextLine();
	System.out.println("qtd dos materiasis necessários:");
	int qtdMaterial=sc.nextInt();
	
	Evento evento=new agendamento.Evento(DateInicial, DateFinal, sala, nomeMaterial, qtdMaterial);

	System.out.println("----------- Saída dos dados do Evento ---------------------");
	System.out.println();
	
	if(evento.duration()<60) {
	System.out.println("sua reunião vai durar "+evento.duration()+" minutos");
	}
	
	else  {
		System.out.println("sua reunião vai durar "+evento.duration()/60+" horas");
		
	}
	
	int decisao;
	do {

		System.out.println("----------- Listagem dos Convidados---------------------");
		System.out.println();
		
		System.out.println("digite o nome do funcionário que irá participar da reunião?");
		String funcionarios=sc.nextLine();
		evento.addFuncionarios(funcionarios);
		sc.nextLine();
		System.out.println("aperte (1)para escrever os nomes dos próximos convidados que participarão da reunião, ou (2) quando quiser parar/finalizar");
		decisao=sc.nextInt();
		
		
	}while(decisao==1);
	System.out.println();
System.out.println("---------------------------------------dados de saída----------------------------------");
	
	System.out.println(evento.toString());
	
}
		}
		//catch(RuntimeException e) {
		 //System.out.println("Invalid date format");
	//}
	catch(DomainExceptions e) {
		 System.out.println("Error in reservation: "+e.getMessage());
	}
	catch(ParseException e) {
		e.printStackTrace();
	}
	}

}

