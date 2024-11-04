public class MembroInfantil extends Membro {
    public MembroInfantil(String nome, int id, boolean pagamentoEmDia) {
        super(nome, id, pagamentoEmDia);
    }

    @Override
    public void imprimirInfo() {
        System.out.println("Membro Infantil - Nome: " + getNome() + ", ID: " + getId());
    }
}
