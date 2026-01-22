package br.com.dio_acc.dominio;

public final class Curso extends Conteudo {

    private final int cargaHOraria;
    private final double fatorXp;

    public Curso(String titulo, String descricao, int cargaHOraria, double fatorXp) {
        super(titulo, descricao);
        if (cargaHOraria <= 0) throw new
                IllegalArgumentException("Carga horária deve ser amior que 0! ");
        this.cargaHOraria = cargaHOraria;
        this.fatorXp = fatorXp <= 0 ? 1.0 : fatorXp;
    }

    public int getCargaHOraria() {return cargaHOraria; }
    public double getFatorXp() { return cargaHOraria; }

    @Override
    public double calcularXp() {
        // XP proporcional à carga horária
        return XP_PADRAO + (cargaHOraria * fatorXp);
    }
}
