package server;

public class Main {
public static void main(String[] args){
		
		Server s = new Server();
		BusinessRules bs = new BusinessRules(); //bs.checkMap(mapHalf);
		MapConfiguration m = new MapConfiguration(s.arrayToString(s.generateMapHalf()), s.arrayToString(s.generateMapHalf()));
		
		m.printMap();

	}
}
