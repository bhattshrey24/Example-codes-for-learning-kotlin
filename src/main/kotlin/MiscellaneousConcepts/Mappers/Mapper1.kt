package MiscellaneousConcepts.Mappers

//todo (JUST FOR HIGHLIGHTING)
// Before understanding Mappers we will first understand something about Interface
// When one interface inherits from another then it the duty of the implementation class to implement
// functions of both father and parent methods

interface GrandFather {
    fun grandFatherFun(generationCode: Int)
}

interface Father : GrandFather {
    fun fatherFun(generationCode: Int)
}

interface Child : Father {
    fun childFun(generationCode: Int)
}

class ChildImpl() : Child {
    override fun childFun(generationCode: Int) {
        TODO("Not yet implemented")
    }

    override fun fatherFun(generationCode: Int) {
        TODO("Not yet implemented")
    }

    override fun grandFatherFun(generationCode: Int) {
        TODO("Not yet implemented")
    }
}
class FatherImpl() : Father {
    override fun fatherFun(generationCode: Int) {
        TODO("Not yet implemented")
    }

    override fun grandFatherFun(generationCode: Int) {
        TODO("Not yet implemented")
    }
}

// If father has method but child does not then also child's implementation class will have to
// implement function of father interface

interface Child2 : GrandFather
class ChildImpl2() : Child2{
    override fun grandFatherFun(generationCode: Int) {
        TODO("Not yet implemented")
    }
}