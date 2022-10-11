package MiscellaneousConcepts.Mappers

interface Mapper<I, O> { // this simply tells concept of mappers i.e. what mappers do ie. as
    // you can see it maps from
    // one type(ie. I) to another (ie. O)
    fun map(input: I): O // See it takes input of type I and returns output of type O
}