package MiscellaneousConcepts.Mappers

import MiscellaneousConcepts.Mappers.models.ModelA
import MiscellaneousConcepts.Mappers.models.ModelB

// Here I'm showing Object-Oriented way of mapping objects
fun main() {

    var listOfModelA = getListOfModelA() // mimicking Api call and receiving data

    var listMapperImpl =
        ListMapperImpl<ModelA, ModelB>(object : Mapper<ModelA, ModelB> { // this is how we give on the fly
            // implementation to the Mapper
            override fun map(input: ModelA): ModelB {
                return ModelB(
                    id = input.id,
                    nameOfArticle = input.nameOfArticle,
                    time = input.time
                )
            }
        })// ListMapper will handle the
    // case of converting List of type ModelA to ModelB but it needs a mapper that
    // converts object of type ModelA to ModelB which is what this on the fly implementation which we passed
    // as constructor argument is doing. Now since mapping from DTO to Domain object and vice versa
    // is done in Repository therefore we pass this as argument to repository and simply use .map()

    var mappedListOfModelB = listMapperImpl.map(listOfModelA)// Now our list Mapper is ready and we
    // can use it's map function to map listOfModelA to listOfModelB

    for (modelB in mappedListOfModelB) {
        println("id : ${modelB.id} , time : ${modelB.time} , nameOfArticle : ${modelB.nameOfArticle}")
    }

    // You can also give use normal implementation class instead of on the fly implementation as shown below
    var listMapperImpl2 = ListMapperImpl(MapModelAToModelB())
    var mappedListOfModelB2 = listMapperImpl2.map(listOfModelA)

    for (modelB in mappedListOfModelB2) {
        println("id : ${modelB.id} , time : ${modelB.time} , nameOfArticle : ${modelB.nameOfArticle}")
    }
}

fun getListOfModelA(): List<ModelA> {
    return listOf<ModelA>(
        ModelA(1, "aA", "tA", "nA", "dA"),
        ModelA(2, "aB", "tB", "nB", "dB"),
        ModelA(3, "aC", "tC", "nC", "dC"),
        ModelA(4, "aD", "tD", "nD", "dD"),
    )
}

// Maps Non-nullable to Non-nullable
interface ListMapper<I, O> : Mapper<List<I>, List<O>> //carefully observe this interface, we
// are inheriting from general "Mapper" interface but here we are telling that the type of
// this "Mapper" will be List<I> and List<O> which is cool since it takes generic which can be
// anything

class ListMapperImpl<I, O>(
    private val mapper: Mapper<I, O> //This takes implementation class
    // of "Mapper" interface. Take it as black box . i.e. it magically
    // maps objects of type I to type O
) : ListMapper<I, O> {
    override fun map(input: List<I>): List<O> {
        return input.map { // since input is List therefore we can use "map" over it
            mapper.map(it) // what we are doing is that we are giving responsibility of
            // mapping this current list element i.e. "it" to "mapper" that
            // we passed as an argument. What this "mapper" will do is that it will take "it" which
            // is of type "I" and convert it to type "O"
        }
    }
}

// Nullable to Non-nullable
interface NullableInputListMapper<I, O> : Mapper<List<I>?, List<O>>

class NullableInputListMapperImpl<I, O>(
    private val mapper: Mapper<I, O>
) : NullableInputListMapper<I, O> {
    override fun map(input: List<I>?): List<O> {
        return input?.map {
            mapper.map(it)
        }?: emptyList() // now here if input list is null then this function
        // will return empty list
    }
}

// Non-nullable to Nullable
interface NullableOutputListMapper<I, O> : Mapper<List<I>, List<O>?>

class NullableOutputListMapperImpl<I, O>(
    private val mapper: Mapper<I, O>
) : NullableOutputListMapper<I, O> {
    override fun map(input: List<I>): List<O>? {
        return if (input.isNullOrEmpty()) null else input.map { mapper.map(it) } // here since we can have
        // nullable list as output, so it's quite simple . If input list is null then simply return null else
        // simply map
    }
}

class MapModelAToModelB() : Mapper<ModelA, ModelB> {
    override fun map(input: ModelA): ModelB {
        return ModelB(
            id = input.id,
            nameOfArticle = input.nameOfArticle,
            time = input.time
        )
    }

}
