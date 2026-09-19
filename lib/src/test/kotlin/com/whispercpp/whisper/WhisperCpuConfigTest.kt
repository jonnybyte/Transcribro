package com.whispercpp.whisper

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.MockedStatic
import org.mockito.Mockito

class WhisperCpuConfigTest {

    @Test
    fun `preferredThreadCount is at least 1`() {
        // android.util.Log is an Android class; mock it to avoid RuntimeException on JVM
        val logMock: MockedStatic<android.util.Log> = Mockito.mockStatic(android.util.Log::class.java)
        logMock.use {
            val count = WhisperCpuConfig.preferredThreadCount
            assertTrue(count >= 1, "preferredThreadCount should be at least 1, but was $count")
        }
    }

    @Test
    fun `preferredThreadCount does not exceed reasonable maximum`() {
        val logMock: MockedStatic<android.util.Log> = Mockito.mockStatic(android.util.Log::class.java)
        logMock.use {
            val count = WhisperCpuConfig.preferredThreadCount
            assertTrue(count in 1..256, "preferredThreadCount seems unreasonable: $count")
        }
    }

    @Test
    fun `preferredThreadCount is consistent across multiple calls`() {
        val logMock: MockedStatic<android.util.Log> = Mockito.mockStatic(android.util.Log::class.java)
        logMock.use {
            val first = WhisperCpuConfig.preferredThreadCount
            val second = WhisperCpuConfig.preferredThreadCount
            assertTrue(first == second, "preferredThreadCount should be consistent: $first vs $second")
        }
    }
}
