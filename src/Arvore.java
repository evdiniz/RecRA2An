public class Arvore {
    private No raiz; // O nó raiz da árvore

    public Arvore() {
        raiz = new No(' '); // Raiz inicial sem símbolo
        carregarCodigoMorse(); // Configura os caracteres principais
    }

    private void carregarCodigoMorse() {
        // Carrega o alfabeto e números
        adicionar(".", 'E');
        adicionar("-", 'T');
        adicionar("..", 'I');
        adicionar(".-", 'A');
        adicionar("-.", 'N');
        adicionar("--", 'M');
        // Aqui você adicionaria o restante das letras e números
    }

    public void adicionar(String codigo, char simbolo) {
        No atual = raiz; // Começa na raiz
        for (char c : codigo.toCharArray()) {
            if (c == '.') { // Caminho para esquerda
                if (atual.ponto == null) atual.ponto = new No(' ');
                atual = atual.ponto;
            } else if (c == '-') { // Caminho para direita
                if (atual.traco == null) atual.traco = new No(' ');
                atual = atual.traco;
            }
        }
        atual.simbolo = simbolo; // Insere o símbolo no local correto
    }

    public String buscar(char simbolo) {
        return buscar(raiz, simbolo, "");
    }

    private String buscar(No atual, char simbolo, String codigo) {
        if (atual == null) return null; // Nó vazio
        if (atual.simbolo == simbolo) return codigo; // Encontrou o símbolo

        // Procura na esquerda e depois na direita
        String resultado = buscar(atual.ponto, simbolo, codigo + ".");
        if (resultado == null) resultado = buscar(atual.traco, simbolo, codigo + "-");

        return resultado;
    }

    public void exibir() {
        exibir(raiz, ""); // Começa da raiz
    }

    private void exibir(No atual, String prefixo) {
        if (atual != null) {
            System.out.println(prefixo + atual.simbolo);
            exibir(atual.ponto, prefixo + ".");
            exibir(atual.traco, prefixo + "-");
        }
    }
}
