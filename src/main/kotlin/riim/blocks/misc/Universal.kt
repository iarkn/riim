package riim.blocks.misc

import arc.graphics.g2d.*

import kotlin.math.max

import mindustry.gen.*
import mindustry.graphics.*
import mindustry.logic.*
import mindustry.world.*

import riim.gfx.Shaders

class Universal(name: String) : Block(name) {
    val radius = 8f * 24f

    init {
        update = true
        solid = true
        sync = true
    }

    override fun init() {
        clipSize = max(clipSize, radius * 2f)
        super.init()
    }

    inner class UniversalBuild : Building(), Ranged {
        override fun draw() {
            val z = Draw.z()

            Draw.z(Layer.floor + 1f)
            Fill.poly(x, y, 8, radius)

            Draw.z(z)
            Draw.rect(region, x, y)
        }

        override fun range() = radius
    }
}
