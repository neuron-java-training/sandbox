package kereso.keresografos.szisztematikus;

import allapotter.*;
import kereso.Csucs;

public class OptimalisCsucs extends Csucs
{
  protected double koltseg;
  
  public OptimalisCsucs( Allapot kezdoAllapot )
  {
    super( kezdoAllapot );
    koltseg = 0;
  }

  public OptimalisCsucs( OptimalisCsucs szulo, Operator operator )
  {
    super( szulo, operator );
    koltseg = szulo.koltseg +
      ( operator instanceof KoltsegesOperator ?
      ( ( KoltsegesOperator )operator ).koltseg( szulo.allapot ) : 1 );
  }
  
  @Override
  public String toString()
  {
    return super.toString() + ", koltseg=" + koltseg;
  }
}
