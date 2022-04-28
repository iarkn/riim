package riim

import riim.ui.dialogs.*

object UI {
    lateinit var modDialog: RiimDialog

    fun load() {
        modDialog = RiimDialog("Riim")
    }
}
