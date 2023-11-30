package application;

import entities.Contacts;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        List<Contacts> list = new ArrayList<>();


        for (int stop = 1; stop == 1; ) {
            System.out.println("Escolha a opção: ");
            System.out.println("0-) Sair");
            System.out.println("1-) Adicionar contato");
            System.out.println("2-) Ver contato específico");
            System.out.println("3-) Ver todos os contatos");
            System.out.println("4-) Remover contato");
            System.out.print("Digite por favor: ");
            int op = sc.nextInt();
            sc.nextLine();

            if (op == 0 || op == 1 || op == 2 || op == 3 || op == 4) {
                switch (op) {
                    case 0:
                        stop = 2;
                        break;
                    case 1:
                        System.out.println();
                        System.out.print("Digite o nome: ");
                        String name = sc.nextLine();
                        System.out.print("Digite o email: ");
                        String email = sc.nextLine();
                        System.out.print("Digite o número: ");
                        String number = sc.nextLine();
                        System.out.println();
                        Contacts contacts = new Contacts(name, email, number);
                        list.add(contacts);
                        break;

                    case 2:
                        System.out.print("Qual o nome do contato que deseja ver? ");
                        String nomeConsulta = sc.nextLine();
                        boolean encontrado = false;

                        for (Contacts contato : list) {
                            if (contato.getName().equalsIgnoreCase(nomeConsulta)) {
                                System.out.println();
                                System.out.println("Informações do Contato:");
                                System.out.println("Nome: " + contato.getName());
                                System.out.println("Email: " + contato.getEmail());
                                System.out.println("Número: " + contato.getNumber());
                                encontrado = true;
                                System.out.println();
                                break;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Contato não encontrado.");
                        }
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("Lista de Todos os Contatos:");

                        for (Contacts contato : list) {
                            System.out.println("Nome: " + contato.getName());
                            System.out.println("Email: " + contato.getEmail());
                            System.out.println("Número: " + contato.getNumber());
                            System.out.println();
                        }

                        if (list.isEmpty()) {
                            System.out.println("Nenhum contato cadastrado.");
                        }
                        break;
                    case 4:
                        System.out.println("Qual contato deseja remover?");
                        String nomeRemove = sc.nextLine();
                        boolean find = false;

                        Iterator<Contacts> iterator = list.iterator();

                        while (iterator.hasNext()) {
                            Contacts contato = iterator.next();
                            if (contato.getName().equalsIgnoreCase(nomeRemove)) {
                                iterator.remove(); // Remove o contato da lista
                                find = true;
                                System.out.println("Contato removido com sucesso.");
                                System.out.println();
                                break;
                            }
                        }

                        if (!find) {
                            System.out.println("Contato não encontrado.");
                        }
                        break;
                }
            } else {
                System.out.println("Opção inválida");
            }
        }

        sc.close();
    }
}
