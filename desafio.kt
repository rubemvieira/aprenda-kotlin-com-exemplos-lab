// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
val usuarios = mutableListOf<Usuario>()
val conteudosEducacionais = mutableListOf<ConteudoEducacional>()
val formacoes = mutableListOf<Formacao>()

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario (val nome: String, val id: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60) {
    override fun toString(): String {
        return "Nome: $nome ($duracao h)"
    }
}
fun buscarConteudos(vararg conteudos: String): List<ConteudoEducacional> {
    return conteudosEducacionais.filter { c -> conteudos.contains(c.nome) }.toList()
}

fun buscarUsuarios(vararg alunos: String): List<Usuario> {
    return usuarios.filter { u -> alunos.contains(u.nome) }.toList()
}

fun matricularUsuarios(vararg alunos: String, formacao: String) {
    buscarUsuarios(*alunos).forEach{u -> formacoes.find { it.nome == formacao }?.matricular(u)}
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
    }

    override fun toString(): String {
        return "Nome: $nome ($nivel) Conteudos: $conteudos Inscritos: $inscritos"
    }


}

fun main() {
    conteudosEducacionais.add(ConteudoEducacional("Kotlin"))
    conteudosEducacionais.add(ConteudoEducacional("Java"))
    conteudosEducacionais.add(ConteudoEducacional("Programação Orientada a Objetos"))
    formacoes.add(Formacao(nome = "Formação em kotlin", nivel = Nivel.INTERMEDIARIO, conteudos =  buscarConteudos("Kotlin","Programação Orientada a Objetos", "Lógica de Programação") ))
    println(formacoes)
    usuarios.add(Usuario("Rubem",1))
    usuarios.add(Usuario("Regina",2))
    usuarios.add(Usuario("Rafael",3))
    matricularUsuarios("Rubem","Rafael", formacao = "Formação em kotlin")
    println(formacoes)
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
