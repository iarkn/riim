package riim.gfx

import arc.*
import arc.graphics.gl.*
import arc.scene.ui.layout.*
import arc.util.*

import mindustry.*

object Shaders {
    lateinit var univ: UnivShader

    fun load() {
        univ = UnivShader("univ")
    }

    fun dispose() {
        univ.dispose()
    }

    class UnivShader(name: String) : Shader(
        getFi("$name.vert"), getFi("$name.frag"),
    ) {
        override fun apply() {
            setUniformf("u_time", Time.time / Scl.scl())
        }
    }

    private fun getFi(path: String) = Vars.tree.get("shaders/$path")
}
