package com.arkivanov.mvikotlin.core.statekeeper

import kotlin.reflect.KClass

/**
 * Creates a new instance of [StateKeeperContainer]
 *
 * @param get a function that returns a value from a state by key
 * @param put a function that puts a value into a state by key
 *
 */
@Suppress("FunctionName") // Factory function
fun <State : Any, T : Any> StateKeeperContainer(
    get: (state: State, key: String, clazz: KClass<out T>) -> T?,
    put: (state: State, key: String, clazz: KClass<out T>, value: T) -> Unit
): StateKeeperContainer<State, T> =
    StateKeeperContainerImpl(get = get, put = put)
