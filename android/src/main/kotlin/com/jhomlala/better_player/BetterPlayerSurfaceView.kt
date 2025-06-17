package com.jhomlala.better_player

import android.content.Context
import android.view.View
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.StyledPlayerView
import io.flutter.plugin.platform.PlatformView

class BetterPlayerSurfaceView(
    context: Context,
    player: ExoPlayer
) : PlatformView {
    
    init {
        player?.clearVideoSurface()
    }
    private val playerView = StyledPlayerView(context).apply {
        // SurfaceView використовується за замовчуванням → setUseTextureView() не потрібен
        resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
        this.player = player
    }

    override fun getView(): View = playerView
    override fun dispose() {}
}
