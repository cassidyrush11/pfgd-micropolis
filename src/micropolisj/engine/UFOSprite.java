package micropolisj.engine;

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

		//int zz = city.PRNG.nextInt(CDx.length);
		//x += CDx[zz];
		//y += CDy[zz];

		if (!city.testBounds(x/16, y/16)) {
			// out of bounds
			this.frame = 0;
			return;
		}
		
		if ((city.cityTime % 4) == 0) {
			this.frame = 0;
			return;
		}

		//if (this.count == 0 && city.PRNG.nextInt(501) == 0) {
			// early termination
			//this.frame = 0;
			//return;
		//}

		destroyTile(x/16, y/16);
	}
}