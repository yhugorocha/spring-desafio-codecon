package io.git.yhugorocha.desafio_codecon.entity;

import java.util.List;

public class TeamEntity {

    private String nome;
    private Boolean lider;
    private List<ProjectEntity> projetos;

    public TeamEntity(String nome, Boolean lider, List<ProjectEntity> projetos) {
        this.nome = nome;
        this.lider = lider;
        this.projetos = projetos;
    }

    public TeamEntity() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getLider() {
        return lider;
    }

    public void setLider(Boolean lider) {
        this.lider = lider;
    }

    public List<ProjectEntity> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<ProjectEntity> projetos) {
        this.projetos = projetos;
    }

    @Override
    public String toString() {
        return "TeamEntity{" +
                "nome='" + nome + '\'' +
                ", lider=" + lider +
                ", projetos=" + projetos +
                '}';
    }
}
