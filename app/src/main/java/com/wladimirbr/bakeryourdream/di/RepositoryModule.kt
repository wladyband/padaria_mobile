package com.wladimirbr.bakeryourdream.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.wladimirbr.bakeryourdream.data.remote.BackEndAPI
import com.wladimirbr.bakeryourdream.data.repository.DataStoreOperationsImpl
import com.wladimirbr.bakeryourdream.data.repository.RepositoryImpl
import com.wladimirbr.bakeryourdream.domain.repository.DataStoreOperations
import com.wladimirbr.bakeryourdream.domain.repository.Repository
import com.wladimirbr.bakeryourdream.utils.Constants

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStorePreferences(
        @ApplicationContext context: Context
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = { context.preferencesDataStoreFile(Constants.PREFERENCES_NAME) }
        )
    }

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        dataStore: DataStore<Preferences>
    ): DataStoreOperations {
        return DataStoreOperationsImpl(dataStore = dataStore)
    }

    @Provides
    @Singleton
    fun provideRepository(
        dataStoreOperations: DataStoreOperations,
        BackEndAPI: BackEndAPI
    ): Repository {
        return RepositoryImpl(
            dataStoreOperations = dataStoreOperations,
            BackEndAPI = BackEndAPI
        )
    }

}