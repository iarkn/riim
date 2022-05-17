package riim.gfx

import arc.*
import arc.graphics.g2d.*
import arc.graphics.gl.*

import mindustry.game.EventType.*
import mindustry.graphics.*

import riim.gfx.*

object Renderer {
    fun load() {
        Events.run(Trigger.draw) { draw() }
    }

    fun draw() {
        // TODO: Will this die if other mods use the same layer?
        Draw.drawRange(
            Layer.floor + 1f,
            { Draw.shader(Shaders.univ) },
            { Draw.shader() },
        )
    }
}
