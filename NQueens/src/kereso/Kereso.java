package kereso;

import java.util.List;
import java.util.ArrayList;

public abstract class Kereso
{
  public static final int OSSZES_MEGOLDAS = 1;
  public static final int MEGOLDAS_ALLAPOT = 2;

  protected boolean osszesMegoldas;
  protected boolean megoldasAllapot;
  protected List<Csucs> terminalisok;

  protected Kereso()
  {
    osszesMegoldas = false;
    megoldasAllapot = false;
    terminalisok = new ArrayList<Csucs>();
  }
  
  protected Kereso( int jellemzok )
  {
    this();
    osszesMegoldas = ( jellemzok & OSSZES_MEGOLDAS ) != 0;
    megoldasAllapot = ( jellemzok & MEGOLDAS_ALLAPOT ) != 0;
  }
  
  public List<Csucs> getTerminalisok()
  {
    return terminalisok;
  }
  
  public String jellemzok()
  {
    String s = new String();
    if ( osszesMegoldas )
      s += "Az osszes megoldast keressuk.\n";
    else
      s += "Az elso megoldast keressuk.\n";
    if ( megoldasAllapot )
      s += "Megoldasnak a celallapotot tekintjuk.\n";
    else
      s += "Megoldasnak a celallapotba vezeto operatorsorozatot tekintjuk.\n";
    return s;
  }
  
  public void kiirMegoldas( Csucs cs )
  {
    if ( megoldasAllapot )
      System.out.println( cs.getAllapot() );
    else if ( cs != null )
    {
      kiirMegoldas( cs.getSzulo() );
      System.out.println( cs );
    }
  }
  
  public abstract void keres();
}
