package com.example.util;

import com.example.nimei.R;

import android.content.Context;
import android.media.MediaPlayer;

public class Common {
	public static MediaPlayer mediaPlayer1;

	public static SoundPlay soundPlay;

	public static void loadSound(Context context){
		mediaPlayer1 = MediaPlayer.create(context, R.raw.bg1);
		
	}
	
	public static void initSound(Context context){
		soundPlay = new SoundPlay();
		soundPlay.initSound(context);
		soundPlay.loadSfx(context, R.raw.bg1, 0x1);
	}
}
