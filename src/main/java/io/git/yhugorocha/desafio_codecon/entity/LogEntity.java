package io.git.yhugorocha.desafio_codecon.entity;

import java.time.LocalDate;

public class LogEntity {

    private LocalDate data;
    private String acao;

    public LogEntity(LocalDate data, String acao) {
        this.data = data;
        this.acao = acao;
    }

    public LogEntity() {
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    @Override
    public String toString() {
        return "LogEntity{" +
                "data=" + data +
                ", acao='" + acao + '\'' +
                '}';
    }
}
