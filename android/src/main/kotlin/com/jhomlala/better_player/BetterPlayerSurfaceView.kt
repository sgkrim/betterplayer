package com.jhomlala.better_player

import android.content.Context
import android.view.View
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.StyledPlayerView
import io.flutter.plugin.platform.PlatformView

/** PlatformView‑обгортка для SurfaceView‑рендеру. */
class BetterPlayerSurfaceView(
    context: Context,
    private val player: ExoPlayer
) : PlatformView {

    private val playerView: StyledPlayerView = StyledPlayerView(context).apply {
        // <-- ГОЛОВНЕ: апаратний SurfaceView
        setUseTextureView(false)
        resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
        this.player = player
    }

    override fun getView(): View = playerView

    override fun dispose() {
        // Нічого: ExoPlayer житиме далі в SparseArray
    }
}
