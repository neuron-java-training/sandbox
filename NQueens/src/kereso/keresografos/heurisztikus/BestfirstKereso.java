package kereso.keresografos.heurisztikus;

import java.util.Collections;
import java.util.Comparator;
import allapotter.*;
import kereso.Csucs;
import kereso.keresografos.KeresografosKereso;

public class BestfirstKereso extends KeresografosKereso
{
  public BestfirstKereso( Allapot kezdoAllapot )
  {
    nyiltak.add( new BestfirstCsucs( kezdoAllapot ) );
  }

  public BestfirstKereso( Allapot kezdoAllapot, int jellemzok )
  {
    super( jellemzok );
    nyiltak.add( new BestfirstCsucs( kezdoAllapot ) );
  }

  @Override
  protected void kiterjeszt( Csucs csucs )
  {
    for ( Operator op : Allapot.getOperatorok() )
      try
      {
        if ( csucs.getAllapot().elofeltetel( op ) )
        {
          BestfirstCsucs uj = new BestfirstCsucs( ( BestfirstCsucs )csucs, op );
          if ( !( nyiltak.contains( uj ) || zartak.contains( uj ) ) )
            nyiltak.add( uj );
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
//      System.out.println( "nyiltak: " + nyiltak.size() +
//                          ", zartak: " + zartak.size() );
      kiirAdatbazis();
      BestfirstCsucs aktualis = ( BestfirstCsucs )nyiltak.getFirst();
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
      Collections.sort( nyiltak, new Comparator<Csucs>()
      {
        @Override
        public int compare( Csucs cs1, Csucs cs2 )
        {
          BestfirstCsucs bcs1 = ( BestfirstCsucs )cs1,
            bcs2 = ( BestfirstCsucs )cs2;
          return new Double( bcs1.heurisztika ).compareTo(
            new Double( bcs2.heurisztika ) );
        }
      } );
    }
    System.out.println( "nyiltak: " + nyiltak.size()
      + ", zartak: " + zartak.size() );
  }

  @Override
  public String toString()
  {
    return "Kereses best-first algoritmussal.\n" + jellemzok();
  }
}
