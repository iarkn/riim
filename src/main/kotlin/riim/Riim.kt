package riim

import arc.*
import arc.input.*

import mindustry.*
import mindustry.game.EventType.*
import mindustry.mod.*

import riim.content.*
import riim.gfx.*

class Riim : Mod() {
    init {
        if (!Vars.headless) {
            Events.on(ClientLoadEvent::class.java) {
                UI.load()
            }

            Events.on(FileTreeInitEvent::class.java) {
                Core.app.post {
                    Shaders.load()
                    Renderer.load()
                }
            }

            if (!Vars.mobile) {
                Events.run(Trigger.update) {
                    if (Vars.state.isGame() && Core.input.keyTap(KeyCode.f10)) {
                        UI.modDialog.show()
                    }
                }
            }
        }

        Vars.enableConsole = true
    }

    override fun loadContent() {
        RiimBlocks.load()
    }
}
