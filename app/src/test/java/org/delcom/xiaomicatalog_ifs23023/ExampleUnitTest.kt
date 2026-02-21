// androidTest/org.delcom.xiaomicatalog_ifs23036/ExampleInstrumentedTest.kt
package org.delcom.xiaomicatalog_ifs23023

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("org.delcom.xiaomicatalog_ifs23023", appContext.packageName)
    }
}

// test/org.delcom.xiaomicatalog_ifs23036/ExampleUnitTest.kt
package org.delcom.xiaomicatalog_ifs23023

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}