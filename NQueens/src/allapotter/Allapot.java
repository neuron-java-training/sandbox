package allapotter;

import java.util.Set;

public abstract class Allapot
{
	protected static Set<Operator> operatorok;
	protected static int allapotok = 0;
  
  public static Set<Operator> getOperatorok()
  {
    return operatorok;
  }
  
  public abstract boolean celAllapot();
  public abstract boolean elofeltetel( Operator op ) throws HibasOperatorException;
  public abstract Allapot alkalmaz( Operator op ) throws HibasOperatorException;
	
	public static int getAllapotok() {
		return allapotok;
	}
}
