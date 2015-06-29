package kereso.keresografos.heurisztikus;

import allapotter.*;
import kereso.Csucs;

public class BestfirstCsucs extends Csucs
{
  protected double heurisztika;
  
  public BestfirstCsucs( Allapot kezdoAllapot )
  {
    super( kezdoAllapot );
    heurisztika = allapot instanceof HeurisztikusAllapot ?
      ( ( HeurisztikusAllapot )allapot ).heurisztika() : 0;
  }
  
  public BestfirstCsucs( BestfirstCsucs szulo, Operator operator )
  {
    super( szulo, operator );
    heurisztika = allapot instanceof HeurisztikusAllapot ?
      ( ( HeurisztikusAllapot )allapot ).heurisztika() : 0;
  }
  
  @Override
  public String toString()
  {
    return super.toString() + ", heurisztika=" + heurisztika;
  }
}
