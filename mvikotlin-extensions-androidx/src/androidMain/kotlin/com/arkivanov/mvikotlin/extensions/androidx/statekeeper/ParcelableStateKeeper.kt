package com.arkivanov.mvikotlin.extensions.androidx.statekeeper

import android.os.Bundle
import android.os.Parcelable
import androidx.savedstate.SavedStateRegistry
import com.arkivanov.mvikotlin.core.statekeeper.ExperimentalStateKeeperApi
import kotlin.reflect.KClass

@ExperimentalStateKeeperApi
internal class ParcelableStateKeeper<T : Parcelable>(
    registry: SavedStateRegistry,
    clazz: KClass<out T>,
    key: String
) : AndroidStateKeeper<T>(registry, clazz, key) {

    override fun <S : T> Bundle.getValue(key: String): S? = getParcelable(key)

    override fun Bundle.putValue(key: String, value: T) {
        putParcelable(key, value)
    }
}
