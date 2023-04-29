package main;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] args) {
        ItineraryDAO itineraryDao = new ItineraryDAOImpl();
        User user = new User(itineraryDao);
        Administrator admin = new Administrator(itineraryDao);
        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    System.out.println("Voce e Usuario ou administrador? (U/A)");
			    String userType = scanner.nextLine();

			    if (userType.equalsIgnoreCase("U")) {
			        while (true) {
			            System.out.println("O que voce gostaria de fazer?");
			            System.out.println("1. Ver todos os itinerarios.");
			            System.out.println("2. Procurar por viagem em dia específico.");
			            System.out.println("3. Sair.");
			            int choice = Integer.parseInt(scanner.nextLine());

			            if (choice == 1) {
			                for (Itinerary itinerary : user.getAllItinerary()) {
			                    System.out.println(itinerary.getOrigin() + ", " + itinerary.getDestination());
			                }
			            } else if (choice == 2) {
			                System.out.println("Insira a data da viagem:");
			                
			                Date date = null;
			                
			                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			                try {
			                    date = dateFormat.parse(scanner.nextLine());
			                    System.out.println("Data inserida: " + date);
			                } catch (ParseException e) {
			                    System.out.println("Formato de data inválido.");
			                }
			                
			                Itinerary itinerary = user.getItineraryByDate(date);
			                
			                if (itinerary != null) {
			                    System.out.println(itinerary.getOrigin() + ", " + itinerary.getDestination());
			                } else {
			                    System.out.println("Destino nao encontrado.");
			                }
			            } else if (choice == 3) {
			                break;
			            } else {
			                System.out.println("Escolha invalida. Tente novamente.");
			            }
			        }
			    } else if (userType.equalsIgnoreCase("A")) {
			        while (true) {
			            System.out.println("O que voce gostaria de fazer?");
			            System.out.println("1. Adicionar itinerario");
			            System.out.println("2. Atualizar itinerario");
			            System.out.println("3. Deletar itinerario");
			            System.out.println("4. Ver todos os itinerarios");
			            System.out.println("5. Pesquisar por data");
			            System.out.println("6. sair");
			            
			            int choice = Integer.parseInt(scanner.nextLine());

			            if (choice == 1) {
			                System.out.println("Insira a origem:");
			                String origin = scanner.nextLine();
			                
			                System.out.println("Insira o destino:");
			                String destination = scanner.nextLine();
			                
			                System.out.println("Insira a data:");
			                
			                Date date = null;
			                
			                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			                try {
			                    date = dateFormat.parse(scanner.nextLine());
			                    System.out.println("Data inserida: " + date);
			                } catch (ParseException e) {
			                    System.out.println("Formato de data inválido.");
			                }
			                
			                Itinerary itinerary = new Itinerary(origin, destination, date);
			                admin.addItinerary(itinerary);
			                System.out.println("Itinerario adicionado com sucesso.");
			                
			            } else if (choice == 2) {
			            	System.out.println("Insira a data do itinerário:");
			            	
			            	Date date = null;
			                
			                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			                try {
			                    date = dateFormat.parse(scanner.nextLine());
			                    System.out.println("Data inserida: " + date);
			                } catch (ParseException e) {
			                    System.out.println("Formato de data inválido.");
			                }
			            	
			                System.out.println("Insira a nova origem:");
			                String origin = scanner.nextLine();
			                System.out.println("Insira o novo destino:");
			                String destination = scanner.nextLine();
			                Itinerary itinerary = new Itinerary(origin, destination, date);
			                admin.updateItinerary(itinerary);
			                System.out.println("Itinerario atualizado com sucesso.");
			                
			            } else if (choice == 3) {
			                System.out.println("Insira a data a ser apagada:");
			                
			                Date date = null;
			                
			                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			                try {
			                    date = dateFormat.parse(scanner.nextLine());
			                    System.out.println("Data inserida: " + date);
			                } catch (ParseException e) {
			                    System.out.println("Formato de data inválido.");
			                }
			                
			                admin.deleteItinerary(date);
			                System.out.println("Itinerario deletado com sucesso.");
			                
			            } else if (choice == 4) {
			                for (Itinerary itinerary : user.getAllItinerary()) {
			                    System.out.println(itinerary.getOrigin() + ", " + itinerary.getDestination());
			                }
			                
			            } else if (choice == 5) {
			                System.out.println("Insira a data:");
			                
			                Date date = null;
			                
			                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			                try {
			                    date = dateFormat.parse(scanner.nextLine());
			                    System.out.println("Data inserida: " + date);
			                } catch (ParseException e) {
			                    System.out.println("Formato de data inválido.");
			                }
			                
			                Itinerary itinerary = user.getItineraryByDate(date);
			                if (itinerary != null) {
			                    System.out.println(itinerary.getOrigin() + ", " + itinerary.getDestination());
			                } else {
			                    System.out.println("Não há nada nesta data.");
			                }
			            } else if (choice == 6) {
			                break;
			            } else {
			                System.out.println("Escolha inválida. Tente novamente.");
			            }
			        }
			    }
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
