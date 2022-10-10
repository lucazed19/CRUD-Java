package Curso;

public class Curso {
	private int id;
	private String nome;
	private int duracaoHoras;
	
	public Curso() {}
	
	public Curso(int id, String nome, int duracaoHoras) {
		this.id = id;
		this.nome = nome;
		this.duracaoHoras = duracaoHoras;
	}
	
	public Curso(String nome, int duracaoHoras) {
		this.nome = nome;
		this.duracaoHoras = duracaoHoras;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDuracaoHoras() {
		return duracaoHoras;
	}
	public void setDuracaoHoras(int duracaoHoras) {
		this.duracaoHoras = duracaoHoras;
	}
	
	public String toString() {
        final StringBuilder sb = new StringBuilder("Curso{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", duracão_horas= ").append(duracaoHoras);
        sb.append('}');
        return sb.toString();
    }
	
	
}
