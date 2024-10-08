package appconsole;

import regras_negocio.Fachada;
import modelo.Entrega;
import modelo.Entregador;
import modelo.Produto;

public class Consultar {
	
	public Consultar() {
		try {
			Fachada.inicializar();
			
			System.out.println("consultas... \n");
			System.out.println("\nentregas por endereço\n");
			for(Entrega entrega: Fachada.entregasEndereco("123"))
				System.out.println(entrega);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\nentregas por produto\n");
			for(Entrega entrega: Fachada.entregasProduto(1))
				System.out.println(entrega);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\nentregadores com mais de n entregas");
			for(Entregador entregador : Fachada.entregadoresNumEntregas(2))
					System.out.println(entregador.getNome()+ " -- entregas:"+ entregador.getEntregas().size());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Fachada.finalizar();
		System.out.println("\nfim do programa !");
	} 

	public static void main(String[] args) {
		new Consultar();

	}

}
