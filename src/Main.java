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
        System.out.println("Conteúdos inscritos de Ana: " + ana.getConteudosInscritos());
        ana.progredir();
        ana.progredir();
        System.out.println("Concluídos Ana: " + ana.getConteudosConcluidos());
        System.out.println("XP: " + ana.calcularTotalXp());

        System.out.println("\n-----------------\n");

        Dev joao = new Dev();
        joao.setNome("João");
        joao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos João: " + joao.getConteudosInscritos());
        joao.progredir();
        joao.progredir();
        joao.progredir();
        System.out.println("Concluídos João: " + joao.getConteudosConcluidos());
        System.out.println("XP: " + joao.calcularTotalXp());
    }
}
