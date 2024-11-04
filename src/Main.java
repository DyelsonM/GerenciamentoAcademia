import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Academia academia = new Academia();

        Membro membro1 = new MembroAdulto("Dyelson", 1, true);
        Membro membro2 = new MembroInfantil("João", 2, true);
        academia.adicionarMembro(membro1);
        academia.adicionarMembro(membro2);

        Aula aula1 = new Aula("Yoga", "Ana", 4);
        Aula aula2 = new Aula("Natação", "Carlos", 6);
        academia.adicionarAula(aula1);
        academia.adicionarAula(aula2);

        academia.inscreverMembroEmAula(1, "Yoga");
        academia.inscreverMembroEmAula(2, "Natação");

        academia.registrarFrequencia(1, "Yoga", LocalDate.now());
        academia.registrarFrequencia(2, "Natação", LocalDate.now());

        academia.listarRegistrosFrequencia();
    }
}
