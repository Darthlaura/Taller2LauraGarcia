package logica;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		boolean continuar = true; 
		
		while(continuar) {
			manejoMenu(teclado);
			
		}

		 
		teclado.close();
	}

	public static int retornoMenu(Scanner teclado) throws IllegalArgumentException {
		int opcion = 0;

		do {
			System.out.println("1) Continuar.");
			System.out.println("2) Nueva Partida.");
			System.out.println("3) Salir.");
			System.out.print("Ingrese Opcion: ");
			opcion = Integer.valueOf(teclado.nextLine());

			if (opcion < 1 || opcion > 3) {

				System.out.println("Opcion fuera del rango");
			}

		} while (opcion < 1 || opcion > 3);

		return opcion;

	}

	public static int menuContinuar(Scanner teclado)  throws IllegalArgumentException{
		int opcionMenuContinuar = 0;

		do {
			System.out.println("1) Revisar equipo.");
			System.out.println("2) Salie a capturar.");
			System.out.println("3) Acceso al PC (Cambiar Pokemon del equipo).");
			System.out.println("4) Retar un gimnasio.");
			System.out.println("5) Desafio al Alto Mando.");
			System.out.println("6) Curar Pokemon.");
			System.out.println("7) Guardar.");
			System.out.println("8) Guardar y Salir.");
			System.out.print("Ingrese Opcion: ");
			opcionMenuContinuar = Integer.valueOf(teclado.nextLine());
			if (opcionMenuContinuar < 1 || opcionMenuContinuar > 8) {
				System.out.println("opcion fuera del rango");

			}
		} while (opcionMenuContinuar < 1 || opcionMenuContinuar > 8);

		return opcionMenuContinuar;

	}
	
	public static void manejoMenu(Scanner teclado) {
		
		int entradaMenuPrincipal=0; 
		
		try {
			entradaMenuPrincipal = retornoMenu(teclado); 
			switch (entradaMenuPrincipal) {
			case 1: {
				boolean continuarMenu = true;
				while (continuarMenu) {
					boolean menuInterno; 
				
					menuInterno=controlMenuContinuar(teclado);
					if(menuInterno == false) {
						continuarMenu = false; 
						break; 
					}
				}
			     break;
			}
			case 2: {
				
				break;
			}
			
			case 3: {
				
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + entradaMenuPrincipal);
			}
			
		}catch (IllegalArgumentException e) {
			System.out.println("Accion fuera del rango");
		}
		
		
	}
	
	public static boolean controlMenuContinuar(Scanner teclado) {
		int entradaMenuContinuar=0;
		boolean continuar= false;
		try {
			entradaMenuContinuar= menuContinuar(teclado); 
			switch (entradaMenuContinuar) {
			case 1: {
				System.out.println("revisar equipo");
				continuar = true ;  
				return continuar;  
			}
			case 2: { 
				System.out.println("salir a capturar mostrar sonas ");
				// retorno de lista de habitad 
				continuar = true ;  
				return continuar;
			}
			case 3: {
				System.out.println("cambiar el pokemon");
				// ir al equipo 
				continuar = true ;  
				return continuar;
			}
			case 4: {
				System.out.println("Retar gim ");
				//ir a retar 
				continuar = true ;  
				return continuar;
			}
			case 5: {
				System.out.println("Desafio alto mando");
				// ir a desafiar al alto mando
				continuar = true ;  
				return continuar; 
			}
			case 6: {
				System.out.println("Curar pokemon");
				//esta funcion es del jugador 
				continuar = true ;  
				return continuar; 
			}
			case 7: {
				System.out.println("guardar");
				//sobre escribir el archivo
				continuar = true ;  
				return continuar;
			}
			case 8: {
				System.out.println("guardar y salir");
				return continuar;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + entradaMenuContinuar);
			}
			
			
			
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
		
			continuar = true ;  
			return continuar;
		
		
	}

	}
}