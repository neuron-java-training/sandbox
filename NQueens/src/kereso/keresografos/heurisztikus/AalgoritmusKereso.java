package kereso.keresografos.heurisztikus;

import java.util.Collections;
import java.util.Comparator;
import allapotter.*;
import kereso.Csucs;
import kereso.keresografos.KeresografosKereso;

public class AalgoritmusKereso extends KeresografosKereso
{
  public AalgoritmusKereso( Allapot kezdoAllapot )
  {
    nyiltak.add( new AalgoritmusCsucs( kezdoAllapot ) );
  }

  public AalgoritmusKereso( Allapot kezdoAllapot, int jellemzok )
  {
    super( jellemzok );
    nyiltak.add( new AalgoritmusCsucs( kezdoAllapot ) );
  }

  @Override
  protected void kiterjeszt( Csucs csucs )
  {
    for ( Operator op : Allapot.getOperatorok() )
      try
      {
        if ( csucs.getAllapot().elofeltetel( op ) )
        {
          AalgoritmusCsucs uj = new AalgoritmusCsucs( ( AalgoritmusCsucs )csucs, op );
          int index;
          if ( ( index = nyiltak.indexOf( uj ) ) != -1 )
          {
            AalgoritmusCsucs regi = ( AalgoritmusCsucs )nyiltak.get( index );
            if ( uj.koltseg < regi.koltseg )
            {
              nyiltak.remove( regi );
              nyiltak.add( uj );
            }
          }
          else if ( ( index = zartak.indexOf( uj ) ) != -1 )
          {
            AalgoritmusCsucs regi = ( AalgoritmusCsucs )zartak.get( index );
            if ( uj.koltseg < regi.koltseg )
            {
              zartak.remove( regi );
              nyiltak.add( uj );
            }
          }
          else
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
      AalgoritmusCsucs aktualis = ( AalgoritmusCsucs )nyiltak.getFirst();
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
          AalgoritmusCsucs acs1 = ( AalgoritmusCsucs )cs1,
            acs2 = ( AalgoritmusCsucs )cs2;
          return new Double( acs1.heurisztika + acs1.koltseg ).compareTo(
            new Double( acs2.heurisztika + acs2.koltseg ) );
        }
      } );
    }
    System.out.println( "nyiltak: " + nyiltak.size()
      + ", zartak: " + zartak.size() );
  }

  @Override
  public String toString()
  {
    return "Kereses A algoritmussal.\n" + jellemzok();
  }
}
