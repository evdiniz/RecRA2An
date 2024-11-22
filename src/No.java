public class No {
    public char simbolo; // O caractere armazenado no nó
    public No ponto;     // Caminho para o lado esquerdo (.)
    public No traco;     // Caminho para o lado direito (-)

    public No(char simbolo) {
        this.simbolo = simbolo; // Define o caractere
        this.ponto = null;      // Inicializa os filhos como nulos
        this.traco = null;
    }
}
