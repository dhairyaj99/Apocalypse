package Assign1_2P05;

public class Sniper extends Survivor{

	public Sniper(String name) {
		this.name = name;
	}
	
	@Override
	public String act() { //attack logic for Sniper
		
		int r = (int) Math.random()*Horde.boo.length;
		
		Horde.boo[r].deLimb(Horde.boo[r].getLimbs());
		
		return this.name + " has attacked";
	}

	@Override
	public String getRole() {
		
		return "Sniper";
	}

}
