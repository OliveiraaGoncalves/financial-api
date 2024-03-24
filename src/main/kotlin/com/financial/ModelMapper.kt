import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

object ModelMapper {

    fun <Source : Any, Target : Any> map(source: Source, targetClass: KClass<Target>): Target {
        val sourcePropertiesByName = source::class.memberProperties.associateBy { it.name }

        val constructor = targetClass.constructors.first()

        val args = constructor.parameters.associateWith { parameter ->
            val sourceProperty = sourcePropertiesByName[parameter.name]
            val value = sourceProperty?.getter?.call(source)
            value
        }

        return constructor.callBy(args)
    }
}

inline fun <reified Target : Any> Any.toEntity(): Target {
    return ModelMapper.map(this, Target::class)
}

inline fun <reified Target : Any> Any.toDTO(): Target {
    return ModelMapper.map(this, Target::class)
}