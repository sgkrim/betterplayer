package com.jhomlala.better_player

import android.content.Context
import android.view.View
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.StyledPlayerView
import io.flutter.plugin.platform.PlatformView

class BetterPlayerSurfaceView(
  context: Context,
  private val player: ExoPlayer
) : PlatformView {

  private val playerView: StyledPlayerView = StyledPlayerView(context).apply {
      setUseTextureView(false)           // <-- головне!
      this.player = player
      resizeMode = StyledPlayerView.RESIZE_MODE_FIT
  }

  override fun getView(): View = playerView
  override fun dispose() { /* нічого */ }
