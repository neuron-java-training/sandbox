package kereso;

import java.util.LinkedList;
import java.util.List;

import allapotter.Allapot;

public abstract class Kereso
{
  public static final int OSSZES_MEGOLDAS = 1;
  public static final int MEGOLDAS_ALLAPOT = 2;
  protected static long lepesszam = 0;
  protected long begin, end, runtime;

  protected boolean osszesMegoldas;
  protected boolean megoldasAllapot;
  protected List<Csucs> terminalisok;

  protected Kereso()
  {
    osszesMegoldas = false;
    megoldasAllapot = false;
    terminalisok = new LinkedList<Csucs>();
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
    if ( megoldasAllapot ){
      System.out.println( cs.getAllapot() );
    }
    else if ( cs != null )
    {
      kiirMegoldas( cs.getSzulo() );
      System.out.println( cs );
    }
  }
  
  public void eredmenyKiiras(){
	System.out.println(this);
	System.out.println( "Megoldasok szama: " + getTerminalisok().size() );
	System.out.println("Futásidõ: " + runtime/100_000);
	System.out.println("Létrehozott állapotok: " + Allapot.getAllapotok());
	System.out.println("Megtett ciklusok: " + lepesszam);
	System.out.println();
  }
  
  public abstract void keres();
}
