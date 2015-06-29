package kereso.keresografos.szisztematikus;

import allapotter.*;
import kereso.Csucs;
import kereso.keresografos.KeresografosKereso;

public class SzelessegiKereso extends KeresografosKereso
{
  public SzelessegiKereso( Allapot kezdoAllapot )
  {
    nyiltak.add( new Csucs( kezdoAllapot ) );
  }

  public SzelessegiKereso( Allapot kezdoAllapot, int jellemzok )
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
            nyiltak.addLast( uj );
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
    while ( !nyiltak.isEmpty() )
    {
      System.out.println( "nyiltak: " + nyiltak.size()
        + ", zartak: " + zartak.size() );
//      kiirAdatbazis();
      Csucs aktualis = nyiltak.getFirst();
      if ( aktualis.getAllapot().celAllapot() )
      {
        terminalisok.add( aktualis );
        if ( osszesMegoldas )
        {
          System.out.println( "Megoldast talaltam." );
          zartak.add( nyiltak.removeFirst() );
          continue;
        }
        else
          break;
      }
      zartak.add( nyiltak.removeFirst() );
      kiterjeszt( aktualis );
    }
    System.out.println( "nyiltak: " + nyiltak.size()
      + ", zartak: " + zartak.size() );
  }

  @Override
  public String toString()
  {
    return "Kereses szelessegi keresovel.\n" + jellemzok();
  }
}
