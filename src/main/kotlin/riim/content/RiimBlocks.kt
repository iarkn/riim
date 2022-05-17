package riim.content

import mindustry.content.*
import mindustry.ctype.*
import mindustry.type.*
import mindustry.world.*

import riim.blocks.misc.*

object RiimBlocks {
    lateinit var universal: Block

    fun load() {
        universal = Universal("universal").apply {
            requirements(Category.effect, ItemStack.with(
                Items.copper, 1200,
                Items.lead, 1350,
                Items.silicon, 1150,
            ))
            size = 4
        }
    }
}
