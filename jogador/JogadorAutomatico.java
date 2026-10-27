package jogador;

import jogo.Marca;
import jogo.Tabuleiro;

public class JogadorAutomatico implements Jogador, Cloneable
{
    private Marca     marca     = null;
    private Tabuleiro tabDoJogo = null;

    public JogadorAutomatico (Tabuleiro tab) throws Exception
    {   
        if (tab == null)
            throw new Exception ("Tabuleiro ausente");
        
        tabDoJogo = tab;
        // atribuir tab para tabDoJogo
        // fazer o jogador escolher sua marca
        // via sorteio de numeros aleatorio
        if ((int)(Math.random()*2) == 0)
            marca=new Marca('X');
        else
            marca=new Marca('O');
    }

    public JogadorAutomatico (Tabuleiro tab, Marca mrc) throws Exception
    {
        // nao aceita tabuleiro nem marca null
        if (tab == null)
            throw new Exception ("Tabuleiro ausente");
 
        if (mrc == null)
            throw new Exception ("Marca ausente");
 
        // atribui tab para tabDoJogo e mrc para marca
        this.tabDoJogo = tab;
        this.marca = mrc;
    }

    @Override
    public Marca getMarca ()
    {
        return this.marca;
    }

    public void facaSuaJogada ()
    {
        try
        {
            // marca do adversario (a oposta do jogador pessoa), usada para bloquear
            Marca adv = new Marca(this.marca.getSimbolo()=='X'?'O':'X');

            // tentando ganhar na linha 0
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(0,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);

            // tentando ganhar na linha 1
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,1))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);

            // tentando ganhar na linha 2
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,2) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            
            // tentando ganhar na coluna 0
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
                this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,0) &&
                this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);

            // tentando ganhar na coluna 1
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,1))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);

            // tentando ganhar na coluna 2
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,2) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);

            // tentando ganhar na diagonal principal
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);

            // tentando ganhar na diagonal secundaria
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);

            // tentando atrapalhar vitoria na linha 0
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(0,2))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);

            // tentando atrapalhar vitoria na linha 1
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(1,0) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,2))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);

            // tentando atrapalhar vitoria na linha 2
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(2,0) &&
                this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,1) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);

            // tentando atrapalhar vitoria na coluna 0
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,0) &&
                this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);

            // tentando atrapalhar vitoria na coluna 1
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,1))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);

            // tentando atrapalhar vitoria na coluna 2
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,2) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);

            // tentando atrapalhar vitoria na diagonal principal
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);

            // tentando atrapalhar vitoria na diagonal secundaria
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(adv))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(adv) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(adv) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);

            // tentando jogada de futuro (ha 1 marca do jogador e mais nada; vamos la e plantamos outra marca) na coluna 0
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,0) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,0) &&
                this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);

            // tentando jogada de futuro (ha 1 marca do jogador e mais nada; vamos la e plantamos outra marca) na coluna 1
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,1))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,1))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);

            // tentando jogada de futuro (ha 1 marca do jogador e mais nada; vamos la e plantamos outra marca) na coluna 2
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,2) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,2) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);

            // tentando jogada de futuro (ha 1 marca do jogador e mais nada; vamos la e plantamos outra marca) na diagonal principal
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);

            // tentando jogada de futuro (ha 1 marca do jogador e mais nada; vamos la e plantamos outra marca) na diagonal secundaria
            else
            if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);

            // termine jogando num lugar qualquer que esteja livre
            else{
                boolean jogou = false;
                for (int lin = 0; lin < 3 && !jogou; lin++)
                    for (int col = 0; col < 3 && !jogou; col++)
                        if (!this.tabDoJogo.haMarcaNaPosicao(lin,col)){
                            this.tabDoJogo.setMarcaNaPosicao(this.marca, lin,col);
                            jogou = true;
                        }
            }
        }
        catch (Exception erro)
        {} // ignorando pois sei que n o estou usando posicao invalida nem comparando com equals um null
    }

    @Override
    public String toString ()
    {
        return ("Adversario com a marca " + this.marca);
    }

    @Override
    public boolean equals (Object obj)
    {
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;

        JogadorAutomatico j = (JogadorAutomatico) obj;

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
    public JogadorAutomatico (JogadorAutomatico modelo) throws Exception
    {
        if(modelo == null) throw new Exception("Objeto não pode ser nulo");

        this.marca = modelo.marca;
        this.tabDoJogo = modelo.tabDoJogo;
    }

    @Override
    public Object clone ()
    {
        JogadorAutomatico j = null;

        try {
            j = new JogadorAutomatico(this);
        } catch (Exception e) {
            // não vai dar erro pois já é verificado no construtor de copia
        }

        return j;
    }
}