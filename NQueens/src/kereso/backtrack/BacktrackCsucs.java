package kereso.backtrack;

import java.util.Set;
import java.util.HashSet;
import allapotter.*;
import kereso.Csucs;

public class BacktrackCsucs extends Csucs
{
  protected Set<Operator> alkOp;

  public BacktrackCsucs( Allapot kezdoAllapot )
  {
    super( kezdoAllapot );
    alkOp = new HashSet<Operator>();
    for ( Operator op : Allapot.getOperatorok() )
      try
      {
        if ( allapot.elofeltetel( op ) )
          alkOp.add( op );
      }
      catch ( HibasOperatorException ex )
      {
        System.err.println( ex );
        System.exit( 1 );
      }
  }

  public BacktrackCsucs( BacktrackCsucs szulo, Operator operator )
  {
    super( szulo, operator );
    alkOp = new HashSet<Operator>();
    for ( Operator op : Allapot.getOperatorok() )
      try
      {
        if ( allapot.elofeltetel( op ) )
          alkOp.add( op );
      }
      catch ( HibasOperatorException ex )
      {
        System.err.println( ex );
        System.exit( 1 );
      }
  }

  public Set<Operator> getAlkOp()
  {
    return alkOp;
  }
}
