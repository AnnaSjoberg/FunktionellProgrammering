package InUppg2.Rekursion

class Tomteland {

    data class Elf(val name: String, val underlings: List<Elf> = emptyList())


    private val fullHierarchy: Map<String, Elf>

    init {
        val tg = Elf("Tröger")
        val bg = Elf("Blyger")
        val rd = Elf("Rådjuret")
        val np = Elf("Nyckelpigan")
        val ha = Elf("Haren")
        val dr = Elf("Dammråttan")
        val gs = Elf("Gråsuggan")
        val bl = Elf("Bladlusen")
        val st = Elf("Skumtomten", listOf(dr))
        val my = Elf("Myran", listOf(bl))
        val tt = Elf("Trötter", listOf(st))
        val rä = Elf("Räven", listOf(gs, my))
        val gl = Elf("Glader", listOf(tg, tt, bg))
        val bu = Elf("Butter", listOf(rd, np, ha, rä))
        val t = Elf("Tomten", listOf(gl, bu))

        fullHierarchy = mapOf(
            t.name to t, bu.name to bu, gl.name to gl, rä.name to rä,
            tt.name to tt, tg.name to tg, my.name to my, st.name to st,
            bl.name to bl, gs.name to gs, dr.name to dr, ha.name to ha,
            np.name to np, rd.name to rd, bg.name to bg
        )
    }


    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        if (fullHierarchy.containsKey(currentName)) {
            fullHierarchy.getValue(currentName).underlings.forEach {
                res.add(it.name)
                getUnderlings(it.name, res)
            }
        } else {
            return listOf("Det finns ingen anställd med det namnet")
        }
        return res
    }


}

fun main() {

    val tomteland = Tomteland()

    while (true) {
        var list: MutableList<String> = mutableListOf()
        println("Vem vill du titta på?")
        val inputName = readln().trim()
        println(tomteland.getUnderlings(inputName, list))
    }
}

