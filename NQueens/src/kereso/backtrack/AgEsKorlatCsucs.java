package kereso.backtrack;

import allapotter.*;

public class AgEsKorlatCsucs extends BacktrackCsucs
{
  protected double koltseg;
  
  public AgEsKorlatCsucs( Allapot allapot )
  {
    super( allapot );
    koltseg = 0;
  }
  
  public AgEsKorlatCsucs( AgEsKorlatCsucs szulo, Operator operator )
  {
    super( szulo, operator );
    koltseg = szulo.koltseg + ( operator instanceof KoltsegesOperator ?
      ( ( KoltsegesOperator )operator ).koltseg( szulo.allapot ) : 1 );
  }
  
  public double getKoltseg()
  {
    return koltseg;
  }
  
  @Override
  public String toString()
  {
    return super.toString() + ", koltseg=" + koltseg;
  }
}
