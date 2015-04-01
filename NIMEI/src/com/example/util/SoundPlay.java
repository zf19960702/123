package com.example.util;

import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundPlay {
	
	int streamVolume;
	
	private SoundPool soundPool;
	
	private HashMap<Integer, Integer> soundPoolMap;
	
	public void initSound(Context context) {
		soundPool = new SoundPool(25, AudioManager.STREAM_MUSIC, 100);
		soundPoolMap = new HashMap<Integer, Integer>();
		//获得声音设备和声音音量
		AudioManager mgr = (AudioManager) context.
				getSystemService(Context.AUDIO_SERVICE);
		streamVolume = mgr.getStreamVolume(AudioManager.STREAM_MUSIC);
	}
	
	/**
	 * 加载声音
	 * @param context
	 * @param raw 音源
	 * @param ID 指定ID
	 */
	public void loadSfx(Context context, int raw, int ID){
		soundPoolMap.put(ID, soundPool.load(context, raw, 1));
	}
	
	/**
	 * 播放声音
	 * @param sound 声音
	 * @param loop 循环次数
	 */
	public void play(int sound, int loop){
		soundPool.play(soundPoolMap.get(sound), streamVolume, streamVolume,
				1, loop, 1f);
	}

}
