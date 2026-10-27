package jogo;

public class AnalistaSituacional
{
    private Tabuleiro tabDoJogo;

    public AnalistaSituacional (Tabuleiro tab) throws Exception
    {
        // nao aceita tabuleiro null
        if (tab == null)
            throw new Exception ("Tabuleiro ausente");
 
        // coloca tab em tabDoJogo
        this.tabDoJogo = tab;
    }

    private Marca vencedorNaSequencia (int l1, int c1, int l2, int c2, int l3, int c3) throws Exception
    {
        // a primeira posicao precisa ter marca (sequencia vazia nao e vitoria)
        if (!this.tabDoJogo.haMarcaNaPosicao(l1, c1))
            return null;
 
        Marca mrc = this.tabDoJogo.getMarcaNaPosicao(l1, c1);
 
        // as outras duas precisam ser iguais a primeira
        if (mrc.equals(this.tabDoJogo.getMarcaNaPosicao(l2, c2)) &&
            mrc.equals(this.tabDoJogo.getMarcaNaPosicao(l3, c3)))
            return mrc;
 
        return null;
    }

    public Marca getMarcaDoVencedor ()
    {
        // descobrir se ha um vencedor e retornar
        // a marca dele; retornara null, quando
        // nao houver vencedor

        try
        {
            Marca vencedor;
 
            // verifica as 3 linhas e as 3 colunas
            for (int i = 0; i < 3; i++)
            {
                // linha i
                vencedor = this.vencedorNaSequencia(i,0, i,1, i,2);
                if (vencedor != null)
                    return vencedor;
 
                // coluna i
                vencedor = this.vencedorNaSequencia(0,i, 1,i, 2,i);
                if (vencedor != null)
                    return vencedor;
            }
 
            // diagonal principal
            vencedor = this.vencedorNaSequencia(0,0, 1,1, 2,2);
            if (vencedor != null)
                return vencedor;
 
            // diagonal secundaria
            vencedor = this.vencedorNaSequencia(0,2, 1,1, 2,0);
            if (vencedor != null)
                return vencedor;
        }
        catch (Exception erro)
        {} // ignorando pois so uso posicoes validas
 
        // sem vencedor
        return null;
    }

    private boolean tabuleiroCheio ()
    {
        // verificar se todas as posicoes do
        // tabuleiro estao preenchidas (!=null)
        // retornando true em caso afirmativo,
        // ou false em caso negativo

        try
        {
            // se achar uma posicao vazia, o tabuleiro nao esta cheio
            for (int lin = 0; lin < 3; lin++)
                for (int col = 0; col < 3; col++)
                    if (!this.tabDoJogo.haMarcaNaPosicao(lin, col))
                        return false;
        }
        catch (Exception erro)
        {} // ignorando pois so uso posicoes validas
 
        // todas as posicoes preenchidas
        return true;
    }

    public boolean fimDeJogo ()
    {
        // se getMarcaDoVencedor != null,
        // retorna true
        // se tabuleiroCheio == true,
        // retorna true
        // caso contrario, retorna false

        // fim de jogo se ha vencedor
        if (this.getMarcaDoVencedor() != null)
            return true;
 
        // fim de jogo se o tabuleiro esta cheio
        if (this.tabuleiroCheio())
            return true;
 
        // caso contrario o jogo continua
        return false;
    }

    @Override
    public String toString ()
    {
         return ("Analista do tabuleiro:" + this.tabDoJogo);
    }

    @Override
    public boolean equals (Object obj)
    {
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;

        AnalistaSituacional a = (AnalistaSituacional)obj;

        return (this.tabDoJogo.equals(a.tabDoJogo));
    }

    @Override
    public int hashCode ()
    {
        int ret = 1;
        
        ret = ret * 2 + (this.tabDoJogo).hashCode();

        if(ret < 0) ret = -ret;

        return ret;
    }
}