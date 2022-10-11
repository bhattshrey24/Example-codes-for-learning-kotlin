package MiscellaneousConcepts.Mappers

import MiscellaneousConcepts.Mappers.models.ModelA
import MiscellaneousConcepts.Mappers.models.ModelB

// Simply mapping one type of object to another
fun main() {
    var modelAOb = ModelA(1, "aA", "tA", "nA", "dA")

    // Method 1 (Using Class)
    var mapper = MapperModelAToB()
    var modelBOb = mapper.map(modelAOb)
    println("Model B : $modelBOb")

    // Method 2 (Using Function)
    var modelBOb2 = mapperModelAToBFun(modelAOb)
    println("Model B : $modelBOb2")
}

class MapperModelAToB() : Mapper<ModelA, ModelB> {
    override fun map(input: ModelA): ModelB {
        return ModelB(
            id = input.id, nameOfArticle = input.nameOfArticle, time = input.time
        )
    }
}

fun mapperModelAToBFun(input: ModelA): ModelB { // you can make this
// as an extension function to data class of ModelA
    return ModelB(
        id = input.id,
        time = input.time,
        nameOfArticle = input.nameOfArticle
    )
}