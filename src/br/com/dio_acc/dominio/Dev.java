package br.com.dio_acc.dominio;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public final class Dev {

    private static final AtomicLong SEQUENCE = new AtomicLong(1);

    private final long id;
    private final String nome;
    private final Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private final Set<Conteudo
            > conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome) {
        this.id = SEQUENCE.getAndIncrement();
        this.nome = Objects.requireNonNull(nome);
    }

    public long id() { return id; }
    public String nome() { return nome; }

    public Set<Conteudo> getConteudosInscritos() {
        return Collections.unmodifiableSet(conteudosInscritos);
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return Collections.unmodifiableSet(conteudosConcluidos);
    }

    public void inscrever(Bootcamp bootcamp) {
        conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.addDev(this);
    }

    public Optional<Conteudo> progredir() {
        var primeiro = conteudosInscritos.stream().findFirst();
        primeiro.ifPresent(c -> {
            conteudosConcluidos.add(c);
            conteudosInscritos.remove(c);
        });
        // Retorna o priemiro conteudo da lista
        return primeiro;
    }

    public double calcularTotalXp() {
        return conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public List<Curso> exibirCursosInscritos() {
        return conteudosInscritos.stream()
                .filter(c -> c instanceof Curso)
                .map(c -> (Curso) c)
                .toList();
    }

    @Override
    public String toString() {
        return "Dev{id=%d, nome='%s'}".formatted(id, nome);
    }

}
