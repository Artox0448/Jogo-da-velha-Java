package jogador;

import jogo.Marca;
import jogo.Tabuleiro;
import java.io.*;

public class JogadorHumano implements Jogador, Cloneable
{
    private Marca          marca     = null;
    private Tabuleiro      tabDoJogo = null;
    private BufferedReader teclado   = new BufferedReader
                                        (new InputStreamReader
                                        (System.in));

    public JogadorHumano (Tabuleiro tab) throws Exception
    {
        // nao aceita tabuleiro null
        if (tab == null) throw new Exception ("Tabuleiro ausente");
 
        // atribui tab para tabDoJogo
        this.tabDoJogo = tab;
 
        // pede a marca ate o jogador digitar X ou O
        char simbolo = ' ';
 
        while (simbolo != 'X' && simbolo != 'O')
        {
            System.out.print ("Escolha sua marca (X ou O): ");
 
            String linha = this.teclado.readLine();
 
            // teclado fechado: nao ha como continuar
            if (linha == null) throw new Exception ("Entrada encerrada");
 
            // pega a primeira letra digitada, em maiuscula
            if (linha.trim().length() > 0)
                simbolo = Character.toUpperCase(linha.trim().charAt(0));
            else
                simbolo = ' ';
        }
 
        // instancia a marca escolhida
        this.marca = new Marca(simbolo);
    }

    public JogadorHumano (Tabuleiro tab, Marca mrc) throws Exception
    {
         // nao aceita tabuleiro nem marca null
        if (tab == null) throw new Exception ("Tabuleiro ausente");
 
        if (mrc == null) throw new Exception ("Marca ausente");
 
        // atribui tab para tabDoJogo e mrc para marca
        this.tabDoJogo = tab;
        this.marca     = mrc;
    }

    @Override
    public Marca getMarca ()
    {
        return this.marca;
    }

    @Override
    public void facaSuaJogada ()
    {
        // pergunta para o jogador onde ele quer
        // jogar, permitindo digitacao e chamando
        // os métodos apropriados de tabDoJogo

        boolean jogou = false;
 
        while (!jogou)
        {
            try
            {
                // mostra o tabuleiro atual
                System.out.println (this.tabDoJogo);
 
                // pergunta a linha
                System.out.print ("Sua jogada (" + this.marca + ") - linha (0 a 2): ");
                int lin = Integer.parseInt (this.teclado.readLine().trim());
 
                // pergunta a coluna
                System.out.print ("Sua jogada (" + this.marca + ") - coluna (0 a 2): ");
                int col = Integer.parseInt (this.teclado.readLine().trim());
 
                // so joga se a posicao estiver livre
                if (this.tabDoJogo.haMarcaNaPosicao (lin, col))
                    System.out.println ("Essa posicao ja esta ocupada!");
                else
                {
                    this.tabDoJogo.setMarcaNaPosicao (this.marca, lin, col);
                    jogou = true;
                }
            }
            catch (Exception erro)
            {
                // numero invalido, posicao fora do tabuleiro ou erro de leitura
                System.out.println ("Entrada invalida! Digite numeros de 0 a 2.");
            }
        }
    }

    public void vcGanhou ()
    {
        System.out.println (this.tabDoJogo);
        System.out.println ("Parabens, voce ganhou!");
    }

    public void vcPerdeu ()
    {
        System.out.println (this.tabDoJogo);
        System.out.println ("Que pena, voce perdeu!");
    }

    public void deuVelha ()
    {
        System.out.println (this.tabDoJogo);
        System.out.println ("Deu velha! Empate.");
    }

    public boolean querMaisUmaPartida ()
    {
         // pergunta ate receber S ou N
        while (true)
        {
            try
            {
                System.out.print ("Deseja jogar de novo? (S/N): ");
 
                String resposta = this.teclado.readLine();
 
                // teclado fechado: nao joga mais
                if (resposta == null)
                    return false;
 
                resposta = resposta.trim().toUpperCase();
 
                // S = true, N = false
                if (resposta.equals ("S"))
                    return true;
 
                if (resposta.equals ("N"))
                    return false;
 
                System.out.println ("Digite apenas S ou N.");
            }
            catch (Exception erro)
            {
                // erro de leitura: nao joga mais
                return false;
            }
        }
    }

    @Override
    public String toString ()
    {
        return ("Você esta com a marca " + this.marca);
    }

    @Override
    public boolean equals (Object obj)
    {
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;

        JogadorHumano j = (JogadorHumano)obj;

        return (this.marca.equals(j.marca) && this.tabDoJogo.equals(j.tabDoJogo));
    }

    @Override
    public int hashCode ()
    {
        int ret = 1;

        ret = ret * 2 + (this.marca).hashCode();
        ret = ret * 2 + (this.tabDoJogo).hashCode();

        if(ret < 0) ret = -ret;

        return ret;
    }

    // construtor de cópia
    public JogadorHumano (JogadorHumano modelo) throws Exception
    {
        if(modelo == null) throw new Exception("Objeto não pode ser nulo");

        this.marca = modelo.marca;
        this.tabDoJogo = modelo.tabDoJogo;
    }

    @Override
    public Object clone ()
    {
        JogadorHumano j = null;

        try {
            j = new JogadorHumano(this);
        } catch (Exception e) {
            //
        }

        return j;
    }
}