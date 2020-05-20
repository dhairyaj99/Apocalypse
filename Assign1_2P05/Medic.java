package Assign1_2P05;

public class Medic extends Survivor{
	
	public Medic(String name) {
		this.name = name;
	}
	
	@Override
	public String act() { //attack logic for Medic
		for(Survivor s:Apocalypse.heroes) {
			int h = s.getHP();
			s.injure(-1*(5-h));
		}
		
		return this.name + " has healed the whole party";
	}

	@Override
	public String getRole() {
		return "Medic";
	}
	
	

}
