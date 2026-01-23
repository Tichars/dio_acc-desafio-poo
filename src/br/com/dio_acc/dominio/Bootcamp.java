package br.com.dio_acc.dominio;

import java.time.LocalDate;
import java.util.*;


public class Bootcamp {

    private final String nome;
    private final String descricao;
    private final LocalDate dataInicial;
    private final LocalDate dataFinal;

    private final Set<Conteudo> conteudos = new LinkedHashSet<>();
    private final Set<Dev> devs = new LinkedHashSet<>();

    public Bootcamp(String nome,
                    String descricao,
                    LocalDate dataInicial,
                    LocalDate dataFinal) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        if (dataFinal.isBefore(dataInicial)) throw new
                IllegalArgumentException("Data final não pode ser antes da data inicial! ");
    }
    public String nome() { return nome; }
    public String descricao() { return descricao; }
    public LocalDate dataInicial() { return dataInicial; }
    public LocalDate dataFinal() { return dataFinal; }

    public Set<Conteudo> getConteudos() {
        return Collections.unmodifiableSet(conteudos);
    }
    public Set<Dev> getDevs() {

        return Collections.unmodifiableSet(devs);
    }

    public void addConteudo(Conteudo c) { conteudos.add(Objects
            .requireNonNull(c)); }

    public void addDev(Dev d) {
        devs.add(Objects.requireNonNull(d)); }

    @Override
    public String toString() {

        return "Bootcamp '%s' (%s a %s)".formatted(nome, dataInicial, dataFinal);
    }







}
