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
		//��������豸����������
		AudioManager mgr = (AudioManager) context.
				getSystemService(Context.AUDIO_SERVICE);
		streamVolume = mgr.getStreamVolume(AudioManager.STREAM_MUSIC);
	}
	
	/**
	 * ��������
	 * @param context
	 * @param raw ��Դ
	 * @param ID ָ��ID
	 */
	public void loadSfx(Context context, int raw, int ID){
		soundPoolMap.put(ID, soundPool.load(context, raw, 1));
	}
	
	/**
	 * ��������
	 * @param sound ����
	 * @param loop ѭ������
	 */
	public void play(int sound, int loop){
		soundPool.play(soundPoolMap.get(sound), streamVolume, streamVolume,
				1, loop, 1f);
	}

}
