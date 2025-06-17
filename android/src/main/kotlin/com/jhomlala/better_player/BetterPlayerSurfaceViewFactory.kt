package com.jhomlala.better_player

import android.content.Context
import android.util.SparseArray
import com.google.android.exoplayer2.ExoPlayer
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

/** Реєструє PlatformView і віддає йому існуючий ExoPlayer за id. */
class BetterPlayerSurfaceViewFactory(
    private val players: SparseArray<ExoPlayer>
) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {

    override fun create(
        context: Context,
        viewId: Int,
        args: Any?
    ): PlatformView {
        val player = players[viewId]
        requireNotNull(player) { "ExoPlayer with id=$viewId not found" }
        return BetterPlayerSurfaceView(context, player)
    }
}
