package drmeepster.bable.util;

import drmeepster.bable.item.BableItems;
import net.minecraft.init.Blocks;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class BablesAchieve {
	public static Achievement achieveSpinKill;
	public static Achievement achieveMeepWrath;
	public static Achievement achieveBableCraft;
	public static Achievement achieveStupidCraft;
	public static Achievement achieveDerpWitch;
	public static Achievement[] list = new Achievement[5];
	
	public static AchievementPage bablePage;
	
	public static void init(){
		achieveBableCraft = new Achievement("achievement.bableCraft", "bableCraft", 0, 0, BableItems.trinketBable, null);
		achieveBableCraft.registerStat();
		achieveSpinKill = new Achievement("achievement.spinKill", "spinKill", 2, 1, BableItems.iconMagicSpin, achieveBableCraft);
		achieveSpinKill.registerStat();
		achieveMeepWrath = new Achievement("achievement.meepWrath", "meepWrath", 0, -2, BableItems.iconPureRage, null).setSpecial();
		achieveMeepWrath.registerStat();
		achieveStupidCraft = new Achievement("achievement.stupidCraft", "stupidCraft", -2, 1, BableItems.trinketStupid, achieveBableCraft);
		achieveStupidCraft.registerStat();
		achieveDerpWitch = new Achievement("achievement.derpWitch", "derpWitch", -2, -1, BableItems.iconDerpWitch, achieveStupidCraft);
		achieveDerpWitch.registerStat();
		
		list[0] = achieveSpinKill;
		list[1] = achieveMeepWrath;
		list[2] = achieveBableCraft;
		list[3] = achieveStupidCraft;
		list[4] = achieveDerpWitch;
		
		bablePage = new AchievementPage("Bable Impressive Page", list);
		AchievementPage.registerAchievementPage(bablePage);
	}
}
