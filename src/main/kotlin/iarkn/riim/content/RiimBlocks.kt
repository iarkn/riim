package iarkn.riim.content

import mindustry.content.*
import mindustry.type.*
import mindustry.world.blocks.distribution.*

object RiimBlocks {
    lateinit var router: Router

    fun load() {
        router = Router("real-router").apply {
            requirements(Category.distribution, ItemStack.with(Items.copper, 33, Items.lead, 36))
            speed = 32f
        }
    }
}
