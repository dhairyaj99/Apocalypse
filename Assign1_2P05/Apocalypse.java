package Assign1_2P05;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Main class of the package.
 * This is only a minimally functional skeelton. It is NOT complete!
 * 
 * @author (Dhairya Jaiswal| dj17vi | 6292064)
 * 
 * @see Survivor
 * @see Undead
 * @see Horde
 */
public class Apocalypse {
	
	static LinkedList<Survivor> heroes;
	
	/**
	 * Constructor
	 */
	public Apocalypse() {
		Scanner s = new Scanner(System.in);
		heroes = new LinkedList<>();
		
		System.out.println("How many total zombies would you like your heroes to fight?: ");
		int total = s.nextInt();
		
		System.out.println("How many zombies would you like on the field at once?: ");
		int breadth = s.nextInt();
		
		Horde.populate(total, breadth); //populates the horde with the input from the user
		
		
		//User decides which heroes they want
		for(int i=0;i<4;i++) {
			System.out.println("What is the type of your hero? (p for plinker, s for sniper, f for flamer, m for medic): "); 
			String c = s.next();
			System.out.println("What would you like to name this hero?:");
			String n = s.next();
			
			switch(c){
			case "p":
				heroes.add(new Plinker(n));
				break;
			case "s":
				heroes.add(new Sniper(n));
				break;
			case "f":
				heroes.add(new Flamer(n));
				break;
			case "m":
				heroes.add(new Medic(n));
				break;
			}
		}
		
		displayField(heroes);
		System.out.println();
		while (Horde.boo.length>0 && heroes.size()>0) {
			iterate(heroes);
		}
		//Victory logic
		if(Horde.boo.length==0)
			System.out.println("Victory!");
		else if(heroes.size()==0)
			System.out.println("Heroes have fallen!");
		
		displayField(heroes);
	}
	
	/**
	 * You really should break out a single iteration/cycle of the
	 * simulation, so you can separate the work.
	 * 
	 * We don't need to bother with the Horde, because that only uses
	 * static's. However, we do need to hang onto our list of brave
	 * heroes somehow.
	 * 
	 * @param heroes Said 'brave heroes'
	 */
	private void iterate(LinkedList<Survivor> heroes) {
		//This is just a *very* basic skeleton
		
		//for (Survivor s:heroes) System.out.println(s.act()); //Heroes do their thing
		System.out.println(heroes.get(0).act());
		
		for(int i=0;i<Horde.boo.length;i++) {
			if(Horde.boo[i].getLimbs()==0) {
				System.out.println(Horde.boo[i].getLabel() + " has died");
				Horde.replenish(i);
			}
		}
		
		for (Undead u:Horde.boo) System.out.println(u.advance()); //Undead advance
		
		for (Undead u:Horde.boo) { //End the turn with the zombies chowing down
			if (heroes.size()>0) { //You might want something more elegant for this
				//Hunger logic
				if (u.getDistance()<=0) {
					if(u.getHungry()==true && (u.getLabel()=="Deadite" || u.getLabel()=="Trioxin")) {
						System.out.println(u.chomp(heroes.get(0)));
						u.setHunger(false);
					}
					else if(u.getHungry()==false && (u.getLabel()=="Deadite" || u.getLabel()=="Trioxin")) {
						u.setHunger(true);
					}
					else {
						System.out.println(u.chomp(heroes.get(0)));
						}
				}
				if (heroes.get(0).getHP()<=0) {
					heroes.remove(0);
				}
			}
		}
		
		//Rotating, so everyone gets a chance to be eaten!
		if (heroes.size()>0) {
			Survivor s=heroes.removeFirst();
			heroes.addLast(s);
		}
	}
	
	/**
	 * You can probably do better than this.
	 * Still, the requirements are:
	 *  1. Draw the undead currently on the field
	 *  2. Draw the survivors, including their sequence
	 *  ?. Profit?
	 *
	 * @param heroes Our do-gooders
	 */
	private void displayField(LinkedList<Survivor> heroes) {
		if (Horde.boo.length==0) {
			for (Survivor hero:heroes) System.out.print(hero);
			System.out.println();
		}
		for (int i=0;i<Horde.boo.length;i++) {
			//for (int j=0;j<field[i].length;j++) System.out.print(Undead.render(field[i][j]));
			System.out.print(Undead.render(Horde.boo[i]));
			System.out.print('|');
			if (i==Horde.boo.length/2) for (Survivor hero:heroes) System.out.print(hero);
			System.out.println();
			
		}
	}
	
	
	
	public static void main(String[] args) {new Apocalypse();}
}
