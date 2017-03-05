package drmeepster.bable.potion;

import static drmeepster.drcorester.util.Util.register;

public class BablePotions{ 
	
	public static PotionNoMove noMove;
	
	public static void init(){
		noMove = register(new PotionNoMove());
	}
}