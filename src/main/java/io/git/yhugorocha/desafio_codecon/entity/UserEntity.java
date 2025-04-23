package io.git.yhugorocha.desafio_codecon.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize
public class UserEntity {

    private String id;
    private String nome;
    private Integer idade;
    private Integer score;
    private Boolean ativo;
    private String pais;
    private TeamEntity equipe;
    private List<LogEntity> logs;

    public UserEntity(String id, String nome, Integer idade, Integer score, Boolean ativo, String pais, TeamEntity equipe, List<LogEntity> logs) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.score = score;
        this.ativo = ativo;
        this.pais = pais;
        this.equipe = equipe;
        this.logs = logs;
    }

    public UserEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public TeamEntity getEquipe() {
        return equipe;
    }

    public void setEquipe(TeamEntity equipe) {
        this.equipe = equipe;
    }

    public List<LogEntity> getLogs() {
        return logs;
    }

    public void setLogs(List<LogEntity> logs) {
        this.logs = logs;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", score=" + score +
                ", ativo=" + ativo +
                ", pais='" + pais + '\'' +
                ", equipe=" + equipe +
                ", logs=" + logs +
                '}';
    }
}
