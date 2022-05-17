package riim.gfx

import arc.*
import arc.graphics.gl.*
import arc.scene.ui.layout.*
import arc.util.*

import kotlin.math.sin

import mindustry.*

object Shaders {
    lateinit var univ: UnivShader

    fun load() {
        univ = UnivShader("univ")
    }

    class UnivShader(name: String) : Shader(
        getFi("$name.vert"), getFi("$name.frag"),
    ) {
        // var radius = 0f

        override fun apply() {
            // setUniformf("u_time", Time.time)
            val time = Time.time * 0.001f
            setUniformf(
                "u_color",
                (sin(time) + 1f) / 2f,
                (sin(time * 4f) + 1f) / 2f,
                (sin(time * 8f) + 1f) / 2f,
            )
        }
    }

    private fun getFi(path: String) = Vars.tree.get("shaders/$path")
}
