import br.com.dio.desafio.dominio.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Curso curso1 = new Curso("Curso Java", "Descrição curso Java", 8);
        Curso curso2 = new Curso("Curso JS", "Descrição curso JS", 4);

        Mentoria mentoria = new Mentoria(
                "Mentoria Java",
                "Descrição mentoria Java",
                LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev ana = new Dev();
        ana.setNome("Ana");
        ana.inscreverBootcamp(bootcamp);
        ana.progredir();
        ana.progredir();

        Dev joao = new Dev();
        joao.setNome("João");
        joao.inscreverBootcamp(bootcamp);
        joao.progredir();
        joao.progredir();
        joao.progredir();

        exibirStatus(ana);
        System.out.println("\n------------------------------\n");
        exibirStatus(joao);
    }

    private static void exibirStatus(Dev dev) {
        System.out.println("================================");
        System.out.println(" 🧙  DEV: " + dev.getNome());
        System.out.println("================================\n");

        System.out.println("📜 MISSÕES ATIVAS:");
        for (Conteudo c : dev.getConteudosInscritos()) {
            System.out.println(" - " + formatarConteudo(c));
        }

        System.out.println("\n🏅 MISSÕES COMPLETAS:");
        for (Conteudo c : dev.getConteudosConcluidos()) {
            System.out.println(" - " + formatarConteudo(c));
        }

        System.out.println("\n⭐ XP TOTAL: " + dev.calcularTotalXp());
    }

    private static String formatarConteudo(Conteudo c) {
        if (c instanceof Curso curso) {
            return "[CURSO] " + curso.getTitulo() + " • " + curso.getCargaHoraria() + "h";
        } else if (c instanceof Mentoria mentoria) {
            return "[MENTORIA] " + mentoria.getTitulo() +
                    " • " + mentoria.getData();
        }
        return c.toString();
    }
}
