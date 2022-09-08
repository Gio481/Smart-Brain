package com.example.smartbraincomponents.extension

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigatorHolder
import org.koin.android.ext.android.getKoin
import org.koin.core.qualifier.StringQualifier
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

internal fun Fragment.injectNavigatorHolder(
    mode: LazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED,
) = lazy(mode) { getKoin().getOrNull<SBNavigatorHolder>(getFeatureQualifier()) }

private fun Any.getFeatureQualifier() = StringQualifier(this::class.java.toString())


fun <T : ViewBinding> Fragment.viewBinding(factory: (View) -> T): ReadOnlyProperty<Fragment, T> =
    object : ReadOnlyProperty<Fragment, T>, DefaultLifecycleObserver {
        private var binding: T? = null

        override fun getValue(thisRef: Fragment, property: KProperty<*>): T =
            binding ?: factory(requireView()).also {
                // if binding is accessed after Lifecycle is DESTROYED, create new instance, but don't cache it
                if (viewLifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
                    viewLifecycleOwner.lifecycle.addObserver(this)
                    binding = it
                }
            }

        override fun onDestroy(owner: LifecycleOwner) {
            binding = null
        }
    }