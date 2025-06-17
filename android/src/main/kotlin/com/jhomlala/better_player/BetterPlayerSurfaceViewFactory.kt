class BetterPlayerSurfaceViewFactory(
  private val playerMap: SparseArray<ExoPlayer>
) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {

  override fun create(context: Context, viewId: Int, args: Any?): PlatformView {
      val player = playerMap[viewId]     // дістаємо ExoPlayer із мапи
      return BetterPlayerSurfaceView(context, player)
  }
}
