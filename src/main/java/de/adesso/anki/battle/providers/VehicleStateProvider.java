package de.adesso.anki.battle.providers;

import com.states.*;
import de.adesso.anki.battle.util.Position;
import de.adesso.anki.battle.world.Body;
import de.adesso.anki.battle.world.World;
import de.adesso.anki.battle.world.bodies.Vehicle;
import de.adesso.anki.battle.world.bodies.roadpieces.Roadpiece;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class VehicleStateProvider {
	
	
	public VehicleStateProvider() {

	}
	
	public List<GameState> getRoadFacts(  Vehicle vehicle ){
		ArrayList<GameState> facts = new ArrayList<>();
		if (vehicle.getCurrentRoadpiece() == null)
			return facts;

		Roadpiece nextPiece = vehicle.getCurrentRoadpiece().getNext();

		if (nextPiece.isRightCurved()){
	    	RightCurveAhead rCurve = new RightCurveAhead(150); 
	     	facts.add(rCurve);
		}
		if (nextPiece.isLeftCurved()) {
			LeftCurveAhead lCurve = new LeftCurveAhead(150) ; 
			facts.add(lCurve); 
		}
		if (nextPiece.isStraight()) {
			StraightPieceAhead straight = new StraightPieceAhead();
			facts.add(straight);
		}
		return facts;
	}


	public List<GameState> getInventoryFacts( Vehicle vehicle )
	{
		ArrayList<GameState> facts = new ArrayList<>();
		if (vehicle.isRocketReady()){
	    	InventoryRocket rocketFact = new InventoryRocket();
	    	facts.add(rocketFact); 
		}
		if (vehicle.isMineReady()) {
			InventoryMine mineFact = new InventoryMine() ; 
			facts.add(mineFact); 
		}
		if (vehicle.isShieldReady()) {
			InventoryShield shieldFact = new InventoryShield() ; 
			facts.add(shieldFact); 
		}
		if (vehicle.isReflectorReady()) {
			InventoryReflector reflectorFact = new InventoryReflector() ; 
			facts.add(reflectorFact); 
		}

		return facts;
	}

	
	public List<GameState> getObstacleFacts(Vehicle vehicle ){
		ArrayList<GameState> facts = new ArrayList<>();	
		World world = vehicle.getWorld();
		for (Body body : world.getBodies()){
			if (vehicle == body) {
				continue;
			}
			//generating  facts for vehicle 
			//body all other in the current world
			String obstacleType = body.getClass().getSimpleName() ;
			Position position1 = vehicle.getPosition();
			Position position2 = body.getPosition();
			double distance = position1.distance(position2);
			double angle1 = position1.angle();
			double angle2 = position2.angle();
			String direction = ""; 
			double dummyValue = 10.0;
			
			//direction ? 
			ObjectInFront test1 = new ObjectInFront(distance, obstacleType);
			ObjectBehind test2 = new ObjectBehind(distance, obstacleType);
			facts.add(test1);
			facts.add(test2);
/*			if (distance < dummyValue) {
				switch (obstacleType) {
					case ("Rocket"):
						
						break;
				}
				if ( obstacleType.equals( "Rocket")) {
				RocketBehind hm = new RocketBehind();
				//directon
				}
				if (obstacleType.equals( "Mine")) {
					MineInFront mineFront = new MineInFront();
				}
				if (obstacleType.equals( "Vehicle")) {
					VehicleInFront vehicleFront = new VehicleInFront();
				}
			}*/

		}
		return facts;
	}
		
		
		
		//if vehicle.nextRoadPiece.containsRocket()
/*		if (nextPiece) {
			int meters = 100;
			String type = "";
			RocketInFront rocketInFront  = new RocketInFront(100, type);
			facts.add(rocketInFront); 
		}
		if (prevPiece) {
			int meters = 100;
			String type = "";
			RocketBehind obstacleBehind  = new RocketBehind(100, type);
			facts.add(obstacleBehind); 
		}
		
		if (nextPiece) {
			int meters = 100;
			String type = "";
			MineInFront mineInFront  = new MineInFront(100);
			facts.add(mineInFront); 
		}
		if (nextPiece.containsRocket()) {
			int meters = 100;
			String type = "";
			RocketInFront obstacleInFront  = new RocketInFront(100, type);
				    	facts.add(rocketFact); 
		}
		if (prevPiece) {
			int meters = 100;
			String type = "";
			RocketInFront obstacleInFront  = new RocketInFront(100, type);
			facts.add(); 
		}
		
		
*/


	
	private boolean objectInNeighbourhood(Vehicle vehicle, Body body2 , double neighbourhoodDistance){
		Position position1 = vehicle.getPosition();
		Position position2 = body2.getPosition();
		double distance = position1.distance(position2);
		double angle1 = position1.angle();
		double angle2  = position2.angle();
		if (distance  < neighbourhoodDistance) {
			
		}
		return false;
	}
	
	
	

}
