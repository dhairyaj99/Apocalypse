package Assign1_2P05;

public class Deadite implements Undead{
	
	public int distance=4;
	public int limbs=4;
	public boolean isHungry = true;

	@Override
	public int getDistance() {
		return distance;
	}

	@Override
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
	public int getLimbs() {
		return limbs;
	}

	@Override
	public void deLimb(int force) {
		limbs-=force;
	}

	@Override
	public boolean getHungry() {
		
		return isHungry;
	}

	@Override
	public String getLabel() {
		
		return "Deadite";
	}

	@Override
	public void setHunger(Boolean hunger) {
		isHungry = hunger;
	}
	
}
