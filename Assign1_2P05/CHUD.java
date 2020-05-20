package Assign1_2P05;

public class CHUD implements Undead{
	
	public int distance=4; //Starting distance of undead
	public int limbs=4; //Starting limb count for undead
	public boolean isHungry = true; //Hunger boolean for undead

	@Override
	//returns distance
	public int getDistance() {
		return distance;
	}

	@Override
	//attack logic for CHUD
	public String chomp(Survivor victim) {
		victim.injure(1);
		return "The Hero "+ victim.getName() + " was attacked";
	}

	@Override
	public String advance() {
		distance--;
		return "ughhhhhhhhhhh";
	}

	@Override
	//returns limb count
	public int getLimbs() {
		return limbs;
	}

	@Override
	//damage logic for undead
	public void deLimb(int force) {
		limbs-=force;
	}

	@Override
	//returns hunger state for undead
	public boolean getHungry() {
		
		return isHungry;
	}

	@Override
	public String getLabel() {
		
		return "CHUD";
	}

	@Override
	public void setHunger(Boolean hunger) {
		isHungry = hunger;
	}

}
