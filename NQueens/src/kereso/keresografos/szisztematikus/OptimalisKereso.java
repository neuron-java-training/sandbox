package kereso.keresografos.szisztematikus;

import java.util.Collections;
import java.util.Comparator;
import allapotter.*;
import kereso.Csucs;
import kereso.keresografos.KeresografosKereso;

public class OptimalisKereso extends KeresografosKereso
{
  public OptimalisKereso( Allapot kezdoAllapot )
  {
    nyiltak.add( new OptimalisCsucs( kezdoAllapot ) );
  }

  public OptimalisKereso( Allapot kezdoAllapot, int jellemzok )
  {
    super( jellemzok );
    nyiltak.add( new OptimalisCsucs( kezdoAllapot ) );
  }

  @Override
  protected void kiterjeszt( Csucs csucs )
  {
    for ( Operator op : Allapot.getOperatorok() )
      try
      {
        if ( csucs.getAllapot().elofeltetel( op ) )
        {
          OptimalisCsucs uj = new OptimalisCsucs( ( OptimalisCsucs )csucs, op );
          int index;
          if ( ( index = nyiltak.indexOf( uj ) ) != -1 )
          {
            OptimalisCsucs regi = ( OptimalisCsucs )nyiltak.get( index );
            if ( uj.koltseg < regi.koltseg )
            {
              nyiltak.remove( regi );
              nyiltak.add( uj );
            }
          }
          else if ( !zartak.contains( uj ) )
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
      OptimalisCsucs aktualis = ( OptimalisCsucs )nyiltak.getFirst();
      if ( !terminalisok.isEmpty() && aktualis.koltseg
        > ( ( OptimalisCsucs )terminalisok.iterator().next() ).koltseg )
        break;
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
          OptimalisCsucs ocs1 = ( OptimalisCsucs )cs1,
            ocs2 = ( OptimalisCsucs )cs2;
          return new Double( ocs1.koltseg ).compareTo(
            new Double( ocs2.koltseg ) );
        }
      } );
    }
    System.out.println( "nyiltak: " + nyiltak.size()
      + ", zartak: " + zartak.size() );
  }

  @Override
  public String toString()
  {
    return "Kereses optimalis keresovel.\n" + jellemzok();
  }
}
