import org.nuna.NunaContext

fun main(args: Array<String>) {
    val context = NunaContext.create()

    val res = context.eval('누..')

    println(res.stack)
}