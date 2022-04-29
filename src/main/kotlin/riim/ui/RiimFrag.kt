package riim.ui

import arc.scene.*

import mindustry.gen.*
import mindustry.ui.*
import mindustry.ui.fragments.*

import riim.*

class RiimFrag : Fragment() {
    override fun build(parent: Group) {
        // Main button at middle-left
        parent.fill { t ->
            t.name = "riim-trigger"
            t.left()
            t.button(Icon.trash, Styles.clearTransi) { UI.modDialog.show() }.size(48f)
        }
    }
}
