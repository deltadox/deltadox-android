package com.frogobox.sdk.util

import android.content.Context
import android.media.MediaPlayer

/*
 * Created by faisalamir on 29/08/21
 * FrogoSDK
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
class FrogoMusic(
    private val context: Context,
    private val musicFile: Int
) : IFrogoMusic {

    companion object {
        val TAG: String = FrogoMusic::class.java.simpleName
    }

    private val musicPlayer: MediaPlayer = MediaPlayer.create(context, musicFile)

    override fun getMusicPlayer(): MediaPlayer {
        return musicPlayer
    }

    override fun playMusic(isLooping: Boolean) {
        musicPlayer.apply {
            this.isLooping = isLooping
        }.start()
    }

    override fun playMusic() {
        musicPlayer.start()
    }

    override fun stopMusic() {
        musicPlayer.stop()
        musicPlayer.release()
    }

    override fun pauseMusic() {
        musicPlayer.pause()
    }

}