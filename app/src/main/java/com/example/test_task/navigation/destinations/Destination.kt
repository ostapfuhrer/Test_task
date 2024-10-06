package com.example.test_task.navigation.destinations

/**
 * Encapsulates destination’s route information.
 *
 * @param route the unique route to the destination. To be used when navigating.
 * @param params the list of mandatory parameter names to add to the route to get the full route.
 * @property fullRoute the full route to the destination, including possible parameters. To be used when providing destinations inside NavGraph.
 */
sealed class Destination(val route: String, vararg params: String) {
    val fullRoute: String = if (params.isEmpty()) route else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{$it}") }
        builder.toString()
    }

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    object SplashScreen : Destination("splash_screen")
    object MainScreen : Destination("main_screen")
    object VideoPlayerScreen : Destination("video_player_screen/{videoId}", "videoId")
}