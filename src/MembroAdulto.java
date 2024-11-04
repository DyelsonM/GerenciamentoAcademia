public class MembroAdulto extends Membro {
    public MembroAdulto(String nome, int id, boolean pagamentoEmDia) {
        super(nome, id, pagamentoEmDia);
    }

    @Override
    public void imprimirInfo() {
        System.out.println("Membro Adulto - Nome: " + getNome() + ", ID: " + getId());
    }
}
