package com.adivinhacao.jogo;

import java.util.Random;
import java.util.Scanner;
import com.adivinhacao.jogo.Jogo;

public class Jogo {
	
	public static void main(String[] args) {
		
		boolean jogo = true;
		JogadorComNome jogador1 = new JogadorComNome("Player 1");
		
		while (jogo) {
			
			System.out.println("Jogo da advinhação");
			Utils.MenuInfo();
			int escolhaMenu = Utils.MenuInput();
			
			switch (escolhaMenu) {
				case 4:
					jogo = false;
					break;
				case 3:
					jogador1.getJogador();
					break;
				case 2:
					Utils.MostraRegras();
					break;
				case 1:
					int dificuldade = Utils.EscolherDificuldade();
					boolean partida = Utils.Jogo(dificuldade);
					
					if (partida) {
						jogador1.Ganhou();
					}
					else {
						jogador1.Perdeu();
					}
					break;
				default:
					break;
			}
			
		}
		
		
	}
	
	static public class Jogador {
		
		private int vitorias;
		private int derrotas;
		
		public Jogador() {
			this.vitorias = 0;
			this.derrotas = 0;
		}
		
		public void Ganhou() {
			this.vitorias ++;
		}
		
		public void Perdeu() {
			this.derrotas++;
		}
		public void getJogador() {
			System.out.println("Vitórias: "+this.vitorias);
			System.out.println("Derrotas: "+this.derrotas);
			System.out.println("Pressione enter para continuar");
			Scanner scan = new Scanner(System.in);
			String x = scan.nextLine();
		}
		
	}
	
	static public class JogadorComNome extends Jogador {
		
		private String nome;
		
		public JogadorComNome(String nome) {
	        super(); 
	        this.nome = nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }
		
		@Override
	    public void getJogador() {
	        System.out.println("Nome: " + this.nome);
	        super.getJogador();
	    }
		
	}
	
	public class Utils{
		static void MenuInfo() {
			System.out.println("1 -> Jogar");
			System.out.println("2 -> Regras");
			System.out.println("3 -> Pontuação");
			System.out.println("4 -> Sair");
		}
		static int MenuInput() {
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			return input;
		}
		static int EscolherDificuldade() {
			System.out.println("Selecione a dificuldade:");
			System.out.println("1 -> Fácil");
			System.out.println("2 -> Médio");
			System.out.println("3 -> Difícil");
			Scanner scan = new Scanner(System.in);
			int dificuldade = scan.nextInt();
			return dificuldade;
		}
		static void MostraRegras() {
			System.out.println("O computador irá sortear um número aleatório e você deve advinhar.");
			System.out.println("No nível de dificuldade 'Fácil' o jogo sortea um número de 0 a 5");
			System.out.println("No nível de dificuldade 'Médio' o jogo sortea um número de 0 a 10");
			System.out.println("No nível de dificuldade 'Difícil' o jogo sortea um número de 0 a 15");
			System.out.println("Pressione enter para continuar");
			Scanner scan = new Scanner(System.in);
			String x = scan.nextLine();
		}
		static boolean Jogo(int dificuldade) {
			Scanner scan = new Scanner(System.in);
			Random random = new Random();
			
			int input = 0;
			int numeroAleatorio = 0;
			
			switch (dificuldade) {
				case 1:
					System.out.println("Advinhe o número que eu pensei de 0 a 5");
					numeroAleatorio = random.nextInt(6);
					input = scan.nextInt();
					break;
				case 2:
					System.out.println("Advinhe o número que eu pensei de 0 a 10");
					numeroAleatorio = random.nextInt(11);
					input = scan.nextInt();
					break;
				case 3:
					System.out.println("Advinhe o número que eu pensei de 0 a 15");
					numeroAleatorio = random.nextInt(16);
					input = scan.nextInt();
					break;
				default:
					System.out.println("Dificuldade inválida");
					break;
			}
			if (input == numeroAleatorio) {
				System.out.println("Acertou!");
				System.out.println("O número que eu pensei foi "+numeroAleatorio);
				return true;
			}
			else {
				System.out.println("Errou!");
				System.out.println("O número que eu pensei foi "+numeroAleatorio);
				return false;
			}
		}
	}
	
}

