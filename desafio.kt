enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(var nome: String, var formacao: Formacao)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} matriculado")
        for (inscrito in inscritos){
            println("${usuario.nome} esta na formacao ${usuario.formacao}")
        }
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    }
}

fun main() {
    val kotlin = ConteudoEducacional("Kotlin", 60, Nivel.DIFICIL)
    val swiftCont = ConteudoEducacional("Swift", 60, Nivel.BASICO)
    val cont = listOf(kotlin, swiftCont)
    var form = Formacao( "Kotlin", cont)
    var ju = Usuario("Júlia",  form)
    var gui = Usuario("Guilherme",  form)

    print(form.matricular(ju))
    print(form.matricular(gui))
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}