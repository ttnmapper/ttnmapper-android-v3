package org.ttnmapper.phonesurveyor

import android.util.Log
import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.ttnmapper.phonesurveyor.room.AppDatabase
import org.ttnmapper.phonesurveyor.room.MIGRATION_1_2

@RunWith(AndroidJUnit4::class)
class MigrationsTest {

    private val TEST_DB = "migration-test"

    @get:Rule
    val helper: MigrationTestHelper = MigrationTestHelper(
            InstrumentationRegistry.getInstrumentation(),
            AppDatabase::class.java.canonicalName,
            FrameworkSQLiteOpenHelperFactory()
    )

    @Test
    public fun migrate1To2() {
        helper.createDatabase(TEST_DB, 1).apply {
            // db has schema version 1. insert some data using SQL queries.
            // You cannot use DAO classes because they expect the latest schema.
            execSQL("INSERT INTO link (session) VALUES( \"test session\" );")
            execSQL("INSERT INTO gateway (gtwId) VALUES( \"test gateway\" );")

            // Prepare for the next version.
            close()
        }

        // Re-open the database with version 2 and provide
        // MIGRATION_1_2 as the migration process.
        val db = helper.runMigrationsAndValidate(TEST_DB, 2, true, MIGRATION_1_2)

        // MigrationTestHelper automatically verifies the schema changes,
        // but you need to validate that the data was migrated properly.
        val cursor = db.query("SELECT * FROM link")
        val columns = cursor?.getColumnNames()
        var textContent = ""
        columns?.forEach {
            textContent += it.toString() + ","
        }
        Log.e("Migrate", textContent)
        while (cursor!!.moveToNext()) {
            var line = ""
            for (i in 0 until cursor.getColumnCount() - 1) {
                line += cursor.getString(i) + ","
            }
            line.dropLast(1)
            Log.e("Migrate", line)
        }
    }
}