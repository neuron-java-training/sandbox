package hu.unideb.inf.ai2011.problems.kennedy;

import hu.unideb.inf.ai2011.State;

public class KennedyState implements State {
	
	protected Object[][] h = new Object[6][6];

	@Override
	public boolean isGoal() {
		return h[5][5] != null;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for ( int i = 1; i <= 5; i++ ) {
			for ( int j = 1; j <= 5; j++ ) {
				StringBuffer name = 
					new StringBuffer(h[i][j] == null ? "?" : h[i][j].toString());
				while ( name.length() < 14 )
					name.append(" ");
				sb.append( name ).append("\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
