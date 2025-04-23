package io.git.yhugorocha.desafio_codecon.entity;

public class ProjectEntity {

    private String nome;
    private Boolean concluido;

    public ProjectEntity(String nome, Boolean concluido) {
        this.nome = nome;
        this.concluido = concluido;
    }

    public ProjectEntity() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "nome='" + nome + '\'' +
                ", concluido=" + concluido +
                '}';
    }
}
