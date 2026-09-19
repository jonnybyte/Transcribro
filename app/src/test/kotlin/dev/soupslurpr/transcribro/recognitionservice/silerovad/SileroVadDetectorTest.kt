package dev.soupslurpr.transcribro.recognitionservice.silerovad

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Tests for [SileroVadDetector].
 *
 * Note: Tests that exercise the VAD logic (apply, reset, close) require the ONNX
 * runtime native library and a real model, which are not available in a JVM unit-test
 * environment. Those tests are written as instrumented (androidTest) tests or require
 * the ONNX Java runtime as a test dependency. The tests below cover only the
 * constructor validation that happens before the model is loaded.
 */
class SileroVadDetectorTest {

    @Test
    fun `constructor throws for invalid sampling rate 44100`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            SileroVadDetector(
                modelBytes = byteArrayOf(),
                startThreshold = 0.5f,
                endThreshold = 0.3f,
                samplingRate = 44100,
                minSilenceDurationMs = 500,
                speechPadMs = 100
            )
        }
    }

    @Test
    fun `constructor throws for invalid sampling rate 32000`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            SileroVadDetector(
                modelBytes = byteArrayOf(),
                startThreshold = 0.5f,
                endThreshold = 0.3f,
                samplingRate = 32000,
                minSilenceDurationMs = 500,
                speechPadMs = 100
            )
        }
    }

    @Test
    fun `constructor throws for invalid sampling rate 22050`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            SileroVadDetector(
                modelBytes = byteArrayOf(),
                startThreshold = 0.5f,
                endThreshold = 0.3f,
                samplingRate = 22050,
                minSilenceDurationMs = 500,
                speechPadMs = 100
            )
        }
    }
}
