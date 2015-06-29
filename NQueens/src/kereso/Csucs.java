package kereso;

import allapotter.*;

public class Csucs
{
  protected Allapot allapot;
  protected Csucs szulo;
  protected Operator operator;
  protected int melyseg;
  
  public Csucs( Allapot kezdoAllapot )
  {
    allapot = kezdoAllapot;
    szulo = null;
    operator = null;
    melyseg = 0;
  }
  
  public Csucs( Csucs szulo, Operator operator )
  {
    try
    {
      allapot = szulo.allapot.alkalmaz( operator );
    }
    catch ( HibasOperatorException ex )
    {
      System.err.println( ex );
      System.exit( 1 );
    }
    this.szulo = szulo;
    this.operator = operator;
    melyseg = szulo.melyseg + 1;
  }
  
  public Allapot getAllapot()
  {
    return allapot;
  }
  
  public Csucs getSzulo()
  {
    return szulo;
  }
  
  public Operator getOperator()
  {
    return operator;
  }
  
  public int getMelyseg()
  {
    return melyseg;
  }
  
  @Override
  public boolean equals( Object obj )
  {
    return obj instanceof Csucs &&
           allapot.equals( ( ( Csucs )obj ).allapot );
  }
  
  @Override
  public String toString()
  {
    return ( operator == null ? "" : operator + " => " ) +
           allapot + " (" + melyseg + ")";
  }
}
