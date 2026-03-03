package com.mycompany.banco;

import java.util.Scanner;
import java.util.ArrayList;

public class Banco {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ArrayList<Pessoa> clientes = new ArrayList<Pessoa>();
        ArrayList<Conta> contas = new ArrayList<Conta>();

        int opcao = -1;
        
         Pessoa p1 = new Pessoa("Joao", "Rua x, quadra x, lote x", "000000-00");
         Conta c1 = new Conta(p1, "0000", "000", "Do Brasil");
         
        contas.add(c1);
        clientes.add(p1);
        
        while (opcao != 0) {
            System.out.println("\n=== Banco ===");
            System.out.println("1 - Cadastrar Titular");
            System.out.println("2 - Cadastrar Conta");
            System.out.println("3 - Sacar");
            System.out.println("4 - Depositar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Ver Saldo");
            System.out.println("7 - Ver Dados da Conta");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = leitor.nextInt();

            if (opcao == 1) {
                leitor.nextLine();
                
                System.out.print("Nome: ");
                String nome = leitor.nextLine();
                System.out.print("CPF: ");
                String cpf = leitor.nextLine();
                System.out.print("Endereço: ");
                String endereco = leitor.nextLine();

                clientes.add(new Pessoa(nome, endereco, cpf));
                System.out.println("Titular cadastrado!");
            } else if (opcao == 2) {
                leitor.nextLine();
               
                System.out.print("CPF do titular: ");
                String cpfBusca = leitor.nextLine();
                Pessoa titularEncontrado = null;

                for (Pessoa p : clientes) {
                    if (p.getCpf().equals(cpfBusca)) {
                        titularEncontrado = p;
                        break;
                    }
                }

                if (titularEncontrado != null) {
                    System.out.print("Número: ");
                    String num = leitor.nextLine();
                    System.out.print("Agência: ");
                    String ag = leitor.nextLine();
                    System.out.print("Banco: ");
                    String bc = leitor.nextLine();

                    contas.add(new Conta(titularEncontrado, num, ag, bc));
                    System.out.println("Conta criada!");
                } else {
                    System.out.println("Titular não encontrado!");
                }
            } else if (opcao == 3) {
                leitor.nextLine();
   
                System.out.println("Digite o numero da sua conta:");
                String numeroBusca = leitor.nextLine();
                Conta numeroEncontrado = null;

                for (Conta c : contas) {
                    if (c.getNumero().equals(numeroBusca)) {
                        numeroEncontrado = c;
                        break;
                    }
                }

                if (numeroEncontrado != null) {
                    System.out.print("Valor saque: ");
                    double valor = leitor.nextDouble();
                    if (numeroEncontrado.sacar(valor)) {
                        System.out.println("Sucesso!");
                    } else {
                        System.out.println("Titular não encontrado!");
                    }
                } else {
                    System.out.println("Conta não encontrada!");
                }
            } else if (opcao == 4) {
                leitor.nextLine();
                System.out.println("Digite o numero da sua conta:");
                String numeroBusca = leitor.nextLine();
                Conta numeroEncontrado = null;

                for (Conta c : contas) {
                    if (c.getNumero().equals(numeroBusca)) {
                        numeroEncontrado = c;
                        break;
                    }
                }

                if (numeroEncontrado != null) {
                    System.out.print("Valor de deposito: ");
                    double valor = leitor.nextDouble();
                    if (numeroEncontrado.depositar(valor)) {
                        System.out.println("Sucesso!");
                    } else {
                        System.out.println("Titular não encontrado!");
                    }
                } else {
                    System.out.println("Conta não encontrada!");
                }
            } else if (opcao == 5) {
                leitor.nextLine();
                System.out.print("Conta de Origem: ");
                String origem = leitor.nextLine();

                Conta cOrigem = null;
                for (Conta c : contas) {
                    if (c.getNumero().equals(origem)) {
                        cOrigem = c;
                    }
                }

                if (cOrigem != null) {
                    System.out.print("Conta destino: ");
                    String destino = leitor.nextLine();

                    Conta cDestino = null;
                    for (Conta c : contas) {
                        if (c.getNumero().equals(destino)) {
                            cDestino = c;
                        }
                    }

                    if (cDestino != null) {
                        if (cOrigem != cDestino) {
                            System.out.print("Valor de transferencia: ");
                            double valor = leitor.nextDouble();
                            if (cOrigem.transferirDinheiro(valor, cDestino)) {
                                System.out.println("Sucesso!");
                            } else {
                                System.out.println("Transferencia não realizada, saldo insuficiente!");
                            }
                        } else {
                            System.out.println("Transferencia não realizada, o número das contas são iguais!");
                        }
                    } else {
                        System.out.println("Transferencia não realizada, conta de Destino não encontrada!");
                    }
                } else {
                    System.out.println("Transferencia não realizada, conta de Origem não encontrada!");
                }
            } else if (opcao == 6) {
                leitor.nextLine();
                System.out.println("Digite o numero da sua conta:");
                String numeroBusca = leitor.nextLine();
                Conta numeroEncontrado = null;

                for (Conta c : contas) {
                    if (c.getNumero().equals(numeroBusca)) {
                        numeroEncontrado = c;
                        break;
                    }
                }
                if (numeroEncontrado != null) {
                    System.out.println("Saldo:" + numeroEncontrado.getSaldo());
                }
            } else if (opcao == 7) {
                leitor.nextLine();
                System.out.println("Digite o numero da sua conta:");
                String numeroBusca = leitor.nextLine();
                Conta numeroEncontrado = null;

                for (Conta c : contas) {
                    if (c.getNumero().equals(numeroBusca)) {
                        numeroEncontrado = c;
                        break;
                    }
                }
                if (numeroEncontrado != null) {
                    System.out.println(numeroEncontrado.getTitular().getNome() + " | " + numeroEncontrado.getNumero() + " | " + numeroEncontrado.getAgencia() + " | " + numeroEncontrado.getSaldo());
                }
            }
        }
    }
} 
