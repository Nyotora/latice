package latice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class GameBoard implements Serializable{
	
	private Map<Position, Box> gameboardTiles;
	private List<Tile> playingTiles;
	
	public GameBoard() {
		this.gameboardTiles = new HashMap<>();
		this.playingTiles = new ArrayList();
    }

    public List<Tile> getPlayingTiles() {
		return playingTiles;
	}

	public Map<Position, Box> tiles() {
        return this.gameboardTiles;
    }
    
    public void generateBox() {
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
	    		Position position = new Position(i, j);
	    		if ((i==0 && j==0)||(i==1 && j==1)||(i==2 && j==2)||(i==0 && j==8)||(i==1 && j==7)||(i==2 && j==6)   ||(i==8 && j==0)||(i==7 && j==1)||(i==6 && j==2)||(i==8 && j==8)||(i==7 && j==7)||(i==6 && j==6)   ||(i==0 && j==4)||(i==4 && j==0)||(i==4 && j==8)||(i==8 && j==4)) {
	    			this.gameboardTiles.put(position, new Box(BoxType.SUN,this,position));
	    		} else if ((i==4 && j==4)) {
	    			this.gameboardTiles.put(position, new Box(BoxType.MOON,this,position));
	    		} else {
	    			this.gameboardTiles.put(position, new Box(BoxType.NORMAL,this,position));
	    		}
    		}
    	}
    }
    
    
    //JAVAFX
    public GridPane generateGameBoard() {
    	GridPane board = new GridPane();

    	for (Map.Entry<Position, Box> entry : gameboardTiles.entrySet()) {
    		entry.getValue().setBoxImage();
    		board.add(entry.getValue().getBoxFX(), entry.getKey().column(), entry.getKey().row());
		}
		    	
    	
    	board.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(255,255,153,0.8), 15, 0.7, 0, 0);");
    	board.setPadding(new Insets(20,68,0,68));
    	return board;
    }
    
    public Box getBox(Position position) {
    	for (Map.Entry<Position, Box> entry : gameboardTiles.entrySet()) {
			if (entry.getKey().row()==position.row() && entry.getKey().column()==position.column()) {
				return entry.getValue();
			}
		}
    	
    	return null;
    }
    
	public void addPlayingTile(Tile newTile) {

		for (Tile tile : playingTiles) {
			tile.getTileFX().setLastTilePlayed(false);
		}
		this.playingTiles.add(newTile);
	}
	
	public void removePlayingTile() {
		this.playingTiles.remove(this.playingTiles.size()-1);
		if (this.playingTiles.size()>=1) {
			this.playingTiles.get(this.playingTiles.size()-1).getTileFX().setLastTilePlayed(true);
		}
	}
    
    public void lockPlayingTiles() {
    	for (Tile tile : playingTiles) {
			tile.setLocked(true);
		}
    	this.playingTiles.clear();
    	
    }
    
    public void resetPlayingTileEffect() {
    	for (Tile tile : playingTiles) {
			tile.getTileFX().setStyle(tile.getTileFX().SHADOW_EFFECT);
		}
    	
    }
    
}

