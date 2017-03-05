package drmeepster.bable.block;

import static drmeepster.drcorester.util.Util.register;

public class BableBlocks {
	
	public static AnvilSmith anvilSmith;
	
	public static void init(){
		anvilSmith = register(new AnvilSmith());
	}
}
