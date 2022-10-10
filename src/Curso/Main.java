package Curso;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int escolha;
		boolean sair = false;
		while(!sair) {		
			System.out.println("BEM-VINDO AO CRUD JAVA, O QUE DESEJA FAZER?");
			System.out.println("1 - CRIAR CURSO , 2 - CONSULTAR CURSOS , 3 - ATUALIZAR CURSO , 4 - DELETAR CURSO , 5 - SAIR");
			try {
				escolha = scan.nextInt();
				switch (escolha) {
				case 1:
					create();
					break;
				case 2:
					read();
					break;
				case 3:
					update();
					break;
				case 4:
					delete();
					break;
				case 5:
					quit();
					sair = true;
					break;
				}
			} catch (Exception e) {
				System.out.println("Número Inválido");
				e.printStackTrace();
				break;
			}
		}
	}
	
	private static void create() {
		Scanner scan = new Scanner(System.in);
		CursoDAO cursoDAO = new CursoDAO();
		
		System.out.println("DIGITE O NOME DO CURSO:");
		String nomeCurso = scan.next();
		System.out.println("DIGITE A DURAÇÃO DO CURSO");
		int duracaoCurso = scan.nextInt();
		
		Curso cursoParaInsercao = new Curso (nomeCurso, duracaoCurso);
		cursoDAO.create(cursoParaInsercao);
		System.out.println();
	}
	
//		// ======================= 1.1 - Consulta com filtro ========================================
//		Curso cursoParaConsulta = cursoDAO.getById(1);
//		System.out.println(cursoParaConsulta);
	private static void read() {
		CursoDAO cursoDAO = new CursoDAO();
		List<Curso> cursos = cursoDAO.list();
		cursos.stream().forEach(System.out::println);
		System.out.println();
	}

	private static void update() {
		Scanner scan = new Scanner(System.in);
		CursoDAO cursoDAO = new CursoDAO();
		
		System.out.println("DIGITE O ID DO CURSO QUE ALTERARÁ:");
		int id = scan.nextInt();
		Curso cursoParaAtualizar = cursoDAO.getById(id);
		
		System.out.println("DIGITE O NOVO NOME DO CURSO: ");
		String nomeCurso = scan.next();
		cursoParaAtualizar.setNome(nomeCurso);
		
		System.out.println("DIGITE A NOVA QUANTIDADE DE HORAS DO CURSO");
		int horasCurso = scan.nextInt();
		cursoParaAtualizar.setDuracaoHoras(horasCurso);
		
		cursoDAO.update(cursoParaAtualizar);
		System.out.println();
	}
	
	private static void delete() {
		Scanner scan = new Scanner(System.in);
		CursoDAO cursoDAO = new CursoDAO();
		
		System.out.println("DIGITE O ID DO CURSO QUE EXCLUIRÁ:");
		int id = scan.nextInt();
		cursoDAO.delete(id);
		System.out.println();
	}
	
	private static void quit() {
		System.out.println("SAÍNDO DO CRUD, OBRIGADO PELA PRESENÇA!");
	}
}
