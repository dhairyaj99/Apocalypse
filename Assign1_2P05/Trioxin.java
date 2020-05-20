package Assign1_2P05;

public class Trioxin implements Undead{
	
	public int distance=4;
	public int limbs=4;
	public boolean isHungry = true;

	@Override
	public int getDistance() {
		return distance;
	}

	@Override
	public String chomp(Survivor victim) {
		victim.injure(2);
		return "The Hero "+ victim.getName() + " was attacked";
	}

	@Override
	public String advance() {
		distance-=2;
		return "ughhhhhhhhhhh";
	}
	
	@Override
	public String speak() {
		return "Send more paramedics";
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
		
		return "Trioxin";
	}

	@Override
	public void setHunger(Boolean hunger) {
		isHungry = hunger;
	}

}
