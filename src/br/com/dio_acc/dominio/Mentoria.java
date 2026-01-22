package br.com.dio_acc.dominio;

import java.time.LocalDate;
import java.util.Objects;

public final class Mentoria extends Conteudo {

    private  final LocalDate dataMentoria;

    public Mentoria(String titulo, String descricao,
                    LocalDate dataMentoria) {
        super(titulo, descricao);
        this.dataMentoria = Objects.requireNonNull((dataMentoria));
    }

    public LocalDate dataMentoria() { return dataMentoria; }

    @Override
    public double calcularXp() {
        return XP_PADRAO ;
    }
}
