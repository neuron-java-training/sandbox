package main;

import java.util.LinkedList;
import java.util.List;

import allapotter.Allapot;
import kereso.Kereso;
import kereso.backtrack.BacktrackKereso;
import kereso.keresografos.szisztematikus.MelysegiKereso;
import kereso.keresografos.szisztematikus.SzelessegiKereso;
import kiralynok.State;

public class Finder {
	
	public static final int N = 8;

	public static void main(String[] args){
		 Allapot kezdo = new State();
		 List<Kereso> keresok = new LinkedList<>();
		 keresok.add( new BacktrackKereso(kezdo, Kereso.MEGOLDAS_ALLAPOT | Kereso.OSSZES_MEGOLDAS));
     	 keresok.add( new SzelessegiKereso( kezdo, Kereso.MEGOLDAS_ALLAPOT | Kereso.OSSZES_MEGOLDAS ));
     	 keresok.add( new MelysegiKereso(kezdo, Kereso.MEGOLDAS_ALLAPOT | Kereso.OSSZES_MEGOLDAS));
     	 for(Kereso k : keresok){
     		 k.keres();
     		 k.eredmenyKiiras();
     	 }
	}
}
