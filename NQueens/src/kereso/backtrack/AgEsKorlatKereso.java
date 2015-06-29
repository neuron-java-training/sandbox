package kereso.backtrack;

import java.util.Set;
import java.util.Stack;
import allapotter.*;
import kereso.Kereso;

public class AgEsKorlatKereso extends Kereso
{
  public static final int KOR_FIGYELES = 4;
  
  protected Stack<AgEsKorlatCsucs> aktUt;
  protected double korlat;
  protected boolean korFigyeles;
  
  {
    aktUt = new Stack<AgEsKorlatCsucs>();
    korlat = 0;
    korFigyeles = false;
  }

  public AgEsKorlatKereso( Allapot kezdoAllapot )
  {
    aktUt.push( new AgEsKorlatCsucs( kezdoAllapot ) );
  }
  
  public AgEsKorlatKereso( Allapot kezdoAllapot, int jellemzok )
  {
    super( jellemzok );
    aktUt.push( new AgEsKorlatCsucs( kezdoAllapot ) );
    korFigyeles = ( jellemzok & KOR_FIGYELES ) != 0;
  }
  
  public AgEsKorlatKereso( Allapot kezdoAllapot, int jellemzok, double korlat )
  {
    this( kezdoAllapot, jellemzok );
    this.korlat = korlat;
  }
  
  @Override
  public String jellemzok()
  {
    String s = super.jellemzok();
    if ( korFigyeles )
      s += "Korfigyeles bekapcsolva.\n";
    else
      s += "Korfigyeles kikapcsolva.\n";
    if ( korlat > 0 )
      s += "Kezdeti korlat: " + korlat + "\n";
    else
      s += "Nincs kezdeti korlat.\n";
    return s;
  }
  
  @Override
  public void keres()
  {
    System.out.println( "Kezdeti korlat: " + korlat );
    while ( !aktUt.empty() )
    {
      AgEsKorlatCsucs aktualis = aktUt.peek();
      System.out.println( "Aktualis allapot: " + aktualis.getAllapot() +
                          ", koltseg: " + aktualis.getKoltseg() );
      if ( aktualis.getAllapot().celAllapot() &&
           ( korlat <= 0 || aktualis.getKoltseg() <= korlat ) )
      {
        System.out.println( "Megoldast talaltam, koltsege: " +
                            aktualis.getKoltseg() + ", visszalepek." );
        if ( aktualis.getKoltseg() < korlat )
          terminalisok.clear();
        if ( terminalisok.isEmpty() || osszesMegoldas &&
             !( megoldasAllapot && terminalisok.contains( aktualis ) ) )
          terminalisok.add( aktualis );
        korlat = aktualis.getKoltseg();
        aktUt.pop();
        continue;
      }
      if ( korlat > 0 && aktualis.getKoltseg() >= korlat )
      {
        System.out.println( "Elertem a korlatot, visszalepek." );
        aktUt.pop();
        continue;
      }
      Set<Operator> alkOp = aktualis.getAlkOp();
      if ( alkOp.isEmpty() )
      {
        System.out.println( "Nincs tobb alkalmazhato operator, visszalepek." );
        aktUt.pop();
        continue;
      }
      Operator op = alkOp.iterator().next();
      System.out.println( "Ezt az operatort alkalmazom: " + op );
      AgEsKorlatCsucs uj = new AgEsKorlatCsucs( aktualis, op );
      System.out.println( "Az uj allapot: " + uj.getAllapot() );
      if ( korFigyeles && aktUt.contains( uj ) )
        System.out.println( "Kort talaltam." );
      else
        aktUt.push( uj );
      alkOp.remove( op );
    }
  }
  
  @Override
  public String toString()
  {
    return "Kereses ag es korlat algoritmussal.\n" + jellemzok();
  }
}
