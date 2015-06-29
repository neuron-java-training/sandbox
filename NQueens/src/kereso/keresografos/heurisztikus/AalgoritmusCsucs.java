package kereso.keresografos.heurisztikus;

import allapotter.*;

public class AalgoritmusCsucs extends BestfirstCsucs
{
  protected double koltseg;
  
  protected AalgoritmusCsucs( Allapot kezdoAllapot )
  {
    super( kezdoAllapot );
    koltseg = 0;
  }
  
  protected AalgoritmusCsucs( AalgoritmusCsucs szulo, Operator operator )
  {
    super( szulo, operator );
    koltseg = szulo.koltseg + ( operator instanceof KoltsegesOperator ?
      ( ( KoltsegesOperator )operator ).koltseg( szulo.allapot ) : 1 );
  }
  
  @Override
  public String toString()
  {
    return super.toString() + ", koltseg=" + koltseg;
  }
}
