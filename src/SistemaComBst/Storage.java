package SistemaComBst;

/**
 * Classe Storage
 * Responsável por gerenciar usuários em uma árvore binária de busca (BST).
 * Permite inserir, buscar, alterar e exibir usuários organizados de forma ordenada por ID.
 */
public class Storage {
    private User sourceUser;  // Nó raiz da árvore binária de busca.

    // Obtém o nó raiz da árvore.
    public User getSource() {
        return this.sourceUser;
    }

    // Insere um novo usuário na árvore.
    // Se o ID já existir, a inserção é ignorada.
    public void insertUser(String name, String email, int id) {
        if(searchUser(id) != null) {
            return;
        }
        User newUser = new User(name, id, email);
        if (sourceUser == null) {
            sourceUser = newUser;
        }
        else {
            recursiveInsert(newUser, this.sourceUser);
        }
    }

    // Método auxiliar para inserir usuários recursivamente na árvore.
    private void recursiveInsert(User newUser, User current) {
        if (newUser.getId() < current.getId()) {
            if (current.getLeft() == null) {
                current.setLeft(newUser);
            }
            else {
                recursiveInsert(newUser, current.getLeft());
            }
        }
        else {
            if (current.getRight() == null) {
                current.setRight(newUser);
            }
            else {
                recursiveInsert(newUser, current.getRight());
            }
        }
    }

    // Busca um usuário pelo ID na árvore.
    public User searchUser(int id) {
        return rercusiveSearch(id, sourceUser);
    }

    // Método auxiliar para buscar usuários recursivamente na árvore.
    private User rercusiveSearch(int id, User sourceUser) {
        if (sourceUser == null) {
            return null;
        }
        if (id == sourceUser.getId()) {
            return sourceUser;
        }
        else if (id < sourceUser.getId()) {
            return rercusiveSearch(id, sourceUser.getLeft());
        }
        else {
            return rercusiveSearch(id, sourceUser.getRight());
        }
    }

    // Altera o email de um usuário pelo ID.
    public void changeEmail(String email, int id) {
        User user = searchUser(id);
        if (user != null) {
            user.setEmail(email);
        }
    }

    // Altera o nome de um usuário pelo ID.
    public void changeName(String name, int id) {
        User user = searchUser(id);
        if (user != null) {
            user.setName(name);
        }
    }

    // Imprime todos os usuários da árvore em ordem crescente de ID.
    public void printTree(User current) {
        if (current != null) {
            printTree(current.getLeft());
            System.out.println(current);
            printTree(current.getRight());
        }
    }
}
