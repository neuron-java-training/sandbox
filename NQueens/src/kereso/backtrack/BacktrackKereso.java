package kereso.backtrack;

import java.util.LinkedList;
import java.util.Set;

import allapotter.*;
import kereso.Kereso;

public class BacktrackKereso extends Kereso
{
  public static final int KOR_FIGYELES = 4;
  
  protected LinkedList<BacktrackCsucs> aktUt;
  protected int korlat;
  protected boolean korFigyeles;
  
  {
    aktUt = new LinkedList<BacktrackCsucs>();
    korlat = 0;
    korFigyeles = false;
  }

  public BacktrackKereso( Allapot kezdoAllapot )
  {
    aktUt.push( new BacktrackCsucs( kezdoAllapot ) );
  }
  
  public BacktrackKereso( Allapot kezdoAllapot, int jellemzok )
  {
    super( jellemzok );
    aktUt.push( new BacktrackCsucs( kezdoAllapot ) );
    korFigyeles = ( jellemzok & KOR_FIGYELES ) != 0;
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
      s += "Uthosszkorlat: " + korlat + "\n";
    else
      s += "Uthosszkorlat-ellenorzes kikapcsolva.\n";
    return s;
  }
  
  @Override
  public void keres()
  {
	  begin = System.nanoTime();
    while ( !aktUt.isEmpty() )
    {
    	lepesszam++;
      BacktrackCsucs aktualis = aktUt.peek();
      //System.out.println( "Aktualis allapot: " + aktualis.getAllapot() );
      if ( aktualis.getAllapot().celAllapot() )
      {
        if ( !( megoldasAllapot && terminalisok.contains( aktualis ) ) )
          terminalisok.add( aktualis );
        if ( osszesMegoldas )
        {
          //System.out.println( "Megoldast talaltam, visszalepek." );
          aktUt.pop();
          continue;
        }
        else
          break;
      }
      if ( korlat > 0 && aktualis.getMelyseg() == korlat )
      {
        //System.out.println( "Elertem a korlatot, visszalepek." );
        aktUt.pop();
        continue;
      }
      Set<Operator> alkOp = aktualis.getAlkOp();
      if ( alkOp.isEmpty() )
      {
       // System.out.println( "Nincs tobb alkalmazhato operator, visszalepek." );
        aktUt.pop();
        continue;
      }
      Operator op = alkOp.iterator().next();
     // System.out.println( "Ezt az operatort alkalmazom: " + op );
      BacktrackCsucs uj = new BacktrackCsucs( aktualis, op );
      //System.out.println( "Az uj allapot: " + uj.getAllapot() );
      if ( korFigyeles && aktUt.contains( uj ) )
        System.out.println( "Kort talaltam." );
      else
        aktUt.push( uj );
      alkOp.remove( op );
    }
    end = System.nanoTime();
	runtime = end - begin;
  }
  
  @Override
  public String toString()
  {
    return "Kereses backtrack algoritmussal."/* + jellemzok()*/;
  }
}
