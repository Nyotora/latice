package latice.vue;

import java.io.File;
import java.net.MalformedURLException;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import latice.model.Tile;

public class TileFX extends ImageView {
	private Tile tileSource;
	private static String HOVER_EFFECT = "-fx-effect: dropshadow(three-pass-box, rgba(200,200,0,0.8), 15, 0.6, 0, 0);";
	private static String SHADOW_EFFECT = "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.4, 0, 0);";
	
	
	public TileFX(Tile tile) {
		this.tileSource = tile;
		initDragAndDrop();
		setTileEffects();
		setTileImage();
	}
	
	public void setTileImage() {
		String urlFichier;
		try {
			File fichier = new File(this.tileSource.getImagePath());
			urlFichier = fichier.toURI().toURL().toString();
			Image img = new Image(urlFichier, 62, 62, true, true);
			setImage(img);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}	
	
	public void initDragAndDrop() {
		setOnDragDetected(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent event) {
		    	if (!tileSource.isLocked()) {
			    	Dragboard dragboard = startDragAndDrop(TransferMode.MOVE);
			        setStyle(SHADOW_EFFECT);
			        
			        ClipboardContent content = new ClipboardContent();
			        content.putImage(getImage());
			        content.putString(tileSource.getShape().toString()+"_"+tileSource.getColor().toString());
			        dragboard.setContent(content);
			        event.consume();
			        
			        
			        if (tileSource.getParentBox()!=null) {
			        	tileSource.exitBox();
			    	}
		    	}
		    }
		});
		
		setOnDragDone(new EventHandler<DragEvent>() {
		    @Override
		    public void handle(DragEvent event) {
		    	if (event.getTransferMode() == TransferMode.MOVE) {
			    	if (tileSource.getParentRack()!=null) {
			    		tileSource.exitRack();
			    	}
		    	} else  if (tileSource.getParentBox()!=null) {
		    		tileSource.resetPosition();
		    		tileSource.resetPositionFX();
		    	}
		        event.consume();
		    }
		});
	}
	
	
	private void setTileEffects() {
		this.setStyle(SHADOW_EFFECT);
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent t) {
		    	if (tileSource.getParentRack() != null) {
			        setStyle(HOVER_EFFECT);
		    	}
		    }
		});
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent t) {
		        setStyle(SHADOW_EFFECT);
		    }
		});
	}
}
