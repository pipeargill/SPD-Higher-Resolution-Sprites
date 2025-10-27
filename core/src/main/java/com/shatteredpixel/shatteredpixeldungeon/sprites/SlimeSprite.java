package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.ChampionEnemy;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.watabou.noosa.TextureFilm;

public class SlimeSprite extends MobSprite {

	public SlimeSprite() {
		super();

		texture( Assets.Sprites.SLIME );

		TextureFilm frames = new TextureFilm( texture, 14*16, 12*16 ); //Mod

		scale.set(0.0625f);  //Mod

		idle = new Animation( 3, true );
		idle.frames( frames, 0, 1, 1, 0 );

		run = new Animation( 10, true );
		run.frames( frames, 0, 2, 3, 3, 2, 0 );

		attack = new Animation( 15, false );
		attack.frames( frames, 2, 3, 4, 6, 5 );

		die = new Animation( 10, false );
		die.frames( frames, 0, 5, 6, 7 );

		play(idle);
	}

	@Override
	public int blood() {
		return 0xFF88CC44;
	}

	@Override
	public void link(com.shatteredpixel.shatteredpixeldungeon.actors.Char ch) {
		super.link(ch);

		// Now ch is set, so we can check if it's a Giant champion
		if (ch instanceof Mob) {
			Mob mob = (Mob) ch;
			if (mob.buff(ChampionEnemy.Giant.class) != null) {
				scale.set(0.125f); // 100% larger (0.0625 * 2)
			}
		}
	}
}