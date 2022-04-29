package riim

import arc.*
import arc.input.*

import mindustry.*
import mindustry.game.EventType.*
import mindustry.mod.*

class Riim : Mod() {
    init {
        Events.on(ClientLoadEvent::class.java) {
            UI.load()
        }

        if (!Vars.mobile) {
            Events.run(Trigger.update) {
                if (Vars.state.isGame() && Core.input.keyTap(KeyCode.f10)) {
                    UI.modDialog.show()
                }
            }
        }
    }

    override fun init() {
        Vars.enableConsole = true
    }
}
