package riim.blocks.misc

import arc.graphics.g2d.*

import mindustry.gen.*
import mindustry.graphics.*
import mindustry.world.*

import riim.gfx.Shaders

class Universal(name: String) : Block(name) {
    val radius = 80f

    init {
        update = true
        solid = true
        sync = true
    }

    inner class UniversalBuild : Building() {
        override fun draw() {
            val z = Draw.z()

            Draw.draw(Layer.floor + 1f) {
                // Shaders.univ.radius = radius

                Fill.circle(30f, x, y)
                Draw.flush()
            }

            Draw.z(z)
            Draw.rect(region, x, y)
        }
    }
}
