import dev.kord.core.builder.kord.KordBuilder
import dev.kord.core.event.Event
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.event.user.UserUpdateEvent
import dev.kord.core.on
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.gateway.Intents
import dev.kord.gateway.PrivilegedIntent
import io.github.cdimascio.dotenv.dotenv
import mu.KotlinLogging

suspend fun main(args: Array<String>) {
    println("Program arguments: ${args.joinToString()}")

    val log = KotlinLogging.logger {  }
    val dotenv = dotenv()
    val kordBuilder = KordBuilder(dotenv["TOKEN"])
    kordBuilder.defaultStrategy = EntitySupplyStrategy.cacheWithRestFallback
    val kord = kordBuilder.build()

    kord.on<MessageCreateEvent> {
    }

    kord.on<UserUpdateEvent> {
    }

    kord.on<Event> {
    }

    kord.login {
        @OptIn(PrivilegedIntent::class)
        intents = Intents.all
    }
}