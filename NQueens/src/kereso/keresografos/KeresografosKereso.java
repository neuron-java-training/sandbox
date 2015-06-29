package kereso.keresografos;

import java.util.LinkedList;
import kereso.*;

public abstract class KeresografosKereso extends Kereso
{
  protected LinkedList<Csucs> nyiltak, zartak;
  
  {
    nyiltak = new LinkedList<Csucs>();
    zartak = new LinkedList<Csucs>();
  }

  protected KeresografosKereso()
  {
  }
  
  protected KeresografosKereso( int jellemzok )
  {
    super( jellemzok );
  }

  protected void kiirAdatbazis()
  {
    System.out.println( "Nyilt csucsok:" );
    for ( Csucs cs : nyiltak )
      System.out.println( cs );
    System.out.println( "Zart csucsok:" );
    for ( Csucs cs : zartak )
      System.out.println( cs );
    System.out.println();
  }

  protected abstract void kiterjeszt( Csucs csucs );

  @Override
  public String toString()
  {
    return "Kereses keresograffal kereso algoritmussal.\n" + jellemzok();
  }
}
