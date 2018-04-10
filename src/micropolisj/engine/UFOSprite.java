package micropolisj.engine;

//import static micropolisj.engine.TileConstants.*;

/**
 * Implements a UFO (one of the Micropolis disasters).
 */
public class UFOSprite extends Sprite
{
	static int [] CDx = {  2,  3,  2,  0, -2, -3 };
	static int [] CDy = { -2,  0,  2,  3,  2,  0 };

	boolean flag;
	int count;

	public UFOSprite(Micropolis engine, int xpos, int ypos)
	{
		super(engine, SpriteKind.UFO);
		this.x = xpos * 16 + 8;
		this.y = ypos * 16 + 8;
		this.width = 48;
		this.height = 48;
		this.offx = -24;
		this.offy = -40;

		this.frame = 1;
		this.count = 200;
	}
	public void moveImpl()
	{
		int z = this.frame;

		if (z == 2) {
			//cycle animation

			if (this.flag)
				z = 3;
			else
				z = 1;
		}
		else {
			this.flag = (z == 1);
			z = 2;
		}

		if (this.count > 0) {
			this.count--;
		}

		this.frame = z;


		if (!city.testBounds(x/16, y/16)) {
			// out of bounds
			this.frame = 0;
			return;
		}
		
		if (city.cityTime % 4 == 0) {
			this.frame = 0;
			return;
		}

		makeRubble(x/16, y/16);
		
		//city.setTile(x, y, (char)(RUBBLE)); 
		//return;
	}
}