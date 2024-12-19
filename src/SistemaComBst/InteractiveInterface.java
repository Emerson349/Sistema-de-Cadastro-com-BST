package SistemaComBst;
import java.util.Scanner;

public class InteractiveInterface {

    public static void main(String[] args) {
        Storage storage = new Storage();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n=== Sistema de Gerenciamento de Usuários ===");
            System.out.println("1. Inserir Usuário");
            System.out.println("2. Buscar Usuário");
            System.out.println("3. Alterar Nome do Usuário");
            System.out.println("4. Alterar Email do Usuário");
            System.out.println("5. Exibir Árvore de Usuários");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite o ID do usuário: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o nome do usuário: ");
                    String name = scanner.nextLine();
                    System.out.print("Digite o email do usuário: ");
                    String email = scanner.nextLine();
                    storage.insertUser(name, email, id);
                    System.out.println("Usuário inserido com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o ID do usuário para buscar: ");
                    int searchId = scanner.nextInt();
                    User foundUser = storage.searchUser(searchId);
                    if (foundUser != null) {
                        System.out.println("Usuário encontrado\n" + foundUser);
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID do usuário para alterar o nome: ");
                    int nameId = scanner.nextInt();
                    scanner.nextLine();
                    if(storage.searchUser(nameId) != null) {
                        System.out.print("Digite o novo nome: ");
                        String newName = scanner.nextLine();
                        storage.changeName(newName, nameId);
                        System.out.println("Nome atualizado com sucesso!");
                        break;
                    }

                case 4:
                    System.out.print("Digite o ID do usuário para alterar o email: ");
                    int emailId = scanner.nextInt();
                    scanner.nextLine();
                    if(storage.searchUser(emailId) != null) {
                        System.out.print("Digite o novo email: ");
                        String newEmail = scanner.nextLine();
                        storage.changeEmail(newEmail, emailId);
                        System.out.println("Email atualizado com sucesso!");
                        break;
                    }

                case 5:
                    System.out.println("\nExibindo todos os usuários na árvore (ordem):");
                    storage.printTree(storage.getSource());
                    break;

                case 6:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 6);

        scanner.close();
    }
}
