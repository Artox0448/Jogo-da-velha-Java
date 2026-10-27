package jogo;

public class Marca
{
    private char simbolo;

    public Marca (char smb) throws Exception
    {
        // validar smb, garantindo que ele
        // seja 'X' ou 'O' e coloca-lo em
        // simbolo
        // dar excecao em caso de valor invalido

        // valida smb: so aceita 'X' ou 'O', senao lanca excecao
        if (smb != 'X' && smb != 'O')
            throw new Exception ("Simbolo invalido");
 
        // guarda o simbolo valido no atributo
        this.simbolo = smb;
    }

    public char getSimbolo ()
    {
        // retornar simbolo
        return this.simbolo;
    }

    @Override
    public String toString ()
    {
        return ""+simbolo;
    }

    @Override
    public boolean equals (Object obj)
    {
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;

        Marca m = (Marca)obj;

        return simbolo == m.simbolo;
    }

    @Override
    public int hashCode ()
    {
        int ret = 1;

        ret = ret * 2 + (Character.valueOf(simbolo)).hashCode();

        if(ret < 0) ret = -ret;

        return ret;
    }
}