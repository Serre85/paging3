// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id ("com.android.application") version "8.1.4" apply false
    id ("com.android.library") version "8.1.4" apply false
    id ("org.jetbrains.kotlin.android") version "1.8.21" apply false
    id ("com.google.dagger.hilt.android") version "2.44" apply false
    id ("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
}
true