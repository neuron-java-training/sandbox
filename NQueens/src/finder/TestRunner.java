package finder;

import allapotter.Allapot;
import kereso.Csucs;
import kereso.Kereso;
import kereso.backtrack.BacktrackKereso;
import kereso.keresografos.szisztematikus.SzelessegiKereso;
import kiralynok.State;

public class TestRunner {
	
	public static final int N = 4;

	public static void main(String[] args){
		 Allapot kezdo = new State();
		 Kereso k = new BacktrackKereso(kezdo, BacktrackKereso.MEGOLDAS_ALLAPOT | BacktrackKereso.OSSZES_MEGOLDAS);
    // 	 Kereso k = new SzelessegiKereso( kezdo, SzelessegiKereso.MEGOLDAS_ALLAPOT | SzelessegiKereso.OSSZES_MEGOLDAS );
//       Kereso k = new MelysegiKereso(kezdo, MelysegiKereso.MEGOLDAS_ALLAPOT | MelysegiKereso.OSSZES_MEGOLDAS);
       k.keres();
       for ( Csucs cs : k.getTerminalisok() ) {
           System.out.println( "Egy megoldas" );
           k.kiirMegoldas( cs );
       }

       System.out.println( "Megoldasok szama: " + k.getTerminalisok().size() );
	}
}
