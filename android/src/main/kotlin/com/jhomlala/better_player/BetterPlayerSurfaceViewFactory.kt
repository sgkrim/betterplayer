package com.jhomlala.better_player

import android.content.Context
import android.util.LongSparseArray
import com.google.android.exoplayer2.ui.StyledPlayerView
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

/** Фабрика, яка віддає SurfaceView і бере ExoPlayer з LongSparseArray<BetterPlayer>. */
class BetterPlayerSurfaceViewFactory(
    private val players: LongSparseArray<BetterPlayer>
) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {

    override fun create(
        context: Context,
        viewId: Int,
        args: Any?
    ): PlatformView {
        val betterPlayer = players[viewId.toLong()]
            ?: error("BetterPlayer with id=$viewId not found")
        return BetterPlayerSurfaceView(context, betterPlayer.getExoPlayer()!!)
    }
}
