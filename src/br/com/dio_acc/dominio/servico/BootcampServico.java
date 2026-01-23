package br.com.dio_acc.dominio.servico;

import br.com.dio_acc.dominio.Bootcamp;
import br.com.dio_acc.dominio.Dev;
import br.com.dio_acc.dominio.repositorio.DevRepo;

import java.util.Objects;

public final class BootcampServico {

    private final DevRepo devRepo;

    public BootcampServico(DevRepo devRepo) {
        this.devRepo = Objects
                .requireNonNull(devRepo);
    }

    public Dev cadastrarDev(String nome) {
        var dev = new Dev(nome);
        return devRepo.save(dev);
    }

    public void inscreverDevNoBootcamp(Dev dev, Bootcamp bootcamp) {
        dev.inscrever(bootcamp);
    }

    public void progredir(Dev dev) {
        dev.progredir();
    }

    public String relatorioDev(Dev dev) {
        return """
                %s
                Inscritos: %s
                Concluídos: %s
                Total XP: %.2f
                """.formatted(
                dev,
                dev.getConteudosInscritos(),
                dev.getConteudosConcluidos(),
                dev.calcularTotalXp()
        );
    }
}
