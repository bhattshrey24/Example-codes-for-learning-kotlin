package MiscellaneousConcepts.Mappers

import MiscellaneousConcepts.Mappers.models.ModelA
import MiscellaneousConcepts.Mappers.models.ModelB

// Here I'm showing how we can map using Functional Programming
// Using Functional Programming we can remove the need of interface in
// mapping and reduce boilerplate code

fun main() {
    var listOfModelA = getListOfModelA()
    var mappedListOfModelB = mapList(listOfModelA) {
        ModelB(
            nameOfArticle = it.nameOfArticle,
            id = it.id,
            time = it.time
        )
    }

    for (modelB in mappedListOfModelB) {
        println("id : ${modelB.id} , time : ${modelB.time} , nameOfArticle : ${modelB.nameOfArticle}")
    }

}

private inline fun <I, O> mapList(input: List<I>, mapSingle: (I) -> O): List<O> { // inline
// because it is a small function .  Here we are simply taking "mapSingle" like a black box which maps
// object from type I to Type O
    return input.map { mapSingle(it) }
}

// Nullable to Non-nullable
private inline fun <I, O> mapNullInputList(input: List<I>?, mapSingle: (I) -> O): List<O> {
    return input?.map { mapSingle(it) } ?: emptyList()
}

// Nullable to Nullable
private inline fun <I, O> mapNullOutputList(input: List<I>, mapSingle: (I) -> O): List<O>? {
    return if (input.isEmpty()) null else input.map { mapSingle(it) }
}