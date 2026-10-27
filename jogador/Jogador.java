package jogador;

import jogo.Marca;

public interface Jogador
{
    // faz a jogada do jogador no tabuleiro
    public void facaSuaJogada ();
 
    // retorna a marca do jogador
    public Marca getMarca ();
}