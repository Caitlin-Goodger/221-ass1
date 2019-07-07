// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.moves;

import java.util.Arrays;

import swen221.picturepuzzle.model.Board;
import swen221.picturepuzzle.model.Cell;
import swen221.picturepuzzle.model.Location;
import swen221.picturepuzzle.model.Operation;

/**
 * Responsible for rotating the image data in a given cell in a clockwise
 * direction.
 *
 * @author betty
 *
 */
public class Rotation implements Operation {
	private final Location location;
	private final int steps;

	/**
	 * Construction a rotation for the cell at a given location, rotating a given
	 * number of steps.
	 *
	 * @param loc
	 * @param steps
	 */
	public Rotation(Location loc, int steps) {
		this.location = loc;
		this.steps = steps;
	}
	/**
	 * Apply rotation to the selected cell.
	 *
	 * @param cell
	 *            The cell on which the rotation is applied.
	 *
	 * @param steps
	 *            Number of steps to rotate in clockwise direction.
	 */
	@Override
	public void apply(Board board) {
		// FIXME: need to do something here!
		//Do for however many steps there are
		for(int i =0;i<steps;i++) {
			Cell c = board.getCellAt(location);
			if(c == null) { //Check that cell isn't blank
				return;
			}
			int[] image = c.getImage();
			int width = c.getWidth();
			int[][] image2D = new int[width][width];
			int count = 0;
			//Put all the values into a 2D array of the rows and cols
			for(int j =0;j<width;j++) {
				for(int k =0;k<width;k++) {
					image2D[j][k] = image[count];
					count++;
				}
			}
			//Rotate the cell 90 degrees clockwise
			int[][] rotated = new int[width][width];
			for(int l =0;l<width;l++) {
				for(int m =0;m<width;m++) {
					rotated[m][width-1-l] = image2D[l][m];
				}
			}
			count = 0;
			int[] temp = new int[image.length];
			//Put 2D array back into the 1D image array
			for(int n = 0;n<width;n++) {
				for(int o =0;o<width;o++) {
					image[count] = rotated[n][o];
					count++;
				}
			}
			
		}
				
	}
}
