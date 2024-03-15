import java.util.Scanner

data class Item(val nome: String, val preco: Double)

class CaixaRegistradora {
    private val itens = mutableListOf<Item>()

    fun adicionarItem(item: Item) {
        itens.add(item)
    }

    fun calcularTotal(): Double {
        var total = 0.0
        for (item in itens) {
            total += item.preco
        }
        return total
    }

    fun finalizarCompra() {
        val total = calcularTotal()
        println("Total da compra: R$$total")
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val caixa = CaixaRegistradora()

    while (true) {
        println("1. Adicionar item")
        println("2. Finalizar compra")
        println("3. Sair")
        print("Escolha uma opção: ")

        when (val opcao = scanner.nextInt()) {
            1 -> {
                print("Nome do item: ")
                val nome = scanner.next()
                print("Preço do item: ")
                val preco = scanner.nextDouble()
                caixa.adicionarItem(Item(nome, preco))
            }
            2 -> {
                caixa.finalizarCompra()
                break
            }
            3 -> {
                println("Saindo...")
                break
            }
            else -> println("Opção inválida.")
        }
    }
}
