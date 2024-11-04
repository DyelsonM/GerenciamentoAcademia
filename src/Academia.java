import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Academia {
    private List<Membro> listaMembros;
    private List<Aula> listaAulas;
    private List<RegistroFrequencia> listaRegistrosFrequencia;

    public Academia() {
        this.listaMembros = new ArrayList<>();
        this.listaAulas = new ArrayList<>();
        this.listaRegistrosFrequencia = new ArrayList<>();
    }

    public void adicionarMembro(Membro membro) {
        listaMembros.add(membro);
    }

    public void adicionarAula(Aula aula) {
        listaAulas.add(aula);
    }

    public boolean inscreverMembroEmAula(int idMembro, String nomeAula) {
        Membro membro = listaMembros.stream()
                .filter(m -> m.getId() == idMembro)
                .findFirst()
                .orElse(null);

        if (membro == null) {
            System.out.println("Membro com ID " + idMembro + " não encontrado.");
            return false;
        }

        Aula aula = listaAulas.stream()
                .filter(a -> a.getNome().equalsIgnoreCase(nomeAula))
                .findFirst()
                .orElse(null);

        if (aula == null) {
            System.out.println("Aula com nome " + nomeAula + " não encontrada.");
            return false;
        }

        if (aula.inscreverMembro(membro)) {
            System.out.println("Membro " + membro.getNome() + " inscrito com sucesso na aula " + aula.getNome());
            return true;
        } else {
            System.out.println("Não foi possível inscrever o membro. Verifique pagamento ou capacidade.");
            return false;
        }
    }

    public void registrarFrequencia(int idMembro, String nomeAula, LocalDate data) {
        Membro membro = listaMembros.stream()
                .filter(m -> m.getId() == idMembro)
                .findFirst()
                .orElse(null);

        Aula aula = listaAulas.stream()
                .filter(a -> a.getNome().equalsIgnoreCase(nomeAula))
                .findFirst()
                .orElse(null);

        if (membro != null && aula != null) {
            RegistroFrequencia registro = new RegistroFrequencia(aula, membro, data);
            listaRegistrosFrequencia.add(registro);
            System.out.println("Frequência registrada para o membro " + membro.getNome() + " na aula " + aula.getNome());
        } else {
            System.out.println("Erro ao registrar frequência.");
        }
    }

    public void listarRegistrosFrequencia() {
        for (RegistroFrequencia registro : listaRegistrosFrequencia) {
            System.out.println("Membro: " + registro.getMembro().getNome() + ", Aula: " + registro.getAula().getNome() + ", Data: " + registro.getData());
        }
    }
}
