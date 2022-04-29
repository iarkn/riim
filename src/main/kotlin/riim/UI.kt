package riim

import mindustry.*

import riim.ui.*
import riim.ui.dialogs.*

object UI {
    lateinit var modDialog: RiimDialog

    lateinit var riimFrag: RiimFrag

    fun load() {
        modDialog = RiimDialog("Riim")

        riimFrag = RiimFrag()
        riimFrag.build(Vars.ui.hudGroup)
    }
}
