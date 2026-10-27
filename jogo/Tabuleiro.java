package jogo;

public class Tabuleiro implements Cloneable
{
    // a principio, toda igual a null
    private Marca matriz [][];

    public Tabuleiro ()
    {
        this.matriz = new Marca [3][3];
    }

    private void validarPosicao (int lin, int col) throws Exception
    {
        if (lin < 0 || lin > 2 || col < 0 || col > 2)
            throw new Exception ("Posicao invalida");
    }

    public boolean haMarcaNaPosicao (int lin, int col) throws Exception
    {
        // verifico se em matriz[lin][col]
        // tem null, retornando false em caso
        // afirmativo, ou true em caso negativo
        // dar excecao caso lin ou col invalido

        // da excecao se a posicao for invalida
        this.validarPosicao(lin, col);
 
        // true se a posicao nao for null, false se for null
        return this.matriz[lin][col] != null;
    }

    public Marca getMarcaNaPosicao (int lin, int col) throws Exception
    {
        // retornar a marca que tem em
        // matriz[lin][col]
        // dar excecao caso lin ou col invalido

        // da excecao se a posicao for invalida
        this.validarPosicao(lin, col);
 
        // retorna a marca da posicao (pode ser null)
        return this.matriz[lin][col];
    }

    public void setMarcaNaPosicao (Marca mrc, int lin, int col) throws Exception
    {
        // colocar mrc em matriz[lin][col],
        // dar excecao caso lin ou col invalido
        // dar excecao caso mrc seja null

        // da excecao se a posicao for invalida
        this.validarPosicao(lin, col);
 
        // da excecao se a marca for null
        if (mrc == null)
            throw new Exception ("Marca ausente");
 
        // coloca a marca na posicao
        this.matriz[lin][col] = mrc;
    }

    @Override
    public String toString ()
    {
        // retornar em um String o tabuleiro
        // formatado para ser exibido na tela

        // cabecalho com os numeros das colunas
        String ret = "\n     0   1   2\n";
 
        for (int lin = 0; lin < 3; lin++)
        {
            // numero da linha no comeco
            ret += "  " + lin + " ";
 
            for (int col = 0; col < 3; col++)
            {
                // posicao vazia mostra espaco; senao mostra o simbolo
                if (this.matriz[lin][col] == null)
                    ret += "   ";
                else
                    ret += " " + this.matriz[lin][col] + " ";
 
                // separador vertical entre as colunas
                if (col < 2)
                    ret += "|";
            }
 
            ret += "\n";
 
            // separador horizontal entre as linhas
            if (lin < 2)
                ret += "    ---+---+---\n";
        }
 
        return ret;
    }

    @Override
    public boolean equals (Object obj)
    {
        // retornar true se this for igual a obj ou false caso contrario

        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;

        Tabuleiro t = (Tabuleiro)obj;

        for (int lin = 0; lin < 3; lin++)
            for (int col = 0; col < 3; col++)
            {
                // se a minha e null, a outra tambem precisa ser
                if (this.matriz[lin][col] == null)
                {
                    if (t.matriz[lin][col] != null)
                        return false;
                }
                // se a minha nao e null, precisa ser igual a outra
                else
                    if (!this.matriz[lin][col].equals(t.matriz[lin][col]))
                        return false;
            }
 
        return true; 
    }

    @Override
    public int hashCode ()
    {
        // faça
        // combina o hash de todas as posicoes (null conta como 0)
        int ret = 1;
 
        for (int lin = 0; lin < 3; lin++){
            for (int col = 0; col < 3; col++){
                if (this.matriz[lin][col] == null) ret = ret * 2 + 0;
                else ret = ret * 2 + this.matriz[lin][col].hashCode();
            }
        }

        
        if(ret < 0) ret = -ret;
 
        return ret;
    }

    // construtor de copia
    public Tabuleiro (Tabuleiro modelo) throws Exception
    {
        if(modelo == null) throw new Exception("Objeto não pode ser null");

        this.matriz = new Marca [3][3];
 
        // copia cada posicao (Marca e imutavel, entao copiar a referencia basta)
        for(int lin = 0; lin < 3; lin++){
            for(int col = 0; col < 3; col++){
                this.matriz[lin][col] = modelo.matriz[lin][col];
            }
        }
    }

    @Override
    public Object clone ()
    {
        Tabuleiro ret = null;
 
        try
        {
            ret = new Tabuleiro (this);
        }
        catch (Exception erro)
        {} // ignorando pois this nunca e null
 
        return ret;
    }
}