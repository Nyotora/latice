package latice.model.players;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import latice.model.tiles.BoardTile;
import latice.model.tiles.Color;
import latice.model.tiles.Shape;
import latice.model.tiles.SpecialTile;
import latice.model.tiles.Tile;
import latice.model.tiles.TypeOfSpecialTile;


public class Stack implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Tile> tiles;
	private static final Integer TOTAL_NUMBER_OF_SPECIAL_TILES = 12;
	private static final Integer TOTAL_NUMBER_OF_TILES_PER_PLAYER = 42;
	
	public Stack() {
		this.tiles = new ArrayList<>();
	}
	
	public void initialize(Player j1, Player j2) {
		
		for (Color color : Color.values()) {
			for (Shape shape : Shape.values()) {
				for (int i = 0; i < 2; i++) {
					this.addTile(new BoardTile(shape, color));
				}
			}
		}
		
		for (int i = 0; i < TOTAL_NUMBER_OF_SPECIAL_TILES/2; i++) {
			this.addTile(new SpecialTile(TypeOfSpecialTile.THUNDER));
		}
		
		for (int i = 0; i < TOTAL_NUMBER_OF_SPECIAL_TILES/2; i++) {
			this.addTile(new SpecialTile(TypeOfSpecialTile.WIND));
		}
		
		Collections.shuffle(tiles);
		for (int j = 0; j < TOTAL_NUMBER_OF_TILES_PER_PLAYER; j++) {
			j1.getStack().addTile(tiles.get(0));
			this.removeTile();
			j2.getStack().addTile(tiles.get(0));
			this.removeTile();
		}
	}

	public void addTile(Tile tile) {
		this.tiles.add(tile);
	}
	
	public void removeTile() {
		tiles.remove(0);
	}
	
	public void showTiles() {
		for (Tile tile : tiles) {
			System.out.println(tile.toString());
		}
	}
	
	public Integer stackLength() {
		return tiles.size();
	}

	public Tile getFirstTile() {
		return tiles.get(0);
	}

	public List<Tile> content() {
		return tiles;
	}

	public List<BoardTile> getBoardTiles() {
		List<BoardTile> boardtiles = new ArrayList<>();
		for (Tile tile : tiles) {
			if (tile.getClass().equals(BoardTile.class)) {
				boardtiles.add((BoardTile)tile);
			}
		}
		return boardtiles;
	}
	
	
	
	
}
