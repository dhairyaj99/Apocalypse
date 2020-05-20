package Assign1_2P05;

public class Plinker extends Survivor {
	
	public Plinker(String name) {
		this.name = name;
	}

	@Override
	public String act() { //attack logic for Plinker
		for(int i=0;i<3;i++) {
			int r = (int) (Math.random()*Horde.boo.length);
			Horde.boo[r].deLimb(1);
		}
		
		return this.name + " has attacked 3 times";
	}

	@Override
	public String getRole() {

		return "Plinker";
	}

}
