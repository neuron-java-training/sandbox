package kereso.keresografos.szisztematikus;

import allapotter.*;
import kereso.Csucs;
import kereso.keresografos.KeresografosKereso;

public class MelysegiKereso extends KeresografosKereso
{
  public MelysegiKereso( Allapot kezdoAllapot )
  {
    nyiltak.add( new Csucs( kezdoAllapot ) );
  }

  public MelysegiKereso( Allapot kezdoAllapot, int jellemzok )
  {
    super( jellemzok );
    nyiltak.add( new Csucs( kezdoAllapot ) );
  }

  @Override
  protected void kiterjeszt( Csucs csucs )
  {
    for ( Operator op : Allapot.getOperatorok() )
      try
      {
        if ( csucs.getAllapot().elofeltetel( op ) )
        {
          Csucs uj = new Csucs( csucs, op );
          if ( !( nyiltak.contains( uj ) || zartak.contains( uj ) ) )
            nyiltak.addFirst( uj );
        }
      }
      catch ( HibasOperatorException ex )
      {
        System.err.println( ex );
        System.exit( 1 );
      }
  }

  @Override
  public void keres()
  {
	  begin = System.nanoTime();
    while ( !nyiltak.isEmpty() )
    {
    	lepesszam++;
      Csucs aktualis = nyiltak.getFirst();
      if ( aktualis.getAllapot().celAllapot() )
      {
        terminalisok.add( aktualis );
        if ( osszesMegoldas )
        {
          zartak.add( nyiltak.removeFirst() );
          continue;
        }
        else
          break;
      }
      zartak.add( nyiltak.removeFirst() );
      kiterjeszt( aktualis );
    }
    end = System.nanoTime();
	runtime = end - begin;
  }

  @Override
  public String toString()
  {
    return "Kereses melysegi keresovel."/* + jellemzok()*/;
  }
}
