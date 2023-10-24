package com.wladimirbr.bakeryourdream.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import androidx.datastore.preferences.core.*
import com.wladimirbr.bakeryourdream.domain.repository.DataStoreOperations
import com.wladimirbr.bakeryourdream.utils.Constants

class DataStoreOperationsImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : DataStoreOperations {

    private object PreferencesKey {
        val signedInKey = booleanPreferencesKey(name = Constants.PREFERENCES_SIGNED_IN_KEY)
    }

    override suspend fun saveSignedInState(signedIn: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.signedInKey] = signedIn
        }
    }

    override fun readSignedInState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val signedInState = preferences[PreferencesKey.signedInKey] ?: false
                signedInState
            }
    }
}