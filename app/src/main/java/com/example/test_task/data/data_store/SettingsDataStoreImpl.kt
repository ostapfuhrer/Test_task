package com.example.test_task.data.data_store

import javax.inject.Inject

//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
class SettingsDataStoreImpl @Inject constructor(
    //@ApplicationContext val context: Context,
) : SettingsDataStore {
}