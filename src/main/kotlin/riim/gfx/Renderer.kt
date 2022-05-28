package riim.gfx

import arc.*
import arc.graphics.*
import arc.graphics.g2d.*
import arc.graphics.gl.*

import mindustry.game.EventType.*
import mindustry.graphics.*

import riim.gfx.*

object Renderer {
    val fbo = FrameBuffer()

    fun load() {
        Events.run(Trigger.preDraw) {
            fbo.resize(Core.graphics.getWidth(), Core.graphics.getHeight())
        }

        Events.run(Trigger.draw) { draw() }
    }

    fun draw() {
        Draw.drawRange(Layer.floor + 1f, { fbo.begin(Color.clear) }, {
            fbo.end()
            fbo.blit(Shaders.univ)
        })
    }
}
