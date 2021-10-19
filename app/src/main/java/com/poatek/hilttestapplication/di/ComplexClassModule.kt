package com.poatek.hilttestapplication.di

import com.poatek.hilttestapplication.models.MyComplexClass
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.components.SingletonComponent

/*
If you use this module:
- MyComplexClass injection will be available on the entire app
- Injected MyComplexClasses will have different instances
 */
@Module
@InstallIn(SingletonComponent::class)
object ComplexClassModule {
    @Provides
    fun provideComplexClass() = MyComplexClass("Test")
}

/*
If you use this module:
- MyComplexClass injection will be available on the entire app
- All injected MyComplexClasses will be THE SAME instance, on the entire app
 */
//@Module
//@InstallIn(SingletonComponent::class)
//object ComplexClassModule {
//
//    @Provides
//    @Singleton
//    fun provideComplexClass() = MyComplexClass("Test")
//
//}

/*
If you use this module:
- MyComplexClass injection will be available starting from the activity level
- Injected MyComplexClasses will have different instances
 */
//@Module
//@InstallIn(ActivityComponent::class)
//object ComplexClassModule {
//
//    @Provides
//    fun provideComplexClass() = MyComplexClass("Test")
//
//}

/*
If you use this module:
- MyComplexClass injection will be available starting from the activity level
- Each activity will have a different instance of MyComplexClass, but the same instance will be shared
between an activity and its children. In this case, you will notice the fragment and the activity
will have the same instance.
 */
//@Module
//@InstallIn(ActivityComponent::class)
//object ComplexClassModule {
//
//    @Provides
//    @ActivityScoped
//    fun provideComplexClass() = MyComplexClass("Test")
//
//}

/*
If you use this module:
- MyComplexClass injection will be available starting from the activity level
- Same thing as the previous example, but if you rotate the screen now,
the dependencies will keep the same instance.
 */
//@Module
//@InstallIn(ActivityRetainedComponent::class)
//object ComplexClassModule {
//
//    @Provides
//    @ActivityRetainedScoped
//    fun provideComplexClass() = MyComplexClass("Test")
//
//}

/*
If you use this module:
- The project won't compile, because there is a MyComplexClass being injected in an activity.

If you comment the @Inject inside the activity class, project will compile. Now:
- MyComplexClass injection will be available starting from the fragment level
- Each fragment will have a different instance of the MyComplexClass
 */
//@Module
//@InstallIn(FragmentComponent::class)
//object ComplexClassModule {
//
//    @Provides
//    fun provideComplexClass() = MyComplexClass("Test")
//
//}