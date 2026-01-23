import br.com.dio_acc.dominio.Bootcamp;
import br.com.dio_acc.dominio.Curso;
import br.com.dio_acc.dominio.Mentoria;
import br.com.dio_acc.dominio.repositorio.DevRepo;
import br.com.dio_acc.dominio.servico.BootcampServico;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        Bootcamp bootcamp01 = new Bootcamp(
                "Bootcamp Java Orientado a Objetos",
                "POO com java",
                LocalDate.now(),
                LocalDate.now().plusDays(30)
        );
        Curso cursoJava = new Curso("Java para iniciantes",
                "Aprenda Java básico",
                14, 2.5 );
        Curso cursoSpring = new Curso("Java com Spring Boot",
                "Aprenda a usar Spring Boot",
                12, 3.2 );
        Mentoria mentoria01 = new Mentoria("Mentoria POO",
                "Dicas sobre Orientação a Objetos",
                LocalDate.now());

        bootcamp01.addConteudo(cursoJava);
        bootcamp01.addConteudo(cursoSpring);
        bootcamp01.addConteudo(mentoria01);

        // Repositorio salvo em memória
        DevRepo devRepo = new DevRepo();
        BootcampServico servico = new BootcampServico(devRepo);

        // Cadastrando os devs em memória
        var johnny   = servico.cadastrarDev("Johnny");
        var camila = servico.cadastrarDev("Camila");
        var paulo = servico.cadastrarDev("Paulo");

        servico.inscreverDevNoBootcamp(johnny, bootcamp01);
        servico.inscreverDevNoBootcamp(camila, bootcamp01);

        // Progresso no bootcamp
        servico.progredir(johnny);
        //Inscrita e concluído no primeiro curso e mentoria
        servico.progredir(camila);
        // Inscrita e concluído  segundo curso da lista
        servico.progredir(camila);

        //Imprimindo...
        System.out.println("====== BOOTCAMP ======");
        System.out.println(bootcamp01);
        System.out.println();

        System.out.println("=== DEVS INSCRITOS ===");
        System.out.println(johnny);
        System.out.println(camila);
        System.out.println();

        System.out.println("===== RELATÓRIOS =====");
        System.out.println(servico.relatorioDev(johnny));
        System.out.println(servico.relatorioDev(camila));
        System.out.println(servico.relatorioDev(paulo));

    }
}