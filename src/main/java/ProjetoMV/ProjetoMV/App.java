package ProjetoMV.ProjetoMV;

import java.util.List;
import java.util.Scanner;

import entidade.Sorvete;
import dao.SorveteDAO;
import dao.SorveteDAOimpl;

public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		SorveteDAO sorveteDAO = new SorveteDAOimpl();

		while (true) {

			System.err.println(
					"\n\nSelecione uma opção: \n\n[1] INSERIR SORVETE\n[2] REMOVER SORVETE\n[3] LISTAR SORVETES ");
			int opcao = scan.nextInt();

			Sorvete sorvete = new Sorvete();

			switch (opcao) {

			case 1: // inserir

				System.err.println("\n\nDigite o SABOR/NOME do Sorvete: ");
				sorvete.setNome(scan.nextLine());
				sorvete.setNome(scan.nextLine());

				System.err.println("\nDigite o FABRICANTE do Sorvete: ");
				sorvete.setFabricante(scan.nextLine());

				System.err.println("\nDigite os INGREDIENTES do Sorvete: ");
				sorvete.setIngredientes(scan.nextLine());

				sorveteDAO.inserir(sorvete);

				System.out.println("==== SORVETE INSERIDO COM SUCESSO!!! ===");

				break;

			case 2: // remover

				System.err.println("\nDigite o NOME do Sorvete que será removido: ");
				sorvete.setNome(scan.nextLine());

				sorveteDAO.remover(scan.nextLine());

				break;

			case 3: // listar

				List<Sorvete> sorvetes = sorveteDAO.listarTodos();

				System.out.println("\n\n\n\n ");
				for (Sorvete s : sorvetes) {
					System.out.println(" ===  NOME: " + s.getNome() + "  === FABRICANTE: " + s.getFabricante()
							+ "  === INGREDIENTES: " + s.getIngredientes() + "  ===");
				}

				break;

			default:
				break;
			}

		}

	}

}
