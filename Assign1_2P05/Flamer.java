package Assign1_2P05;

public class Flamer extends Survivor{

	public Flamer(String name) {
		this.name = name;
	}
	
	@Override
	public String act() { //attack logic for Flamer
		
		for(Undead u:Horde.boo) {
			int d = u.getDistance();
			if(d==0) {
				u.deLimb(u.getLimbs());
			}
		}
		
		return this.name + " has attacked";
	}

	@Override
	public String getRole() {
		return "Flamer";
	}

}
