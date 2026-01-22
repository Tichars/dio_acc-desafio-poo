package br.com.dio_acc.dominio;

import java.util.Objects;

public abstract sealed class Conteudo permits Curso, Mentoria {

    private final String titulo;
    private final String descricao;
    public static final double XP_PADRAO = 10d;

    protected Conteudo(String titulo, String descricao) {
        this.titulo = Objects.requireNonNull(titulo);
        this.descricao = Objects.requireNonNull(descricao);
    }

    public String titulo() { return titulo; }
    public String descricao() { return descricao; }

    public abstract double calcularXp();

    @Override
    public String toString() {
        return "%s[titulo='%s']".formatted(getClass().
                getSimpleName(), titulo);
    }
}
