package riim.ui.dialogs

import arc.scene.ui.layout.*

import mindustry.ui.dialogs.*

class RiimDialog(title: String) : BaseDialog(title) {
    init {
        cont.pane() { p ->
            p.add("I'd just like to interject for a moment.")
        }

        addCloseButton()
    }
}
