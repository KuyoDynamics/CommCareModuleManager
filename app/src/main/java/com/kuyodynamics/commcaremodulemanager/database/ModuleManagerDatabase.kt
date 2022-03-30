package com.kuyodynamics.commcaremodulemanager.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kuyodynamics.commcaremodulemanager.database.dao.*
import com.kuyodynamics.commcaremodulemanager.database.entities.*

@Database(
    entities = [CommCareApp::class, CommCareModule::class, CommCareForm::class, CommCareQuestion::class, CommCareUser::class, SurveyManagerTable::class],
    version = 1,
    exportSchema = false
)
abstract class ModuleManagerDatabase : RoomDatabase() {

    // refs to DAOs
    abstract val commCareAppDAO: CommCareAppDAO
    abstract val commCareModuleDAO: CommCareModuleDAO
    abstract val commCareFormDAO: CommCareFormDAO
    abstract val commCareQuestionDAO: CommCareQuestionDAO
    abstract val commCareUserDAO: CommCareUserDAO
    abstract val surveyManagerTableDAO: SurveyManagerTableDAO

    // The companion object allows clients to access the methods for creating or getting the database without instantiating the class.
    companion object {

        @Volatile
        private var INSTANCE: ModuleManagerDatabase? = null

        fun getInstance(context: Context): ModuleManagerDatabase {
            synchronized(this) {
                // Kotlin smart cast feature
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ModuleManagerDatabase::class.java,
                        "module_manager_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}