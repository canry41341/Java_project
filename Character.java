
import java.awt.Graphics;
import javax.swing.JComponent;

public abstract class Character implements GameStateDefault {

	private Game game;
	public static int Xcoordinate, Ycoordinate;


	protected boolean left_movable = true, right_movable = true, up_movable = true, down_movable = true;
	protected int pace;
	protected int[] ideal_up = new int[2];
	protected int[] ideal_down = new int[2];
	protected int[] ideal_left = new int[2];
	protected int[] ideal_right = new int[2];

	public Character(Game game, int Xcoordinate, int Ycoordinate) {
		this.game = game;
		this.Xcoordinate = Xcoordinate;
		this.Ycoordinate = Ycoordinate;
		this.pace = DEFAULT_PACE;
		ideal_up[0] = Xcoordinate;
		ideal_up[1] = Ycoordinate - 100;
		ideal_down[0] = Xcoordinate;
		ideal_down[1] = Ycoordinate + 100;
		ideal_left[0] = Xcoordinate - 100;
		ideal_left[1] = Ycoordinate;
		ideal_right[0] = Xcoordinate + 100;
		ideal_right[1] = Ycoordinate;
	}

	public abstract void render(Graphics g);

	public abstract void tick();

	public void movable() {

		this.up_movable = true;
		this.down_movable = true;
		this.left_movable = true;
		this.right_movable = true;

		// out border
		if (this.ideal_up[1] < DEFAULT_MIN_Y) {
			this.up_movable = false;
		}
		if (this.ideal_down[1] > DEFAULT_MAX_Y) {
			this.down_movable = false;
		}
		if (this.ideal_left[0] < DEFAULT_MIN_X) {
			this.left_movable = false;
		}
		if (this.ideal_right[0] > DEFAULT_MAX_X) {
			this.right_movable = false;
		}

		if (this.up_movable) {
			if (!Game.go[(this.ideal_up[0] - 400) / 100][(this.ideal_up[1]) / 100])
				this.up_movable = false;
		}
		if (this.down_movable) {
			if (!Game.go[(this.ideal_down[0] - 400) / 100][(this.ideal_down[1]) / 100])
				this.down_movable = false;
		}
		if (this.left_movable) {
			if (!Game.go[(this.ideal_left[0] - 400) / 100][(this.ideal_left[1]) / 100])
				this.left_movable = false;
		}
		if (this.right_movable) {
			if (!Game.go[(this.ideal_right[0] - 400) / 100][(this.ideal_right[1]) / 100])
				this.right_movable = false;
		}
	}

	public void setIdealLocation() {
		ideal_up[0] = this.Xcoordinate;
		ideal_up[1] = this.Ycoordinate - 100;
		ideal_down[0] = this.Xcoordinate;
		ideal_down[1] = this.Ycoordinate + 100;
		ideal_left[0] = this.Xcoordinate - 100;
		ideal_left[1] = this.Ycoordinate;
		ideal_right[0] = this.Xcoordinate + 100;
		ideal_right[1] = this.Ycoordinate;
		this.movable();
	}

}
