package iarkn.riim

import arc.util.*

import iarkn.riim.content.*

import mindustry.*
import mindustry.mod.*

class Riim : Mod() {
    override fun init() {
        Vars.enableConsole = true
    }

    override fun loadContent() {
        RiimBlocks.load()
    }
}
